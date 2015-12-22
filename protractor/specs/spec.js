describe('Protractor Demo App', function() {
  var firstNumber = element(by.model('first'));
  var secondNumber = element(by.model('second'));
  var goButton = element(by.id('gobutton'));
  var latestResult = element(by.binding('latest'));
  var history = element.all(by.repeater('result in memory'));  //note that this element is retrieved using by.repeater, which gets from ng-repeat property 'result in memory'

  beforeEach(function() {
    browser.get('http://juliemr.github.io/protractor-demo/');
  });

  var add = function(a, b){
    firstNumber.sendKeys(a);
    secondNumber.sendKeys(b);
    goButton.click();
  };


  it('should have a title', function() {
    expect(browser.getTitle()).toEqual('Super Calculator');
  });

  it('should add one and two', function() {
    firstNumber.sendKeys(1);
    secondNumber.sendKeys(2);

    goButton.click();

    expect(latestResult.getText()).toEqual('3');
  });

  it('should add four and six', function() {
    firstNumber.sendKeys(4);
    secondNumber.sendKeys(6);

    goButton.click();

    expect(latestResult.getText()).toEqual('10');
  });
  it('should have a history', function() {
      add(1, 5);
      add(7, 15);
      expect(history.count()).toEqual(2);
  });
  it('should history has a text describing the calculus', function() {
      add(1, 2);
      add(2, 3);
      expect(history.last().getText()).toContain('1 + 2');
  });
});
