package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
    Properties of the html element : Label
*/

public class Label extends BaseHtmlElement {
    public Label(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public Label(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public Label(RemoteWebDriver driver, String identifier, int index) {
        super(driver, identifier, index);
    }

    public Label(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Label(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }
}
