public class Alarm {

    private Long minutesToCount = 0L;
    private Long startTime;
    private Clock clock;

    public Alarm(Integer minutesToCount) {
        this.minutesToCount = minutesToCount.longValue();
    }

    public Long minutes() {
        return minutesToCount;
    }

    public void startCountingAt(Long startTime) {
        this.startTime = startTime;
    }

    public Integer howMuchTimeHasPassed() {
        return 0;
    }

    public void setClock(Clock c) {
        this.clock = c;

    }

    public Long timeLeft() {
        if (this.clock == null) {
            throw new NoAlarmWithoutClockForYouTodayException();
        }
        if (this.startTime == null) {
            throw new AlarmNotStartedYetException();
        }
        return this.minutesToCount * 60 * 1000 - (this.clock.whatTimeIsIt() - startTime);
    }
}
