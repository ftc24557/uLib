package org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;
import org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive.Subsystems.TankDrive;
import org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive.Subsystems.TankLocalizer;
public class Drivetrain extends SubSystemGroup {

    public TankLocalizer localizer;
    public TankDrive drive;
    private double d;
    private double t;
    private boolean LinearBusy = false;
    private boolean AngleBusy = false;
    double targetAngle = 0;
    Pose2D targetPose = new Pose2D(DistanceUnit.MM, 0, 0, AngleUnit.DEGREES, 0);

    public Drivetrain() {
        localizer = new TankLocalizer();
        drive = new TankDrive();
        Subsystem[] subsystems = {
                localizer,
                drive
        };
        scheduleSubsystems(subsystems);
    }

    public void SetTargetPose(Pose2D setTargetPose) {
        targetPose = setTargetPose;
    }

    public boolean IsBusy() {
        return LinearBusy || AngleBusy;
    }
    @Override
    public void GroupPeriodic(Telemetry telemetry) {

        Line currentLine = new Line(localizer.GetPose(), targetPose);
        if (currentLine.lengthMM()<20){
            LinearBusy = false;
        } else {
            LinearBusy= true;
        }
        if (LinearBusy) {
            targetAngle = Math.toDegrees(currentLine.angleRadians());
        } else {
            targetAngle = targetPose.getHeading(AngleUnit.DEGREES);
        }
        double deltaAngle =  targetAngle-localizer.GetPose().getHeading(AngleUnit.DEGREES);
        if (Math.abs(deltaAngle)<2){
            AngleBusy = false;
        } else {
            AngleBusy = true;
        }


        if (!AngleBusy) {
            //drive.SetVecs(-currentLine.lengthMM() * 0.02, -deltaAngle * 0.03);
        } else {
            //drive.SetVecs(0, deltaAngle * 0.03);

        }
    }


}
