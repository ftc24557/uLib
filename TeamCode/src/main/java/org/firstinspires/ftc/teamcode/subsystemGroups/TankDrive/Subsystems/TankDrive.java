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

public class TankDrive extends Subsystem {
    DcMotor l;
    DcMotor r;
    double d = 0;
    double t = 0;
    Telemetry tlmt;
    @Override
    public void Init(HardwareMap hardwareMap, Telemetry telemetry) {

        l = hardwareMap.get(DcMotor.class, TankDriveConstants.HMl);
        r = hardwareMap.get(DcMotor.class, TankDriveConstants.HMr);
        l.setDirection(DcMotorSimple.Direction.REVERSE);

    }





    public void SetVecs(double drive,double turn){
        d = drive;
        t = turn;
    }


    @Override
    public void Periodic() {
        l.setPower(d+t);
        r.setPower(d-t);
    }
}
