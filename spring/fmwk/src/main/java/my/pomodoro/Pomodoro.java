package my.pomodoro;

public class Pomodoro {
    private Executable task;
    private StopWatch clock;

    public Pomodoro(Executable t) {
        task = t;
    }

    public Executable toDo() {
        return task;
    }

    public void startOn(StopWatch p) {
        this.clock = p;
    }

    public Boolean isOver() {
        if (clock == null) {
            throw new PomodoroNotStartedException();
        }
        return clock.isUp();
    }
}
