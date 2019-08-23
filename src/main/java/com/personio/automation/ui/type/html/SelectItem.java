package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

/*
    Properties of the html element : Select
*/

public class SelectItem extends BaseHtmlElement {
    public SelectItem(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public SelectItem(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public SelectItem(RemoteWebDriver driver, String identifier, By.ByType identifierType, int index) {
        super(driver, identifier, identifierType, index);
    }

    public SelectItem(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public SelectItem(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }

    public void selectItem(String itemToSelect)
    {
       Select dropDown =  new Select(getElement());
       dropDown.selectByVisibleText(itemToSelect);
    }
}
