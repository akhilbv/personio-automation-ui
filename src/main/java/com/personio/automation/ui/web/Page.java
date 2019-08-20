package com.personio.automation.ui.web;

import com.personio.automation.ui.type.html.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

/*
  Provides the properties for a web page.
  Each page object should be extended from this class
  */
public class Page {

    private RemoteWebDriver driver;
    private int pageWaitTimeOut = 30;

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
    }

    private int getPageWaitTimeOut() {
        return this.pageWaitTimeOut;
    }

    /*
 Wait till the execution of ajax and javascript is completed in the page
 */
    private void waitForAjaxAndJSToLOad() {
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
        WebDriverWait wait = new WebDriverWait(getDriver(), pageWaitTimeOut);
        wait.until(ExpectedConditions.titleContains(pageTitle));
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

    public Div Div(String identifier) {
        return new Div(getDriver(), identifier);
    }

    public Label Label(String identifier) {
        return new Label(getDriver(), identifier);
    }

    public Link Link(String identifier) {
        return new Link(getDriver(), identifier);
    }

    public Select Select(String identifier) {
        return new Select(getDriver(), identifier);
    }

    public Table Table(String identifier) {
        return new Table(getDriver(), identifier);
    }

    public TextArea TextArea(String identifier) {
        return new TextArea(getDriver(), identifier);
    }

    public TextField TextField(String identifier) {
        return new TextField(getDriver(), identifier);
    }
}
