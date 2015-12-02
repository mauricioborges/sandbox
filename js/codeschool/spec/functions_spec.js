describe("what's the difference between anonymous and non-anonymous functions?", function(){
    it("should see the function when it's not anonymous", function() {
        function myFunction(){}
        expect(typeof myFunction).toBe('function');
    });
    it("should see the function only after using it in an expression when it's anonymous", function() {
        var myFunction;
        expect(myFunction).toBeUndefined();
        myFunction = function(){};
        expect(typeof myFunction).toBe('function');
    });
});

describe("CodeSchool exercise: Functions", function(){
    var exercise = require ('../lib/functions.js');
    it("Changing declarations to expressions", function(){
        expect(exercise.runAway).not.toBeNull();
        expect(exercise.runAway instanceof Function).toBeTruthy();
    });
    it("Using Function Expressions with Parameters", function(){
        var people = 100;
        var rain = 1;
        var sharks = 5;
        var fear = exercise.fearGenerated(people, rain, sharks);
        expect(fear).not.toBeLessThan(100);
        expect(fear).not.toBeGreaterThan(400);
    });
    it("Displaying Function Contents", function(){
        var func = function(){return 1};
        expect(func.toString()).toBe("function (){return 1}");
    });
    describe("Functions as Parameters, Arguments and Return Values", function() {
       describe("function: fearMessage", function(){
            it("should return a message for fear levels lower than 200", function(){
                expect(exercise.fearMessage(199)).toBe("Fear Level: LOW\nStill wanna ride?");
            });
            it("should return a message for fear levels higher than or equal to 200", function(){
                expect(exercise.fearMessage(200)).toBe("Fear Level: MEDIUM\nThink you'll make it?");
            });
            it("should not return a message for fear levels higher than 300", function(){
                expect(exercise.fearMessage(301)).toBe("");
            });
       }); 
    });
});
