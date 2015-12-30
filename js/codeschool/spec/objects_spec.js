describe("Objects:", function() {
    var _ = require('../lib/objects.js');
    describe("Creation", function() {
        it("should create and empty object",function() {
            expect({}).toEqual(jasmine.any(Object));
        });
    });
    describe("Changing", function() {
        it("should set references for properties as objects",function() {
            var father = {id:1};
            var son = {id:11};
            father.son = son;
            son.id = 12;
            expect(father.son.id).toEqual(12);
        });
        it("should retrieve references when necessary",function() {
            var father = {id:1, son:{id:11}};
            var son = father.son;
            son.id = 12;
            expect(father.son.id).toEqual(12);
        });

    });
    describe("Enumeration", function() {
        it("should allow me to walk over the properties in an object",function() {
            var road = {plate1:1, plate2:2, plate3:3};
            var keys = ""
            for (key in road) {
                keys += key+road[key];
            }
            expect(keys).toEqual("plate11plate22plate33")
        });
    });
    describe("Cloning?", function() {
        it("should be able to clone an object...doing something",function() {
            var obj1 = {id:1};
            var obj2 = _.clone(obj1);
            expect(obj1).toBe(obj1);
            expect(obj1).toEqual(obj1);
            expect(obj2).toEqual(obj1);
            expect(obj2).not.toBe(obj1);
            expect(obj2).not.toBe(_.clone(obj1));
            obj2.id = 2;
            expect(obj1.id).toBe(1);
            expect(obj2.id).toBe(2);
        });
    });
});
