import my.pomodoro.Pomodoro
import spock.lang.Specification

class PomodoroBasicAPI extends Specification {
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

    def "should be able to check if a pomodoro is running"() {
        given:
        def pomodoro = new Pomodoro()
        expect:
        pomodoro.isRunning()
    }
    def "should be able to stop a pomodoro"() {
        given:
        def pomodoro = new Pomodoro()
        expect:
        pomodoro.stop()
    }
}
