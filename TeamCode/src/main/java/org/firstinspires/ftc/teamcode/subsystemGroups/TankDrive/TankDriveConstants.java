package org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

public class TankDriveConstants {
    public static String HMl = "left";
    public static String HMr = "right";
    public static String HMimu = "imu";
    public static RevHubOrientationOnRobot ImuOrientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.DOWN);
    public static float GearRelation = 20;
    public static float EncoderTicksPerRev = 28;
    public static float TrackWidth = 370;//milimeters
    public static float WheelDiameter = 90; //milimeters
}
