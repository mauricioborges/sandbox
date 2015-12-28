describe("Working with Spec and Config files:",function(){
    describe("Global variables:",function(){
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
    });
});
