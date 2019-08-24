package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.personio.automation.ui.web.By.by;

/*
    Properties of the html element : List
*/

public class ListItem extends BaseHtmlElement {
    public ListItem(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public ListItem(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
    }

    public ListItem(RemoteWebDriver driver, String identifier, By.ByType identifierType, int index) {
        super(driver, identifier, identifierType, index);
    }

    public ListItem(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public ListItem(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }

    /*
        Identifying an list item based on the provided text
     */
    public WebElement getListItem(String itemName) {
        List<WebElement> listItems = getElement().findElements(by(By.ByType.TagName, "li"));
        return listItems.stream()
                .filter(webElement -> Objects.equals(webElement.getText(), itemName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + itemName));
    }

    /*Checks the presence of list item based on the provided text
     */
    public boolean contains(String itemName) {
        List<WebElement> listItems = getElement().findElements(by(By.ByType.TagName, "li"));
        return !listItems.stream().filter(webElement ->
                Objects.equals(webElement.getText(), itemName)).findFirst().isEmpty();
    }

    public List getListItems(String itemName) {
        List<WebElement> listItems = getElement().findElements(by(By.ByType.TagName, "li"));
        return listItems.stream()
                .filter(webElement -> Objects.equals(webElement.getText(), itemName))
                .collect(Collectors.toList());
    }
}
