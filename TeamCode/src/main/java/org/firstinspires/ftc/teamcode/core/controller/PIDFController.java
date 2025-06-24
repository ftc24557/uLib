package org.firstinspires.ftc.teamcode.core.controller;

public class PIDFController {
    private double kP, kI, kD, kF;
    private double integralSum = 0;
    private double lastError = 0;
    private double lastTime = 0;

    private double setpoint = 0;
    private double tolerance = 1e-2;

    public PIDFController(double kP, double kI, double kD, double kF) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = kF;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public double getSetpoint() {
        return setpoint;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public boolean atSetpoint(double current) {
        return Math.abs(setpoint - current) <= tolerance;
    }

    public void reset() {
        integralSum = 0;
        lastError = 0;
        lastTime = System.nanoTime() / 1e9;
    }

    public double calculate(double currentPosition) {
        double currentTime = System.nanoTime() / 1e9;
        double dt = currentTime - lastTime;
        lastTime = currentTime;

        double error = setpoint - currentPosition;
        integralSum += error * dt;
        double derivative = (dt > 0) ? (error - lastError) / dt : 0;

        lastError = error;

        return kP * error + kI * integralSum + kD * derivative + kF * setpoint;
    }
}