package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.sun.tools.javac.Main;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;
import org.firstinspires.ftc.teamcode.core.lib.uGamepad.Button;
import org.firstinspires.ftc.teamcode.core.lib.uGamepad.uGamepad;

@TeleOp
public class Teleop1 extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        MainRobot mainRobot = new MainRobot();
        mainRobot.Init(hardwareMap, telemetry);
        uGamepad mainGamepad = new uGamepad(gamepad1);


        mainGamepad.A.ScheduleAction(new Action(()->{
            telemetry.addLine("Just Pressed");
            sleep(1000);
        }), Button.buttonStates.JUST_PRESSED);
        mainGamepad.A.ScheduleAction(new Action(()->{
            telemetry.addLine("Just Released");
            sleep(1000);
        }), Button.buttonStates.JUST_RELEASED);


        waitForStart();

        while (!isStopRequested()){
            mainGamepad.Periodic();

            mainRobot.Periodic(telemetry);
        }
    }
}
