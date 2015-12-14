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

class FixtureSetupMethod extends Specification {
    def setupCalled = 0
    @Shared setupSpecCalled = 0 // only shared and/or static fields can be used in setupSpec

    def setup() {
        setupCalled++
    }
    def setupSpec() {
        setupSpecCalled++
    }

    def "can run a setup() fixture automatically"(){
        expect:
        setupCalled == 1
    }
    def "should run setup() before each feature method"(){
        expect:
        setupCalled == 1
    }
    def "should be able to run additional setup steps inside feature method"(){
        setup:
        if (setupCalled == 1) setupCalled ++
        expect:
        setupCalled == 2
    }
    def "should run setupSpec() once in the entire specification"(){
        expect:
        setupSpecCalled == 1
    }
}


class FixtureCleanupMethod extends Specification {
    
    @Shared cleanupCalled = false
    @Shared cleanupSpecCalled = false // only shared and/or static fields can be used in setupSpec

    def "should run a cleanup() fixture method in the end of the method"() {
        expect:
        cleanupCalled == false
        cleanupSpecCalled == false
        cleanup:
        cleanupCalled = true
    }
    def "should keep status of last change on shared field"() {
        expect:
        cleanupCalled == true
        cleanupSpecCalled == false
    }
    def "should never see the cleanupSpec running, as it runs after the last specification method"() {
        expect:
        cleanupSpecCalled == false
    }
}

class Blocks extends Specification {

    def "should be able to define setup blocks in a feature method"(){
        setup:
        def setupCalled = true
        expect:
        setupCalled == true
    }
    def "should be able to define given-when-then blocks"(){
        given:
        def setupCalled = 0
        when: "stimulus"
        setupCalled++
        then: "response."
        setupCalled == 1
    }
    def "should be able to define given-expect blocks"(){
        expect: "all methods with return different than void are considered expectations"
        1 + 1 == 2
    }

    def "should be able to define multiple examples for a single feature specification"() {
        expect:
        a + b == c
        where:
        a << [1, 2, 3]
        b << [3, 7, 8]
        c << [4, 9, 11]
    }
}

class HelperMethods extends Specification {

    def "should be able to use helper methods to improve readability"(){
        given:
        def text = "HelloWorld"
        expect:
        regexToBeValid(text)
    }

    def regexToBeValid(words) {
        return words =~ /H.*Worl+/
    }
}
