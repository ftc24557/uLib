package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.core.lib.Robot;
import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;
import org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive.Drivetrain;

public class MainRobot extends Robot {
    public static Drivetrain drive = new Drivetrain();

    public static SubSystemGroup[] subSystemGroups = {
            drive
    };
    public MainRobot() {
        super(subSystemGroups);
    }
}
