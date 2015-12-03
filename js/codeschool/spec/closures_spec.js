describe("basicClosure", function(){
    it("can help you to access internal things from function execution", function(){
        var closureFunction = function() {
            var internalValue = 7;
            return function() {
                return internalValue;
            }
        };
        var result = closureFunction();
        expect(result()).toBe(7);
        expect(closureFunction.internalValue).toBe(undefined);
    });
    it("can help you to access internal things from function execution", function(){
        var closureFunction = function() {
            var internalCounter = 0;
            return {
                acessor : function (){return internalCounter},
                incrementIt : function(){internalCounter++}
            }
        };
        var counter = closureFunction();
        expect(counter.acessor()).toBe(0);
        counter.incrementIt();
        expect(counter.acessor()).toBe(1);
    });
});
describe("Highway to the Danger Zones", function(){
    var exercise = require("../lib/functions.js");
    it("should display a list of danger zones", function(){
        var mess=exercise.warningMaker("test");
        alert=console.log;
        mess(1,"1");
        mess(1,"2");
        fail("this is not a test, where are your assertions?");
    });

});
