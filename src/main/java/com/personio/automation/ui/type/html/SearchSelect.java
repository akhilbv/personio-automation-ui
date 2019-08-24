package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
Class for Search Select Items in web page
 */
public class SearchSelect extends BaseHtmlElement {

    public SearchSelect(RemoteWebDriver driver, String id) {
        super(driver, id);
    }

    public SearchSelect(RemoteWebDriver driver, String id, By.ByType byType) {
        super(driver, id, byType);
    }

    public void selectItem(String itemToBeSelect) {

        Div dropDown = new Div(getDriver(), getParentElement(), "div.chosen-container.chosen-container-single", By.ByType.CSS);
        if (dropDown != null) {
            dropDown.click();
        } else {
            throw new AssertionError("Search Select not found in the page");
        }
        TextField serachBox = new TextField(getDriver(), getParentElement(), "input.chosen-search-input", By.ByType.CSS);
        serachBox.sendKeys(itemToBeSelect);
        ListItem searchResult = new ListItem(getDriver(), getParentElement(), "li.active-result.highlighted", By.ByType.CSS);
        if (searchResult != null) {
            searchResult.click();
        }
    }
}
