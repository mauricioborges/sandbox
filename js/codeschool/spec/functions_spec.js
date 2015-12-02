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

describe("CodeSchool exersise: Functions", function(){
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
        var func = function(){return 1}
        expect(func.toString()).toBe("function (){return 1}");
    });
});
