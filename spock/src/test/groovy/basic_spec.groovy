import spock.lang.*

class BasicSpocking extends Specification {

    def "should run it as a common specification"() {
        expect:
        1 == 1
    }
}

class FieldsInSpock extends Specification {

    def myField = 1
    @Shared def mySharedField = 1
    static myConstant = 3

    def "should allow using the defined field in all specifications"() {
        expect:
        myField == 1
    }
    def "should allow changing the defined field"() {
        given:
        myField++
        mySharedField++
        expect:
        myField == 2
        mySharedField == 2
    }
    def "must reset the field after each scenario definition"() {
        expect:
        myField == 1
    }
    def "must not reset the field after each scenario if using @Shared annotation"() {
        expect:
        mySharedField == 2
    }
    def "can use static fields, preferrably for constants"() {
        expect:
        myConstant == 3
    }
}
