package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
    Properties of the html element : Table
*/

public class Table extends  BaseHtmlElement{
    public Table(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public Table(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public Table(RemoteWebDriver driver, String identifier, int index) {
        super(driver, identifier, index);
    }

    public Table(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Table(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }
}
