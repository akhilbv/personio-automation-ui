package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import com.personio.automation.ui.web.By;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/*
Step definition for Settings page
 */
public class SettingsPageSteps extends TestContext {
    @Then("^Settings page should be loaded$")
    public void settingsPageLoaded() {
        boolean isLabelVisible = settingsPage().Label("//strong[text()='Settings']", By.ByType.Xpath).isVisible();
        Assert.assertEquals("Expected label settings to be displayed ", true, isLabelVisible);
    }


    @When("^I click on the (on-offboarding|calendars|attendance|company|employee roles) link in the settings page$")
    public void iSelectSettings(String settingsItem) {
        settingsPage().selectSettings(settingsItem);
    }
}
