package org.firstinspires.ftc.teamcode.core.examples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;

public class PivotArmOuttake extends Subsystem {
    DcMotor motor0;
    int targetPosition;
    public PivotArmOuttake(){
    }
    @Override
    public void Init(HardwareMap hardwareMap, Telemetry telemetry){
        motor0 = hardwareMap.get(DcMotor.class, OuttakeConstants.HMPivotArmOuttake);
        motor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void Periodic() {
         motor0.setTargetPosition(targetPosition);
         motor0.setPower(.5);
    }
    private void setTargetPosition(int setTarget){
        targetPosition = setTarget;
    }
    public void PivotToCatch(){
        setTargetPosition(OuttakeConstants.SPCatchPivotArmOuttake);
    }
    public void PivotToScore(){
        setTargetPosition(OuttakeConstants.SPScorePivotArmOuttake);
    }
}
