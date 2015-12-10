public class Alarm {

    private Integer minutesToCount = 0;
    private Integer startTime;
    private Clock clock;

    public Alarm(Integer minutesToCount) {
        this.minutesToCount = minutesToCount;
    }

    public Integer minutes() {
        return minutesToCount;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer howMuchTimeHasPassed() {
        return 0;
    }

    public void setClock(Clock c) {
        this.clock = c;

    }

    public Integer timeLeft() {
        return this.minutesToCount * 60 * 1000 - (this.clock.whatTimeIsIt() - startTime);
    }
}
