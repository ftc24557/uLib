package org.firstinspires.ftc.teamcode.subsystemGroups.TankDrive;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class Line {
    public Pose2D p1;
    public Pose2D p2;
    public Line(Pose2D point1, Pose2D point2){
        p1 = point1;
        p2 = point2;
    }

    public double angleRadians(){
        return Math.atan2(p2.getX(DistanceUnit.MM)-p1.getX(DistanceUnit.MM), p2.getY(DistanceUnit.MM)-p1.getY(DistanceUnit.MM)-Math.toRadians(90));

    }
    public double lengthMM(){
        return Math.sqrt(Math.pow(p2.getX(DistanceUnit.MM)-p1.getX(DistanceUnit.MM), 2) + Math.pow(p2.getY(DistanceUnit.MM)-p1.getY(DistanceUnit.MM), 2));
    }





}
