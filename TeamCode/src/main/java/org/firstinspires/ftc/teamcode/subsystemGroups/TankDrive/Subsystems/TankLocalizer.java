package org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;
import org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive.TankDriveConstants;

public class TankLocalizer extends Subsystem {
    DcMotor l;
    DcMotor r;
    IMU imu;
    Pose2D pose = new Pose2D(DistanceUnit.MM, 0, 0, AngleUnit.DEGREES, 0); // Inicializa na origem
    double lastR = 0;
    double lastL = 0;
    double avgHeading;
    Telemetry tlmt;
    @Override
    public void Init(HardwareMap hardwareMap, Telemetry telemetry) {
        tlmt = telemetry;
        l = hardwareMap.get(DcMotor.class, TankDriveConstants.HMl);
        r = hardwareMap.get(DcMotor.class, TankDriveConstants.HMr);
        l.setDirection(DcMotorSimple.Direction.REVERSE);
        imu = hardwareMap.get(IMU.class, TankDriveConstants.HMimu);
        Reset();
        ResetEncoders();

        imu.initialize(new IMU.Parameters(
                TankDriveConstants.ImuOrientation
        ));
        imu.resetYaw();
    }

    public Pose2D GetPose() {
        return pose;
    }

    private void ResetEncoders() {
        l.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lastR = 0;
        lastL = 0;
    }

    public void SetPose(Pose2D setPose) {
        imu.resetYaw();
        ResetEncoders();
        pose = setPose;
    }

    public void Reset(){
        ResetEncoders();
        SetPose(new Pose2D(DistanceUnit.MM, 0, 0, AngleUnit.DEGREES, 0));
    }


    private double TicksToMM(double ticks) {
        return (ticks / (TankDriveConstants.EncoderTicksPerRev*TankDriveConstants.GearRelation)) * Math.PI * TankDriveConstants.WheelDiameter;
    }
    private void UpdatePose() {
        double left = l.getCurrentPosition();
        double right = r.getCurrentPosition();

        double deltaLeft = TicksToMM(left - lastL);
        double deltaRight = TicksToMM(right - lastR);

        lastL = left;
        lastR = right;

        avgHeading = Math.toRadians(imu.getRobotYawPitchRollAngles().getYaw());
        double deltaCenter = (deltaRight + deltaLeft) / 2.0;

        double dx = deltaCenter * Math.cos(avgHeading);
        double dy = deltaCenter * Math.sin(avgHeading);

        pose = new Pose2D(
                DistanceUnit.MM,
                pose.getX(DistanceUnit.MM) + dx,
                pose.getY(DistanceUnit.MM) + dy,
                AngleUnit.RADIANS,
                avgHeading
        );
    }

    @Override
    public void Periodic() {
        UpdatePose();

    }
}
