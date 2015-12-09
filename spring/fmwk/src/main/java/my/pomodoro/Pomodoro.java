package my.pomodoro;

import java.util.Date;

public class Pomodoro {

    private Boolean running = Boolean.FALSE;

    public void start() {
        running = Boolean.TRUE;
    }

    public Boolean isOver() {
        if (running){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean isRunning() {
        return running;
    }

    public Boolean stop() {
        return Boolean.TRUE;
    }

}
