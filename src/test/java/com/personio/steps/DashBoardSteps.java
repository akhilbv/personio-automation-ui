package com.personio.steps;


import com.personio.automation.ui.context.TestContext;
import com.personio.automation.ui.web.By;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/*
Step definition for Dashboard page
 */
public class DashBoardSteps extends TestContext {

    public DashBoardSteps() {
        super();
    }

    @Then("^Home page of the user \"([^\"]*)\" is loaded$")
    public void homePageIsLoaded(String userFullName) {
        boolean isDhashboardVisible = dashBoard().Div("dashboard-v2-container", By.ByType.Id).isEnabled();
        Assert.assertEquals("Dashboard is not visible after login", true, isDhashboardVisible);

        boolean isUserNameVisible = dashBoard().Div("//div[text()='" + userFullName + "']", By.ByType.Xpath).isEnabled();
        Assert.assertEquals("User name:"+userFullName+" is not visible in the profile panel", true, isUserNameVisible);
    }

}
