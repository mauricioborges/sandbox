webdriver = require('selenium-webdriver');
driver = new webdriver.Builder().
                withCapabilities(webdriver.Capabilities.chrome()).
                build();
