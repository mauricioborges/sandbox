package pomodoro

import pomodoro.domain.Alarm
import pomodoro.domain.Clock
import pomodoro.exception.AlarmNotStartedYetException
import pomodoro.exception.NoAlarmWithoutClockForYouTodayException
import spock.lang.Specification

public class AlarmSpec extends Specification {

    def "should be able to set timer minutes"() {
        given:
        def alarm = new Alarm(1)
        expect:
        alarm.minutes() == 1
    }

    def "should be able to set start time"() {
        given:
        def alarm = new Alarm(1)
        def dateInMilliseconds = 1
        expect:
        alarm.startCountingAt(dateInMilliseconds)
    }

    def "should be able to set a clock to see the time passing"() {
        given:
        def alarm = new Alarm(1)
        alarm.startCountingAt(1L)
        expect:
        alarm.setClock(Mock(Clock))
    }
}

class AlarmTimingSpec extends Specification {
    def "should be able to see how much time left"() {
        given:
        def alarm = new Alarm(10)
        alarm.startCountingAt(1L)
        def clock = Mock(Clock)
        when:
        alarm.setClock(clock)
        1 * clock.whatTimeIsIt() >> 100
        then:
        alarm.timeLeft() == 10 * 60 * 1000 - (100 - 1)
    }

    def "should not be possible to set an alarm with no clock"() {
        given:
        def alarm = new Alarm(10)
        alarm.startCountingAt(1L)
        when:
        alarm.timeLeft()
        then:
        thrown(NoAlarmWithoutClockForYouTodayException)
    }

    def "should not be possible to check time left without starting the alarm"() {
        given:
        def alarm = new Alarm(10)
        alarm.setClock(Mock(Clock))
        when:
        alarm.timeLeft()
        then:
        thrown(AlarmNotStartedYetException)
    }
}