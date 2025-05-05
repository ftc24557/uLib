package org.firstinspires.ftc.teamcode.core.lib.StateMachine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Action {
    Runnable actionRunnable;
    public Action(Runnable setActionRunnable){
        actionRunnable = setActionRunnable;
    }
    public void Run(int delayMilis){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(actionRunnable, delayMilis, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
    }
}
