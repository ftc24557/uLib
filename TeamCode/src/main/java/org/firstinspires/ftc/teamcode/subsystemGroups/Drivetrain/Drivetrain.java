package org.firstinspires.ftc.teamcode.subsystemGroups.Drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;

public class Drivetrain extends SubSystemGroup {
    public Drivetrain(){

    }
    private DcMotor lr;
    private DcMotor lf;
    private DcMotor rr;
    private DcMotor rf;
    @Override
    public void InitSubsystems(HardwareMap hardwareMap, Telemetry telemetry){
        lr = hardwareMap.get(DcMotor.class, "leftRear");
        lf = hardwareMap.get(DcMotor.class, "leftFront");
        rr = hardwareMap.get(DcMotor.class, "rightRear");
        rf = hardwareMap.get(DcMotor.class, "rightFront");
    }

    private double d = 0;
    private double t = 0;

    public void SetVectors(double drive, double turn){
        d = drive;
        t = turn;
    }
    @Override
    public void Periodic(){
        lf.setPower(d-t);
        lr.setPower(d-t);
        rr.setPower(-d-t);
        rf.setPower(-d-t);
    }
}
