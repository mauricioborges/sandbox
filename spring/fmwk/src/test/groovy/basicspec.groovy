import my.pomodoro.Pomodoro
import spock.lang.Specification

class PomodoroBasicModel extends Specification {
    def "should be able to start a pomodoro"() {
        given:
        def pomodoro = new Pomodoro()
        expect:
        pomodoro.start()
    }

    def "should be able to check if a pomodoro is over"() {
        given:
        def pomodoro = new Pomodoro()
        expect:
        pomodoro.isOver()
    }

    def "should mark pomodoro as not over while not stopped"() {
        given:
        def pomodoro = new Pomodoro()
        pomodoro.start()
        expect:
        pomodoro.isOver() == false
    }


    def "should show when a pomodoro is running"() {
        given:
        def pomodoro = new Pomodoro()
        when:
        pomodoro.start()
        then:
        pomodoro.isRunning()
    }

    def "should show when a pomodoro is NOT running"() {
        given:
        def pomodoro = new Pomodoro()
        expect:
        pomodoro.isRunning() == Boolean.FALSE
    }

    def "should be able to stop a pomodoro"() {
        given:
        def pomodoro = new Pomodoro()
        expect:
        pomodoro.stop()
    }

}
