package org.firstinspires.ftc.teamcode.core.examples;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;
import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;

public class OuttakeGroup extends SubSystemGroup {
    PivotArmOuttake pivotArmOuttake;
    ClawOuttake clawOuttake;
    public OuttakeGroup(){
         pivotArmOuttake= new PivotArmOuttake();
         clawOuttake= new ClawOuttake();
        Subsystem[] subsystems = {
                pivotArmOuttake,
                clawOuttake
        };

        scheduleSubsystems(subsystems);

    }
    public void ToOuttake(){
        clawOuttake.Close();
        pivotArmOuttake.PivotToScore();
    }
    public void ToIntake(){

        clawOuttake.Open();
        pivotArmOuttake.PivotToCatch();
    }

    @Override
    public void GroupPeriodic(Telemetry telemetry) {
    }
}
