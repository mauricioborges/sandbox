var assert = require('assert'),
    test = require('selenium-webdriver/testing'),
    webdriver = require('selenium-webdriver'),
    until = webdriver.until;

test.describe('Google Search', function() {
  test.it('should work', function() {
    var driver = new webdriver.Builder()
        .forBrowser('chrome')
        .build();

    driver.get('http://www.google.com/ncr');

    var searchBox = driver.findElement(webdriver.By.name('q'));
    searchBox.sendKeys('webdriver');
    searchBox.getAttribute('value').then(function(value) {
      assert.equal(value, 'webdriver');
    });
    driver.wait(until.titleIs('webdriver - Pesquisa Google'), 1000);

    driver.quit();
  });
});


