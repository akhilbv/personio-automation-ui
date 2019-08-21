package com.personio.automation.ui.web;

import com.personio.automation.ui.AutomationError;
import com.personio.automation.ui.utils.TestConfig;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
    Properties for the webdriver initialisation
*/
public class Browser {
    private RemoteWebDriver driver;
    private String browserName;
    private String appURL;
    private String gridHubURL;
    private String platform;
    private boolean isHeadless;

    private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private TestConfig testConfig;

    /*
        Initialising the browser based on the test platform
    */
    public Browser() {
        browserName = this.getTestConfig().getBrowser();
        appURL = this.getTestConfig().getAppURL();
        gridHubURL = this.getTestConfig().getGridHubURL();
        platform = this.getTestConfig().getPlatform();
        isHeadless = this.getTestConfig().isHeadless();

        desiredCapabilities.setBrowserName(this.browserName);

        switch (this.platform.toUpperCase()) {
            case "ANDROID":
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("deviceName", this.getTestConfig().getDeviceName());
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
                break;
            case "WINDOWS":
                desiredCapabilities.setCapability("platformName", "Windows");
                break;
            default:
                throw new AutomationError("Platform " + this.platform + " is not supported");
        }
        initialiseBrowserSession(isHeadless);

    }

    /*
        For initialising the browser sessions
    */
    private void initialiseBrowserSession(boolean isHeadless) {
        switch (this.browserName.toUpperCase()) {
            case "CHROME":
                this.setupChromeDriver(isHeadless);
                break;
            case "FIREFOX":
                this.setupFirefoxDriver(isHeadless);
                break;
            case "IE":
                this.setupIeDriver();
                break;
            default:
                throw new AutomationError("Browser type " + this.browserName + " is not supported");
        }
        this.driver.manage().window().maximize();
        this.driver.get(this.appURL);
    }

    /*
        Setup the chrome driver
   */
    public void setupChromeDriver(boolean isHeadless) {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(isHeadless);
            chromeOptions.merge(desiredCapabilities);
            if (this.gridHubURL != null && !this.gridHubURL.isEmpty()) {
                this.driver = new RemoteWebDriver(new URL(gridHubURL), chromeOptions);
            } else {
                File file = new File(System.getProperty("user.dir") + File.separator + "libs" + File.separator + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                this.driver = new ChromeDriver(chromeOptions);
            }
        } catch (Exception ex) {
            throw new AssertionError("Unable to start chrome driver : " + ex.getMessage());
        }
    }

    /*
        Setup the firefox driver
    */
    public void setupFirefoxDriver(boolean isHeadless) {
        try {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(isHeadless);
            firefoxOptions.merge(desiredCapabilities);
            if (this.gridHubURL != null && !this.gridHubURL.isEmpty()) {
                this.driver = new RemoteWebDriver(new URL(gridHubURL), firefoxOptions);
            } else {
                File file = new File(System.getProperty("user.dir") + File.separator + "libs" + File.separator + "geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                this.driver = new FirefoxDriver();
            }
        } catch (Exception ex) {
            throw new AssertionError("Unable to start firefox driver : " + ex.getMessage());
        }
    }

    /*
        Setup the internet explorer driver
    */
    public void setupIeDriver() {
        try {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions();

            ieOptions.merge(desiredCapabilities);
            if (this.gridHubURL != null && !this.gridHubURL.isEmpty()) {
                this.driver = new RemoteWebDriver(new URL(gridHubURL), ieOptions);
            } else {
                File file = new File(System.getProperty("user.dir") + File.separator + "libs" + File.separator + "IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                this.driver = new InternetExplorerDriver();
            }
        } catch (Exception ex) {
            throw new AssertionError("Unable to start firefox driver : " + ex.getMessage());
        }
    }

    /*
        Read the properties file
    */
    public TestConfig getTestConfig() {
        if (testConfig == null) {
            testConfig = new TestConfig();
        }
        return this.testConfig;
    }

    /*
        Quit the webdriver
    */
    public void quitDriver() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    /*
        For taking the screenshot of the application
    */
    public void takeScreenShot(String filePath) throws IOException {
        File scrFile = this.getDriver().getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filePath));
    }

}

