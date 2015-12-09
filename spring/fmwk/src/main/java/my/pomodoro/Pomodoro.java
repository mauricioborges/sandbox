package my.pomodoro;

public class Pomodoro {
    private Executable task;
    private StopWatch stopWatch;

    public Pomodoro(Executable t) {
        task = t;
    }

    public Executable toDo() {
        return task;
    }

    public void startOn(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    public Boolean isOver() {
        if (stopWatch == null) {
            throw new PomodoroNotStartedException();
        }
        return stopWatch.runnedOver();
    }
}
