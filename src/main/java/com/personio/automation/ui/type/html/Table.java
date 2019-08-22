package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Objects;

import static com.personio.automation.ui.web.By.by;

/*
    Properties of the html element : Table
*/

public class Table extends BaseHtmlElement {
    public Table(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public Table(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public Table(RemoteWebDriver driver, String identifier, By.ByType identifierType, int index) {
        super(driver, identifier, identifierType, index);
    }

    public Table(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Table(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }

    public boolean containsRowAtIndexWithTag(int rowIndex, String tagname) {
        List<WebElement> tableRows = getElement().findElements(by(By.ByType.TagName, "tr"));
        try {
            WebElement element = tableRows.get(rowIndex).findElement(by(By.ByType.Xpath, "td/" + tagname + ""));
            return element.isEnabled();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        }
    }

    public void setValueToFieldAtRowIndex(String valueToBeSet, int rowIndex, String tagname) {
        List<WebElement> tableRows = getElement().findElements(by(By.ByType.TagName, "tr"));
        WebElement element = tableRows.get(rowIndex).findElement(by(By.ByType.Xpath, "td/" + tagname + ""));
        scrollIntoView(element);
        element.sendKeys(valueToBeSet);
    }

    public String getRowFieldValue(int rowIndex, String tagname) {
        List<WebElement> tableRows = getElement().findElements(by(By.ByType.TagName, "tr"));
        WebElement element = tableRows.get(rowIndex).findElement(by(By.ByType.Xpath, "td/" + tagname + ""));
        if (tagname.contains("input") && element.getText().isEmpty()) {
            return element.getAttribute("value");
        }
        return element.getText();
    }
}

