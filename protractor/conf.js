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
        var jasmineReporters = require('jasmine-reporters');
        var SpecReporter = require('jasmine-spec-reporter');

        // returning the promise makes protractor wait for the reporter config before executing tests
        return browser.getProcessedConfig().then(function(config) {
            // you could use other properties here if you want, such as platform and version
            var browserName = config.capabilities.browserName;

            var junitReporter = new jasmineReporters.JUnitXmlReporter({
                consolidateAll: true,
                savePath: 'testresults',
                // this will produce distinct xml files for each capability
                filePrefix: browserName + '-xmloutput',
                modifySuiteName: function(generatedSuiteName, suite) {
                    // this will produce distinct suite names for each capability,
                    // e.g. 'firefox.login tests' and 'chrome.login tests'
                    return browserName + '.' + generatedSuiteName;
                }
            });
            jasmine.getEnv().addReporter(junitReporter);
            jasmine.getEnv().addReporter(new SpecReporter());
        });
    },
    jasmineNodeOpts: {
        silent: true,
        showColors: true,
        print: function(){}
    }
}
