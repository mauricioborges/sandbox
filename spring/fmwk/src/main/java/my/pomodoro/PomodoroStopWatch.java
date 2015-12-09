package my.pomodoro;

import java.util.Date;

public class PomodoroStopWatch implements StopWatch {

    private Integer minutesToRun;

    public PomodoroStopWatch(Clock clock){

    }
    @Override
    public Boolean runnedOver() {
        return null;
    }

    public void setMinutesToRun(int minutesToRun) {
        this.minutesToRun = minutesToRun;
    }
}
