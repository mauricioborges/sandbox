package my.pomodoro;

import my.pomodoro.Pomodoro;

public class PomodoroTimer {
    private Pomodoro currentPomodoro;

    public void startPomodoro() {
        currentPomodoro = new Pomodoro();
        currentPomodoro().start();

    }


    public Pomodoro currentPomodoro() {
        return currentPomodoro;
    }
}
