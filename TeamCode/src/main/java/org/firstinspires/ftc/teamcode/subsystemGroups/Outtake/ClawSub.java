package org.firstinspires.ftc.teamcode.subsystemGroups.Outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawSub extends Subsystem {
    Servo servoClaw;
    @Override
    public void Init(HardwareMap hardwareMap, Telemetry telemetry) {
        servoClaw = hardwareMap.get(Servo.class, OuttakeConstants.HMClaw);
    }
    public void Open(){
        servoClaw.setPosition(OuttakeConstants.OpenedClaw);
    }
    public void Close(){
        servoClaw.setPosition(OuttakeConstants.ClosedClaw);
    }


    @Override
    public void Periodic() {

    }
}
