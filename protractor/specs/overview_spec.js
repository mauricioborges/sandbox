describe("Working with Spec and Config files:",function(){
    describe("Protractor globals:",function(){
        describe("browser - an wrapper around an instance of WebDriver:",function(){
            it("should provide 'browser' as a global variable",function(){
                expect(browser).not.toBe(null);
            });
            it("should provide 'browser.get' as a function",function(){
                expect(browser.get).toEqual(jasmine.any(Function));
            });
            it("should provide 'browser.driver' as a direct access to WebDriver instance",function(){
                expect(browser.driver.session).not.toBe(null);
                expect(browser.driver.wait).not.toBe(null);
            });
        });
        describe("by - a set of action methods (locators) to find items on a page:",function(){
            it("by should be an Object", function(){
                expect(by).toEqual(jasmine.any(Object));
            })
            it("should be able to access the CSS locator", function(){
                expect(by.css).toEqual(jasmine.any(Function));
            })
        });
        describe("element - a helper function for finding and interaction with DOM elements:",function(){
            it("should be able to access the element function", function(){
                expect(element).toEqual(jasmine.any(Function));
            })
        });
        describe("protractor - a namespace which wraps WebDriver namespace:",function(){
            it("should be able to access the element function", function(){
                expect(protractor).toEqual(jasmine.any(Object));
            })
        });
    });
});
