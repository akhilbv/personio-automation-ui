package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
    Properties of the html element : TextField
*/

public class TextField extends BaseHtmlElement {
    public TextField(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public TextField(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public TextField(RemoteWebDriver driver, String identifier, int index) {
        super(driver, identifier, index);
    }

    public TextField(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public TextField(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }


    public void clear()
    {
        getElement().clear();
    }
}
