package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OnBoardingPageSteps extends TestContext {
    @Then("^Onboarding page should be loaded$")
    public void settingsPageLoaded() {
        boolean isPageVisible = settingsPage().onBoardingPage().isVisible();
        Assert.assertEquals("Expected onboarding page to be displayed ", true, isPageVisible);
    }

    @When("^I select the \"([^\"]*)\" tab from Onboarding page$")
    public void iSelectOnboardTab(String tabName) {
        settingsPage().onBoardingPage().Tab(tabName).click();
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

    @When("^I click on the Add item link$")
    public void iClickAddItem() {
        settingsPage().onBoardingPage().onBoardingStepsTab().addItemLink().click();
    }

    @Then("^\"([^\"]*)\" dialogue should be displayed$")
    public void dialogueDisplay(String dialogueHeader) {
        boolean isDialogueVisible = settingsPage().onBoardingPage().onBoardingStepsTab().addStepDialogue().isVisible();
        Assert.assertEquals(dialogueHeader + " dialogue is not visible", true, isDialogueVisible);

        String header = settingsPage().onBoardingPage().onBoardingStepsTab().addStepDialogue().getHeader();
        Assert.assertEquals("Expected dialogue header " + dialogueHeader + "but was " + header, dialogueHeader, header);
    }

    @Then("^I click on the create button$")
    public void iClickOnCreate() {
        settingsPage().onBoardingPage().onBoardingStepsTab().addStepDialogue().accept();
    }

    @When("^I add an item of type \"([^\"]*)\" to step$")
    public void iSelectItemType(String itemType) {
        settingsPage().onBoardingPage().onBoardingStepsTab().itemType().selectByVisibleText(itemType);
        iClickOnCreate();
    }
    @Then("^\"([^\"]*)\" should be displayed in the row \"([^\"]*)\" of \"([^\"]*)\" step$")
    public void itemShouldDisplay(String itemType,int index,String stepName) {
        boolean isVisible=false;
        switch (itemType) {
            case "textarea":
               isVisible =  settingsPage().onBoardingPage().onBoardingStepsTab().stepItemTextArea(index,stepName).isVisible();
               break;
        }
        Assert.assertTrue(isVisible);
    }

}
