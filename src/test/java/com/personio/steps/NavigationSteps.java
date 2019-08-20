package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import com.personio.automation.ui.web.By;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


/*
Step definition for Navigation
 */

public class NavigationSteps extends TestContext {

    @When("^I click on the (settings|dashboard|export|import|employees) link in the navigation bar$")
    public void iSelectNavItem(String navItem) {
        navigationSideBar().selectNavItem(navItem);
    }

}
