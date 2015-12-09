package my.pomodoro;

public class Task implements Executable {
    private String description;

    public Task(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }
}
