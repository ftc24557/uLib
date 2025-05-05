package org.firstinspires.ftc.teamcode.core.lib.StateMachine;

public class State {
    private String stateName;
    public Action stateAction;
    public State(String name, Action action){
        stateName = name;
        stateAction = action;
    }
    public void RunAction(){
        stateAction.Run(0);
    }
    public String getStateName(){
        return getStateName();
    }

}
