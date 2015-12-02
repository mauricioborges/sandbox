describe("what happens when using double equal signs while comparing?", function(){
   it("does not treat zero as equal to null", function() {
        expect(0==null).toBe(false);
   });
   it("treat empty char as equal to 0", function() {
        expect(0=='').toBe(true);
   });
   it("treat string '0' as numeric 0", function() {
        expect(0=='0').toBe(true);
   });
});
describe("what happens when using triple equal signs while comparing?", function(){
   it("does not treat zero as equal to null", function() {
        expect(0===null).toBe(false);
   });
   it("does not treat empty char as equal to 0", function() {
        expect(0==='').toBe(false);
   });
   it("does not treat string '0' as a numeric 0", function() {
        expect(0==='0').toBe(false);
   });
});
