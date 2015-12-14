import spock.lang.*

class BasicSpockingSpec extends Specification {

    def "should run it as a common test"() {
        expect:
        1 == 1
    }
}
