package org.firstinspires.ftc.teamcode.subsystemGroups.Outtake;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;

import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;

public class Outtake extends SubSystemGroup {
    public static ArmSub arm;
    public static ClawSub claw;
    public Outtake(){
        arm = new ArmSub();
        claw = new ClawSub();

        Subsystem[] subsystems = {
            arm,
            claw
        };

        scheduleSubsystems(subsystems);
    }

    @Override
    public void GroupPeriodic(Telemetry telemetry) {

    }
    public void toCatch(){
        arm.Intake();
        claw.Open();
    }
    public void toScore(){
        claw.Close();
        Action toScoreAction = new Action(()->{
            arm.Outtake();
        });
        toScoreAction.Run(500);
    }
}
