package com.personio.automation.ui.utils;

import java.util.ResourceBundle;

/*
    For accessing and initialising the properties required for the test execution
*/

public class TestConfig {
    private String appURL;
    private String browser;
    private String gridHubURL;
    private String platform;
    private String deviceName;
    private boolean isHeadless;

    public TestConfig() {
        ResourceBundle testConfig = ResourceBundle.getBundle("testConfig");
        this.appURL = testConfig.getString("appURL");
        this.browser = testConfig.getString("browser");
        this.gridHubURL = testConfig.getString("gridHubURL");
        this.platform = testConfig.getString("platform");
        this.deviceName = testConfig.getString("deviceName");
        this.isHeadless = Boolean.parseBoolean(testConfig.getString("headless"));
    }

    public String getAppURL() {
        return this.appURL;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getGridHubURL() {
        return this.gridHubURL;
    }

    public String getPlatform() {
        return this.platform;
    }
    public String getDeviceName() {
        return this.deviceName;
    }

    public boolean isHeadless() {
        return this.isHeadless;
    }
}
