var webdriver = require('selenium-webdriver');

var driver = new webdriver.Builder().
   withCapabilities(webdriver.Capabilities.chrome()).
   build();

driver.get('http://www.google.com');
driver.findElement(webdriver.By.name('q')).sendKeys('webdriver');
driver.findElement(webdriver.By.name('btnG')).click();

driver.wait(function() {
 return driver.getTitle().then(function(title) {
     console.log(title);
     return title === 'webdriver - Pesquisa Google';
 });
}, 1000);

driver.quit();

