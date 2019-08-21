package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import com.personio.automation.ui.web.By;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.personio.automation.ui.web.By.by;


/*
Step definition for Navigation
 */

public class NavigationSteps extends TestContext {

    @When("^I click on the (settings|dashboard|export|import|employees) link in the navigation bar$")
    public void iSelectNavItem(String navItem) {
        navigationSideBar().selectNavItem(navItem);
    }

    @And("^\"([^\"]*)\" tab should be selected$")
    public void tabShouldBeSelected(String tabName) {
        String selectedTab = getBrowser().getDriver().findElement(by(By.ByType.CSS, "ul#employee_details_tab li.active a")).getText();
        Assert.assertEquals("Expected to select tab " + tabName + " but selected tab is " + selectedTab, tabName,selectedTab);
    }
}
