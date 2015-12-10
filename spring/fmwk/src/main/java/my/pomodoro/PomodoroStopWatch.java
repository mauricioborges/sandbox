package my.pomodoro;

import java.util.Date;

public class PomodoroStopWatch implements StopWatch {

    private final Clock clock;
    private final Date startTime;
    private Date stopTime;
    private Integer minutesToRun;

    public PomodoroStopWatch(Clock clock) {
        this.clock = clock;
        this.startTime = clock.whatTimeIsIt();
    }

    @Override
    public Boolean runnedOver() {
        this.stopTime = new Date(this.startTime.getTime() + 60 * 1000 * minutesToRun);
        if (!this.clock.whatTimeIsIt().before(this.stopTime)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void setMinutesToRun(int minutesToRun) {
        this.minutesToRun = minutesToRun;
    }
}
