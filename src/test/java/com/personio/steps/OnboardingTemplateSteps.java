package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/*
Step definitions for onboarding templates
 */
public class OnboardingTemplateSteps extends TestContext {

    @When("^I add a new onboarding template \"([^\"]*)\"$")
    public void iAddNewOnboardingStep(String templateName) {
        settingsPage().onBoardingPage().onBoardingTemplateTab().templateName().sendKeys(templateName);
        settingsPage().onBoardingPage().onBoardingTemplateTab().addTemplateButton().click();
    }

    @Then("^template \"([^\"]*)\" (should be|should not be) listed in the template list$")
    public void templateShouldList(String templateName, String choice) {
        boolean isStepPresent = settingsPage().onBoardingPage().onBoardingTemplateTab().templateList().contains(templateName);
        switch (choice) {
            case "should be":
                Assert.assertEquals("Created step " + templateName + " is not present in the step list ", true, isStepPresent);
                break;
            case "should not be":
                Assert.assertEquals("Created step " + templateName + " is not present in the step list ", false, isStepPresent);
                break;
        }
    }

    @When("^I click on the Add step link in onboarding templates tab$")
    public void iClickAddItem() {
        settingsPage().onBoardingPage().onBoardingTemplateTab().addStepLink().click();
        settingsPage().waitForAjaxAndJSToLOad();
    }

    @Then("^Add step to template dialogue should be displayed$")
    public void dialogueDisplay() {
        boolean isDialogueVisible = settingsPage().onBoardingPage().onBoardingTemplateTab().addStepDialogue().isEnabled();
        Assert.assertEquals("Add step to template dialogue is not visible", true, isDialogueVisible);

        String header = settingsPage().onBoardingPage().onBoardingTemplateTab().addStepDialogue().getHeader();
        Assert.assertEquals("Expected dialogue header: Add step to template, but was " + header, "Add step to template", header);
    }

    @Then("^I select the step \"([^\"]*)\" from the step list$")
    public void iSelectStep(String itemToSelect) {
        settingsPage().onBoardingPage().onBoardingTemplateTab().stepList().selectItem(itemToSelect);
    }

    @Then("^I select the responsible \"([^\"]*)\" from the response list$")
    public void iSelectResponsible(String itemToSelect) {
        settingsPage().onBoardingPage().onBoardingTemplateTab().responsible().selectItem(itemToSelect);
    }

    @Then("^I add deadline as \"([^\"]*)\" days (before hire|after hire)$")
    public void iSelectResponsible(String days, String direction) {
        settingsPage().onBoardingPage().onBoardingTemplateTab().deadLine().sendKeys(days);
        settingsPage().onBoardingPage().onBoardingTemplateTab().deadlineDirection().selectItem(direction);
    }

    @Then("^Step list contains the step \"([^\"]*)\" at row \"([^\"]*)\" and column \"([^\"]*)\"")
    public void stepTableContains(String expectedSteName, int rowIndex, int columnIndex) {
        String actualStepName = settingsPage().onBoardingPage().onBoardingTemplateTab().addedSteps().getCellValue(rowIndex, columnIndex);
        Assert.assertEquals(expectedSteName, actualStepName);
    }

    @Then("The field \"([^\"]*)\" at row \"([^\"]*)\" and column \"([^\"]*)\" of step lists has value \"([^\"]*)\"")
    public void stepTableContains(String tagName, int rowIndex, int columnIndex, String expectedValue) {
        String actualValue = settingsPage().onBoardingPage().onBoardingTemplateTab().addedSteps().getCellFieldValue(rowIndex, columnIndex, tagName);
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Then("^I click on the create button of steps to template dialogue")
    public void iClickOnCreate() {
        settingsPage().onBoardingPage().onBoardingTemplateTab().addStepDialogue().create().click();
    }

    @When("^I delete the onboarding templates with name \"([^\"]*)\"$")
    public void iDeleteTemplate(String templateName) {
        settingsPage().onBoardingPage().onBoardingTemplateTab().deleteTemplates(templateName);
    }


}
