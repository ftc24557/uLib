package org.firstinspires.ftc.teamcode.core.lib.uGamepad;

import com.qualcomm.robotcore.hardware.Gamepad;

public class uGamepad {
    Gamepad gamepad;

    public Button A;
    public Button B;
    public Button Y;
    public Button X;
    public Button LEFT_BUMPER;
    public Button RIGHT_BUMPER;
    public Button DPAD_DOWN;
    public Button DPAD_UP;
    public Button DPAD_RIGHT;
    public Button DPAD_LEFT;

    private Button[] buttons;

    public uGamepad(Gamepad setGamepad){
        gamepad = setGamepad;
        A = new Button(()-> gamepad.a);
        B = new Button(()-> gamepad.b);
        X = new Button(()-> gamepad.x);
        Y = new Button(()-> gamepad.y);
        LEFT_BUMPER = new Button(()->gamepad.left_bumper);
        RIGHT_BUMPER = new Button(()->gamepad.right_bumper);
        DPAD_DOWN = new Button(()->gamepad.dpad_down);
        DPAD_UP = new Button(()->gamepad.dpad_up);
        DPAD_RIGHT = new Button(()->gamepad.dpad_right);
        DPAD_LEFT = new Button(()->gamepad.dpad_left);
        buttons = new Button[] {
                A, B, X, Y, LEFT_BUMPER, RIGHT_BUMPER,
                DPAD_DOWN, DPAD_UP, DPAD_RIGHT, DPAD_LEFT
        };
    }
    public void Periodic(){
        for (Button button : buttons){
            button.Periodic();
        }
    }
}
