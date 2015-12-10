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
        alarm.setStartTime(dateInMilliseconds)
    }

    def "should be able to set a clock to see the time passing"() {
        given:
        def alarm = new Alarm(1)
        alarm.setStartTime(1)
        expect:
        alarm.setClock(Mock(Clock))
    }
    def "should be able to see how much time left"() {
        given:
        def alarm = new Alarm(10)
        alarm.setStartTime(1)
        def clock = Mock(Clock)
        when:
        alarm.setClock(clock)
        1 * clock.whatTimeIsIt() >> 100
        then:
        alarm.timeLeft() == 10*60*1000 - (100 - 1)
    }
}