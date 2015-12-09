import my.pomodoro.*

import spock.lang.Specification

class PomodoroUsage extends Specification {
    def "first you should define what task you gonna work on during the pomodoro cycle"() {
        given:
        Executable task = new Task("description")
        expect:
        task.description == "description"
    }

    def "then you should be able to start a pomodoro cycle to work on this task"() {
        given:
        def task = Mock(Executable)
        when:
        def p = new Pomodoro(task)
        then:
        p.toDo().is(task)
    }

    def "and you should be able to start it sometime"() {
        given:
        def p = new Pomodoro(Mock(Executable))
        def time = Mock(StopWatch)
        expect:
        p.startOn(time)
    }

    def "and check if this time is over"() {
        given:
        def p = new Pomodoro(Mock(Executable))
        def time = Mock(StopWatch)
        when:
        p.startOn(time)
        time.runnedOver() >> true
        then:
        p.isOver()
    }

    def "and also check if the time is not over"() {
        given:
        def p = new Pomodoro(Mock(Executable))
        def time = Mock(StopWatch)
        when:
        p.startOn(time)
        time.runnedOver() >> false
        then:
        !p.isOver()
    }

    def "should notify if trying to check time lapse for a non running pomodoro"(){
        given:
        def p = new Pomodoro(Mock(Executable))
        when:
        p.isOver()
        then:
        thrown(PomodoroNotStartedException)
    }
}

class PomodoroStopWatchSpecs extends Specification{

    def "should has a number of minutes to run"(){
        given:
        def minutes = 25;
        def stopWatch = new PomodoroStopWatch()
        expect:
        stopWatch.setMinutesToRun(minutes)

    }

    def "should has a clock to watch"(){
        given:
        def clock = Mock(Clock)
        expect:
        new PomodoroStopWatch(clock)
    }

    def "this clock should return only what time is it"(){
        given:"best practices of contract testing"
        def clock = Mock(Clock)
        clock.whatTimeIsIt() >> Mock(Date)
    }

   def "should stop when the time is over"(){
        given:"todo mock return of clock"
        def clock = Mock(Clock)
        def stopWatch = new PomodoroStopWatch(clock)
        stopWatch.setMinutesToRun()

    }
}