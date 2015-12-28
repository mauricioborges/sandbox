describe("Basic WebDriverJs usage:", function(){
    it("should open Chrome and go to google",function(done){
        driver.get('http://www.google.com');
        driver.findElement(webdriver.By.name('q')).sendKeys('webdriver');
        driver.findElement(webdriver.By.name('btnG')).click();
        driver.wait(driver.getTitle().then(function(title){
            return title === 'webdriver - Pesquisa Google';
        }), 3000).then(function(){
            driver.getTitle().then(function(t){
                console.log(t);
                done();
            });
        });
    });

    afterEach(function(){
        driver.quit();
    });
});
