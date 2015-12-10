import java.util.Date;

/**
 * Created by mbsilva on 12/10/15.
 */
public class Application {

    static class MyClock implements Clock {

        @Override
        public Long whatTimeIsIt() {
            return new Date().getTime();
        }
    }

    public static void main(String[] args) {

        Alarm alarm = new Alarm(1);
        alarm.setClock(new MyClock());
        alarm.startCountingAt(new Date().getTime());
        while (alarm.timeLeft() > 0) {
        }
        System.out.println("aeeee!");
    }
}
