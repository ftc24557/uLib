package org.firstinspires.ftc.teamcode.subsystemGroups.Outtake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.lib.Subsystem;
import org.firstinspires.ftc.teamcode.core.controller.PIDFController;

public class ArmSub extends Subsystem {
    DcMotor Dof1Motor;
    DcMotor Dof2Motor;

    PIDFController pidf1 = new PIDFController(0.015, 0.000, 0.00, 0);
    PIDFController pidf2 = new PIDFController(0.00, 0.000, 0.00, 0);

    @Override
    public void Init(HardwareMap hardwareMap, Telemetry telemetry) {
        Dof1Motor = hardwareMap.get(DcMotor.class, OuttakeConstants.HMDof1);
        Dof2Motor = hardwareMap.get(DcMotor.class, OuttakeConstants.HMDof2);

        Dof1Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Dof2Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Dof1Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Dof2Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        pidf1.reset();
        pidf2.reset();
    }

    public void Outtake() {
        pidf1.setSetpoint(OuttakeConstants.SPOuttake[0]);
        pidf2.setSetpoint(OuttakeConstants.SPOuttake[1]);
    }

    public void Intake() {
        pidf1.setSetpoint(OuttakeConstants.SPIntake[0]);
        pidf2.setSetpoint(OuttakeConstants.SPIntake[1]);
    }

    @Override
    public void Periodic() {
        double current1 = Dof1Motor.getCurrentPosition();
        double current2 = Dof2Motor.getCurrentPosition();

        double power1 = pidf1.calculate(current1);
        double power2 = pidf2.calculate(current2);

        // Clamp power (evita valores fora do intervalo permitido)
        power1 = Math.max(-1, Math.min(1, power1));
        power2 = Math.max(-1, Math.min(1, power2));

        Dof1Motor.setPower(power1);
        Dof2Motor.setPower(power2);
    }
}
