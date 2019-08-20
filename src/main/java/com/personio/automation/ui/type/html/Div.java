package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
    Properties of the html element : Div
*/
public class Div extends BaseHtmlElement {
    public Div(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public Div(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public Div(RemoteWebDriver driver, String identifier, int index) {
        super(driver, identifier, index);
    }

    public Div(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Div(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }
}
