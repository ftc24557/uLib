package org.firstinspires.ftc.teamcode.core.lib.uGamepad;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.function.BooleanSupplier;

public class Button {
    boolean lastState;
    boolean currentState;
    BooleanSupplier check;
    Gamepad gamepad;

    public Button(BooleanSupplier setCheck){
        check = setCheck;
    }
    public void Periodic(){
        lastState = currentState;
        currentState = check.getAsBoolean();
    }
    public boolean isPressed(){
        return currentState;
    }
    public boolean wasJustPressed(){
        if (currentState==true && lastState==false){
            return true;
        }
        return false;
    }
    public boolean wasJustReleased(){
        if (currentState==false && lastState==true){
            return true;
        }
        return false;
    }
}
