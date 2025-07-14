package org.firstinspires.ftc.teamcode.core.Navigation;

import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public interface Localizer {
    void Periodic();
    Pose2D GetPose();
}
