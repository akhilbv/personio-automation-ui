package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
    Properties of the html element : TextArea
*/

public class TextArea extends BaseHtmlElement {
    public TextArea(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public TextArea(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public TextArea(RemoteWebDriver driver, String identifier,By.ByType identifierType, int index) {
        super(driver, identifier,identifierType, index);
    }

    public TextArea(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public TextArea(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }

    public void clear()
    {
        getElement().clear();
    }
}
