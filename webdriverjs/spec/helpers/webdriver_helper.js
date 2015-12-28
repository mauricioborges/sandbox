var fs = require('fs');
webdriver = require('selenium-webdriver');
driver = new webdriver.Builder().
                withCapabilities(webdriver.Capabilities.chrome()).
                build();
writeScreenshot = function (data, name) {
  name = name || 'ss.png';
  console.log(name);
  fs.writeFileSync(__dirname + name, data, 'base64');
};

