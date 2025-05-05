package org.firstinspires.ftc.teamcode.core.lib;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Subsystem {
    public abstract void Init(HardwareMap hardwareMap, Telemetry telemetry);
    public abstract void Periodic();
}
