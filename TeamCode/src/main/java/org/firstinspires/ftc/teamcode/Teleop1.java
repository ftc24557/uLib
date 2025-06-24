package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class Teleop1 extends LinearOpMode {


    @Override
    public void runOpMode(){

        MainRobot mainRobot = new MainRobot();
        mainRobot.Init(hardwareMap, telemetry);

        waitForStart();

        while (!isStopRequested()){
            mainRobot.Periodic(telemetry);
        }
    }
}
