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
    it("make you aware that bind times are the last ones for closure", function(){
        var closure = function(arr){
            var resultFunction;
            for (var i=0; i < arr.length; i++){
                if (arr[i] % 2 === 0){
                    resultFunction = function(){
                        return i;
                    };
                }
            }
            return resultFunction;
        }
        var firstEvenNumber = closure([1,2,3])();
        expect(firstEvenNumber).toBe(3);
        expect(firstEvenNumber).not.toBe(1); //it keeps 'for-ing' to the end
    });
    it("and you could break the bind with an eager return", function(){
        var closure = function(arr){
            for (var i=0; i < arr.length; i++){
                if (arr[i] % 2 === 0){
                    return function(){
                        return i;
                    };
                }
            }
        }
        var firstEvenNumber = closure([1,2,3])();
        expect(firstEvenNumber).toBe(1);
        expect(firstEvenNumber).not.toBe(2); 
    });
});
describe("Highway to the Danger Zones", function(){
    var exercise = require("../lib/functions.js");
    it("should display a list of danger zones", function(){
        var messenger=exercise.warningMaker("test");
        alert = jasmine.createSpy();
        messenger(1,"1");
        expect(alert).toHaveBeenCalledWith(jasmine.stringMatching(/.*Current danger zones are:\n1$/));
        messenger(1,"2");
        expect(alert).toHaveBeenCalledWith(jasmine.stringMatching(/.*Current danger zones are:\n1\n2$/));
    });

});
