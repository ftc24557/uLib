package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.core.lib.Robot;
import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;

public class MainRobot extends Robot {
    /*
    Instance your subsystem groups here, example:
    public static Drivetrain drive = new Drivetrain();
    */
    public static SubSystemGroup[] subSystemGroups = {
            /*
            Place your SubsystemGroups here, example:
            drive,
            */
    };
    public MainRobot() {
        super(subSystemGroups);
    }
}
