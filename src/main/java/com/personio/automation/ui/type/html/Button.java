package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
    Properties of the html element : Button
*/
public class Button extends BaseHtmlElement {
    public Button(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public Button(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public Button(RemoteWebDriver driver, String identifier, By.ByType identifierType, int index) {
        super(driver, identifier, identifierType, index);
    }

    public Button(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Button(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }
}
