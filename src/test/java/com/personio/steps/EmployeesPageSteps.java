package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
/*
Step definitions for employees page
 */
public class EmployeesPageSteps extends TestContext {

    @Then("^Employees page should be loaded$")
    public void employeePageLoaded() {
        boolean isPageVisible = employeesPage().employeeSearchBox().isVisible();
        Assert.assertEquals("Expected employees page to be displayed ", true, isPageVisible);
        employeesPage().waitForAjaxAndJSToLOad();
    }

    @When("^I search for the employee \"([^\"]*)\"")
    public void iSearchForEmployee(String userName) {
        employeesPage().searchForEmployee(userName);
    }

    @Then("^I select the profile of employee \"([^\"]*)\"")
    public void iSelectEmployeeProfile(String employeeName) {
        employeesPage().selectEmployeeProfile(employeeName);
    }
}
