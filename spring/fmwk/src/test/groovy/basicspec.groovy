import my.pomodoro.Executable
import my.pomodoro.Pomodoro
import my.pomodoro.StopWatch
import my.pomodoro.PomodoroNotStartedException
import my.pomodoro.Task

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
        time.isUp() >> true
        then:
        p.isOver()
    }

    def "and also check if the time is not over"() {
        given:
        def p = new Pomodoro(Mock(Executable))
        def time = Mock(StopWatch)
        when:
        p.startOn(time)
        time.isUp() >> false
        then:
        !p.isOver()
    }

    def "should also notify if trying to check time lapse for a non running pomodoro"(){
        given:
        def p = new Pomodoro(Mock(Executable))
        when:
        p.isOver()
        then:
        thrown(PomodoroNotStartedException)
    }
}
