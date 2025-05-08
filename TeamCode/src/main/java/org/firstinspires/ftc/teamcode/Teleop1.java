package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.sun.tools.javac.Main;
@TeleOp
public class Teleop1 extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        MainRobot mainRobot = new MainRobot();
        mainRobot.Init(hardwareMap, telemetry);


        waitForStart();
        while (!isStopRequested()){
            mainRobot.drive.SetVectors(gamepad1.left_stick_y, gamepad1.right_stick_x);
            mainRobot.Periodic();
        }
    }
}
