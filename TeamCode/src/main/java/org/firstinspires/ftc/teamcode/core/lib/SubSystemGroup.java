package org.firstinspires.ftc.teamcode.core.lib;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;

public abstract class SubSystemGroup {
    protected Subsystem[] subsystems;
    public void scheduleSubsystems(Subsystem[] setSubsystems){
        subsystems = setSubsystems;
    }


    public void InitSubsystems(HardwareMap hardwareMap, Telemetry telemetry){
        for (Subsystem subsystem : subsystems){
            subsystem.Init(hardwareMap, telemetry);
        }
    }
    public abstract void GroupPeriodic(Telemetry telemetry);

    public void Periodic(Telemetry telemetry){
        for (Subsystem subsystem : subsystems){
            subsystem.Periodic();
        }
        GroupPeriodic(telemetry);
    }


}
