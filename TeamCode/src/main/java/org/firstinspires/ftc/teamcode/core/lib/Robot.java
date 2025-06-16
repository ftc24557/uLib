package org.firstinspires.ftc.teamcode.core.lib;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;

public abstract class Robot {
    SubSystemGroup[] subSystemGroups;
    public Robot(SubSystemGroup[] setSubSystemGroups){
        subSystemGroups = setSubSystemGroups;
    }
    public void Init(HardwareMap hardwareMap, Telemetry telemetry){
        for (SubSystemGroup subSystemGroup : subSystemGroups){
            subSystemGroup.InitSubsystems(hardwareMap, telemetry);
        }
    }
    public void Periodic(Telemetry telemetry){
        for (SubSystemGroup subSystemGroup : subSystemGroups){
            subSystemGroup.Periodic(telemetry);
        }
    }
    public void SetAutonomousMode(){}
    public void SetTeleOpMode(){}
}
