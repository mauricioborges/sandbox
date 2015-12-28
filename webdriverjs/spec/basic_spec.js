describe("Basic WebDriverJs usage", function(){
    it("should open Chrome and go to google",function(){
        driver.get('http://www.google.com');
        driver.findElement(webdriver.By.name('q')).sendKeys('webdriver');
        driver.findElement(webdriver.By.name('btnG')).click();
        driver.wait(function() {
             return driver.getTitle().then(function(title) {
                 return title === 'webdriver - Google Search';
             });
        }, 1000);
        driver.quit();
        });
    });
