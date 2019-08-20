package com.personio.automation.ui.web;

import com.personio.automation.ui.type.html.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;
import java.util.logging.Logger;

/*
  Provides the properties for a web page.
  Each page object should be extended from this class
  */
public class Page {

    private RemoteWebDriver driver;
    private int pageWaitTimeOut = 30;
    private static final Logger LOGGER = Logger.getLogger("automation");
    /*
  Initialising the page properties
  */
    public Page(Browser browser) {
        this.driver = browser.getDriver();
        String pageWait = System.getProperty("pageWaitTimeOut");
        if (pageWait == null) {
            ResourceBundle configProperties = ResourceBundle.getBundle("config");
            pageWait = configProperties.getString("pageWaitTimeout");
        }
        pageWaitTimeOut = Integer.parseInt(pageWait);
        waitForAjaxAndJSToLOad();
    }

    private int getPageWaitTimeOut() {
        return this.pageWaitTimeOut;
    }

    /*
 Wait till the execution of ajax and javascript is completed in the page
 */
    protected void waitForAjaxAndJSToLOad() {
        WebDriverWait wait = new WebDriverWait(this.driver, pageWaitTimeOut);
        JavascriptExecutor javascriptExecutor = driver;
        String jsState = javascriptExecutor.executeScript("return document.readyState;").toString();
        if (!"complete".equals(jsState)) {
            wait.until((ExpectedCondition<Boolean>) waitDriver -> ("complete".equals(javascriptExecutor.executeScript("retrun document.readyState;"))));
        }

        String activeAjax = javascriptExecutor.executeScript(" return jQuery.active;").toString();
        if (!"0".equals(activeAjax)) {
            wait.until((ExpectedCondition<Boolean>) waitDriver -> ("0".equals(javascriptExecutor.executeScript(" return jQuery.active;"))));
        }
    }

    /*
 Wait till the page with given title loads
 */
    protected void waitForPage(String pageTitle) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), pageWaitTimeOut);
            wait.until(ExpectedConditions.titleContains(pageTitle));
        }catch (TimeoutException ex)
        {
            LOGGER.warning("Expected condition failed: waiting for title to contain "+pageTitle);
        }
    }

    protected RemoteWebDriver getDriver() {
        return this.driver;
    }

    public Button Button(String identifier) {
        return new Button(getDriver(), identifier);
    }

    public CheckBox CheckBox(String identifier) {
        return new CheckBox(getDriver(), identifier);
    }

    public Div Div(String identifier, By.ByType identifierType) {
        return new Div(getDriver(), identifier,identifierType);
    }

    public Label Label(String identifier,By.ByType identifierType) {
        return new Label(getDriver(), identifier,identifierType);
    }

    public Link Link(String identifier,By.ByType identifierType) {
        return new Link(getDriver(), identifier,identifierType);
    }

    public Select Select(String identifier,By.ByType identifierType) {
        return new Select(getDriver(), identifier,identifierType);
    }

    public Table Table(String identifier,By.ByType identifierType) {
        return new Table(getDriver(), identifier,identifierType);
    }

    public TextArea TextArea(String identifier,By.ByType identifierType) {
        return new TextArea(getDriver(), identifier,identifierType);
    }

    public TextField TextField(String identifier,By.ByType identifierType) {
        return new TextField(getDriver(), identifier,identifierType);
    }
}
