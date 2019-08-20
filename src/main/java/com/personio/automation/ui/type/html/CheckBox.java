package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
    Properties of the html element : checkbox
*/
public class CheckBox extends BaseHtmlElement {
    public CheckBox(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public CheckBox(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public CheckBox(RemoteWebDriver driver, String identifier, int index) {
        super(driver, identifier, index);
    }

    public CheckBox(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public CheckBox(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }

    public boolean isChecked() {
        return getElement().getAttribute("checked") != null || getElement().isSelected();
    }

    /*for selecting the checkbox*/
    public void check() {
        if (!isChecked()) {
            click();
        }
    }

    /*for un-selecting the checkbox*/
    public void unCheck() {
        if (isChecked()) {
            click();
        }
    }
}
