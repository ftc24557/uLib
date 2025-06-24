package org.firstinspires.ftc.teamcode.core.examples;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;

public class ClawOuttake extends Subsystem {
    Servo servo;
    @Override
    public void Init(HardwareMap hardwareMap, Telemetry telemetry) {
        servo = hardwareMap.get(Servo.class, "");
    }

    public void Close(){
        servo.setPosition(1);
    }
    public void Open(){
        servo.setPosition(0);
    }


    @Override
    public void Periodic() {

    }
}
