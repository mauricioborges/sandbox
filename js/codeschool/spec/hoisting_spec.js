describe("Hoisting:", function() {
    var hoisting = require('../lib/hoisting.js');
    describe("Variables:", function(){
        it("should throw ReferenceError for never used variables", function() {
            //because not trying it inside a scope throws an error directly to the Jasmine executor
           var wrong = function(){
               return neverDeclared;
           };
           expect(wrong).toThrowError(ReferenceError);
        });
        it("should always declare used variables as undefined first when loading", function(){
            expect(b).toBe(undefined);
            var b=1;
            expect(b).toBe(1);
        });
        it("should always declare used variables as undefined first when loading", function(){
            expect(b).toBe(undefined);
            var b=1;
            expect(b).toBe(1);
            var b=2;
            expect(b).toBe(2);
        });
    });
    describe("Functions:", function(){
        it("should throw ReferenceError for never used functions", function() {
           var wrong = function(){
               neverDeclared();
           };
            expect(wrong).toThrowError(ReferenceError);
        });
        it("should correctly use the function, as variables and functions are loaded firstly before any execution", function() {
            var a = someFunction();
            function someFunction(){
                return 1;
            }
            expect(a).toBe(1);
        });
        it("should overwrite the function as it is declared twice (last declaration persists)", function() {
            var a = someFunction();
            function someFunction(){
                return 1;
            }
            function someFunction(){
                return 2;
            }
            expect(a).toBe(2);
        });
    });
    describe("Function expressions:", function(){
        it("should throw TypeError, as someFunction() is not yet loaded (function expression)", function() {
            //because not trying it inside a scope throws an error directly to the Jasmine executor
            function closureScoping ()  {
                var receivingFunctionExpressionIThink = someFunction();
                var someFunction = function(){
                    return 1;
                };
            }
            expect(closureScoping).toThrowError(TypeError);
        });
        it("should use function expression after declared, as expected", function() {
            var someFunction = function(){
                return 1;
            };
            expect(receivingFunctionExpressionIThink).toBe(undefined);
            var receivingFunctionExpressionIThink = someFunction();
            expect(receivingFunctionExpressionIThink).toBe(1);
        });
    });
});
