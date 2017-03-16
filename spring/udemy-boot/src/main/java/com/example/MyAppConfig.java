package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "homeController")
public class MyAppConfig {

    private String devName;
    private String appName;

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "MyAppConfig{" +
                "devName='" + devName + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
