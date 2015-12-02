describe("what's the difference between anonymous and non-anonymous functions?", function(){
    it("should see the function when it's not anonymous", function() {
        function myFunction(){}
        expect(typeof myFunction).toBe('function');
    });
    it("should see the function only after using it in an expression when it's anonymous", function() {
        var myFunction
        expect(typeof myFunction).toBe('undefined');
        myFunction = function(){}
        expect(typeof myFunction).toBe('function');
    });
});
