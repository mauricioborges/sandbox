exports.config = {
  framework: 'jasmine',
  seleniumAddress: 'http://' + require('docker-host')().host + ':4444/wd/hub',
  specs: ['specs/*spec.js'],
  multiCapabilities: [{
    browserName: 'firefox'
  },{
    browserName: 'chrome'
  }],
  onPrepare: function() {
     var SpecReporter = require('jasmine-spec-reporter');
     // add jasmine spec reporter
     jasmine.getEnv().addReporter(new SpecReporter({displayStacktrace: 'all'}));
  }
}
