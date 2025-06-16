package org.firstinspires.ftc.teamcode.core.examples;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;
import org.firstinspires.ftc.teamcode.core.lib.StateMachine.State;
import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;

public class OuttakeGroup extends SubSystemGroup {
    public OuttakeGroup(){
        PivotArmOuttake pivotArmOuttake = new PivotArmOuttake();
        ClawOuttake clawOuttake = new ClawOuttake();
        Subsystem[] subsystems = {
                pivotArmOuttake,
                clawOuttake
        };



        State[] states = {
                new State("CATCH", new Action(()->{
                    pivotArmOuttake.PivotToCatch();
                    clawOuttake.Close();
                })),
                new State("SCORE", new Action(()->{
                    pivotArmOuttake.PivotToScore();
                    clawOuttake.Open();
                }))
        };
        scheduleSubsystems(subsystems);
        scheduleStates(states, new Action(()->{}));

    }


    @Override
    public void GroupPeriodic(Telemetry telemetry) {
    }
}
