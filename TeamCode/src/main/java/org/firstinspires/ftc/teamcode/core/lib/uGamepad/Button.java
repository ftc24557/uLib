package org.firstinspires.ftc.teamcode.core.lib.uGamepad;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;

import java.util.function.BooleanSupplier;

public class Button {
    boolean lastState;
    boolean currentState;
    BooleanSupplier check;
    Gamepad gamepad;

    public enum buttonStates {
        PRESSED,
        JUST_PRESSED,
        JUST_RELEASED
    }
    Action PressedAction;
    Boolean PressedScheduled = false;

    Action JustReleasedAction;
    Boolean JustReleasedScheduled = false;

    Action JustPressedAction;
    Boolean JustPressedScheduled = false;



    public Button(BooleanSupplier setCheck){
        check = setCheck;
    }
    public void Periodic(){
        lastState = currentState;
        currentState = check.getAsBoolean();

        if (wasJustPressed() && JustPressedScheduled){
            JustPressedAction.Run(0);
        }
        if (wasJustReleased() && JustReleasedScheduled){
            JustReleasedAction.Run(0);
        }
        if (isPressed() && PressedScheduled){
            PressedAction.Run(0);
        }



    }
    public void ScheduleAction(Action action, buttonStates state){
        switch(state){
            case PRESSED:
                PressedAction = action;
                PressedScheduled = true;
                break;
            case JUST_PRESSED:
                JustPressedAction = action;
                JustPressedScheduled = true;
                break;
            case JUST_RELEASED:
                JustReleasedAction = action;
                JustPressedScheduled = true;
                break;
        }
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
