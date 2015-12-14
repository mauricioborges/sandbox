package pomodoro;

import pomodoro.domain.Clock;

import java.util.Date;

/**
 * Created by mbsilva on 12/10/15.
 */
public class DateClock implements Clock {

    @Override
    public Long whatTimeIsIt() {
        return new Date().getTime();
    }
}
