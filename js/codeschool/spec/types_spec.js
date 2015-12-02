describe("types that I found out confusing", function(){
    it("should treat single quotes as char", function() {
        expect(typeof '').toBe('string');
    });
});
