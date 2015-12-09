import my.pomodoro.Pomodoro
import spock.lang.Specification

class PomodoroBasic extends Specification {
    def "should be able to start a pomodoro"(){
        given:
        def pomodoro = new Pomodoro()
        expect:
        pomodoro.start()
    }
}
