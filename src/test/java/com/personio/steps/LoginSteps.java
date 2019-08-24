package com.personio.steps;


import com.personio.automation.ui.context.TestContext;
import cucumber.api.java.en.When;

/*
Step defintions for Login page
 */
public class LoginSteps extends TestContext {

    @When("^I am logged in to the application as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void iLoginToApplication(String userName, String password) {
        loginPage().login(userName, password);
    }
}
