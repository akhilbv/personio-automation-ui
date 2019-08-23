package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
/*
Step definitions for employee profile page
 */
public class EmployeeProfilePageSteps extends TestContext {

    @Then("^Profile page of employee \"([^\"]*)\" should be loaded$")
    public void employeeProfilePageLoaded(String employeeName) {
        employeesPage().waitForAjaxAndJSToLOad();
        employeesPage().employeeProfilePage().profileHeadLine().click();

        String actualEmployeeName = employeesPage().employeeProfilePage().profileHeadLine().getText();
        Assert.assertEquals(employeeName,actualEmployeeName);
    }

    @When("^I select the profile tab \"([^\"]*)\"$")
    public void iSelectProfileTab(String tabName) {
        employeesPage().employeeProfilePage().selectTab(tabName);
    }

    @When("^I select the onboarding template \"([^\"]*)\"")
    public void iSelectOnboardingTemplate(String templateName)
    {
        employeesPage().employeeProfilePage().selectTab(templateName);
    }

    @When("^I assign the template \"([^\"]*)\" to employee$")
    public void iAssignTemplate(String templateName)
    {
        employeesPage().employeeProfilePage().assignTemplate(templateName);
    }

    @Then ("^Template \"([^\"]*)\" should be listed under to do$")
    public void templateListUnderToDo(String templateName)
    {
       boolean toDoListContains = employeesPage().employeeProfilePage().toDoListContains(templateName);
        Assert.assertTrue(toDoListContains);
    }
}
