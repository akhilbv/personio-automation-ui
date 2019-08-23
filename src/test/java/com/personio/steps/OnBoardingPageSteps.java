package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/*
Step definitions for on boarding
 */

public class OnBoardingPageSteps extends TestContext {
    @Then("^Onboarding page should be loaded$")
    public void settingsPageLoaded() {
        boolean isPageVisible = settingsPage().onBoardingPage().isVisible();
        Assert.assertEquals("Expected onboarding page to be displayed ", true, isPageVisible);
        settingsPage().waitForAjaxAndJSToLOad();
    }

    @When("^I select the \"([^\"]*)\" tab from Onboarding page$")
    public void iSelectOnboardTab(String tabName) {
        settingsPage().onBoardingPage().Tab(tabName).click();
        settingsPage().waitForAjaxAndJSToLOad();
    }

    @When("^I add a new onboarding step \"([^\"]*)\"$")
    public void iAddNewOnboardingStep(String stepName) {
        settingsPage().onBoardingPage().onBoardingStepsTab().stepName().sendKeys(stepName);
        settingsPage().onBoardingPage().onBoardingStepsTab().addStepButton().click();
    }

    @Then("^Step \"([^\"]*)\" should be listed in the step list$")
    public void stepShouldList(String stepName) {
        boolean isStepPresent = settingsPage().onBoardingPage().onBoardingStepsTab().stepList().contains(stepName);
        Assert.assertEquals("Created step " + stepName + " is not present in the step list ", true, isStepPresent);
    }

    @When("^I click on the Add item link in onboarding steps tab$")
    public void iClickAddItem() {
        settingsPage().onBoardingPage().onBoardingStepsTab().addItemLink().click();
        settingsPage().waitForAjaxAndJSToLOad();
    }

    @Then("^Add item to step dialogue should be displayed$")
    public void dialogueDisplay() {
        boolean isDialogueVisible = settingsPage().onBoardingPage().onBoardingStepsTab().addStepDialogue().isVisible();
        Assert.assertEquals("Add item to step dialogue is not visible", true, isDialogueVisible);

        String header = settingsPage().onBoardingPage().onBoardingStepsTab().addStepDialogue().getHeader();
        Assert.assertEquals("Expected dialogue header: Add item to step, but was " + header, "Add item to step", header);
    }

    @Then("^I click on the create button of add items to step dialogue$")
    public void iClickOnCreate() {
        settingsPage().onBoardingPage().onBoardingStepsTab().addStepDialogue().accept();
    }

    @When("^I add an item of type \"([^\"]*)\" to step$")
    public void iSelectItemType(String itemType) {
        settingsPage().onBoardingPage().onBoardingStepsTab().itemType().selectByVisibleText(itemType);
        iClickOnCreate();
    }

    @Then("^\"([^\"]*)\" should be displayed in the \"([^\"]*)\" row of step items$")
    public void itemShouldDisplay(String itemType, int index) {
        boolean isVisible = false;
        isVisible = settingsPage().onBoardingPage().onBoardingStepsTab().stepItemsTable().containsRowAtIndexWithTag(index, itemType);
        Assert.assertTrue(isVisible);
    }

    @When("^I set the value \"([^\"]*)\" to the field \"([^\"]*)\" in the \"([^\"]*)\" row of step items$")
    public void iSetValueToField(String valueToBeSet, String itemType, int index) {
        settingsPage().onBoardingPage().onBoardingStepsTab().stepItemsTable().setValueToFieldAtRowIndex(valueToBeSet, index, itemType);
    }

    @Then("^The field \"([^\"]*)\" in the \"([^\"]*)\" row of step items has value \"([^\"]*)\"$")
    public void fieldAtRowHasValue(String itemType, int index, String expectedValue) {
        String actualFieldValue = settingsPage().onBoardingPage().onBoardingStepsTab().stepItemsTable().getRowFieldValue(index, itemType);
        Assert.assertEquals(expectedValue, actualFieldValue);
    }

    @When("^I Save the onboarding steps$")
    public void iSaveStepChanges() {
        settingsPage().onBoardingPage().onBoardingStepsTab().saveChanges().click();
    }


}
