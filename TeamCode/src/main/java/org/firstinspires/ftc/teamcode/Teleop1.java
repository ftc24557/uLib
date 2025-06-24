package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.sun.tools.javac.Main;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;

@TeleOp
public class Teleop1 extends LinearOpMode {


    @Override
    public void runOpMode(){

        MainRobot mainRobot = new MainRobot();
        mainRobot.Init(hardwareMap, telemetry);

        waitForStart();

        while (!isStopRequested()){
            if (gamepad1.a){
                mainRobot.outtake.toCatch();
            }
            if (gamepad1.b){
                mainRobot.outtake.toScore();
            }
            mainRobot.Periodic(telemetry);
        }
    }
}
