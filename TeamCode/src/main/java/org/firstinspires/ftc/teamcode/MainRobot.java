package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.core.lib.Robot;
import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;
import org.firstinspires.ftc.teamcode.subsystemGroups.Outtake.Outtake;
import org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive.Drivetrain;

public class MainRobot extends Robot {
    public static Drivetrain drive = new Drivetrain();
    public static Outtake outtake = new Outtake();
    public static SubSystemGroup[] subSystemGroups = {
            outtake
    };
    public MainRobot() {
        super(subSystemGroups);
    }
}
