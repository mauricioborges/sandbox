describe("Basic WebDriverJs usage", function(){
    it("should open Chrome and go to google",function(done){
        driver.get('http://www.google.com');
        var p = driver.getTitle();
        p.then(function(title) {
            console.log(title);
            done();
        });
    });
    afterEach(function(done){
        driver.quit().then(function(){done()});
    });

});
