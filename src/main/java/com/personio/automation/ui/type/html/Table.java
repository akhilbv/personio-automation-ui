package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

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

    public String getCellFieldValue(int rowIndex, int columnIndex ,String tagname) {
        List<WebElement> tableRows = getElement().findElements(by(By.ByType.TagName, "tr"));
        List<WebElement> tableColumns = tableRows.get(rowIndex).findElements(by(By.ByType.Xpath, "td"));
        WebElement element = tableColumns.get(columnIndex).findElement(by(By.ByType.Xpath,".//"+tagname));
        if (tagname.contains("input") && element.getText().isEmpty()) {
            return element.getAttribute("value");
        } else if (tagname.contains("select")) {
            return new Select(element).getFirstSelectedOption().getText();
        }
        return element.getText();
    }

    public String getCellValue(int rowIndex, int columnIndex) {
        List<WebElement> tableRows = getElement().findElements(by(By.ByType.TagName, "tr"));
        List<WebElement> tableColumns = tableRows.get(rowIndex).findElements(by(By.ByType.Xpath, "td"));

        return tableColumns.get(columnIndex).getText();
    }
}

