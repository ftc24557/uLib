package org.firstinspires.ftc.teamcode.core.lib.StateMachine;

public class StateMachine {
    State[] states;
    String currentStateName;
    Action defaultTransition;
    public StateMachine(State[] setStates,Action setDefaultTransition){
        states = setStates;
        defaultTransition = setDefaultTransition;
    }

    public void setState(String stateName){
        boolean reached = false;
        for (int i =0; i<states.length; i++){
            if (states[i].getStateName() == stateName) {
                defaultTransition.Run(0);
                currentStateName = stateName;
                states[i].RunAction();
                reached = true;
            }
        }
        if (!reached){
            throw new RuntimeException("State name argument doesn't exist");
        }
    }



}
