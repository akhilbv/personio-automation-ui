package com.personio.steps;

import com.personio.automation.ui.context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OnboardingTemplateSteps extends TestContext {

    @When("^I add a new onboarding template \"([^\"]*)\"$")
    public void iAddNewOnboardingStep(String templateName) {
        settingsPage().onBoardingPage().onBoardingTemplateTab().templateName().sendKeys(templateName);
        settingsPage().onBoardingPage().onBoardingTemplateTab().addTemplateButton().click();
    }

    @Then("^template \"([^\"]*)\" should be listed in the template list$")
    public void templateShouldList(String templateName) {
        boolean isStepPresent = settingsPage().onBoardingPage().onBoardingTemplateTab().templateList().contains(templateName);
        Assert.assertEquals("Created step " + templateName + " is not present in the step list ", true, isStepPresent);
    }

    @When("^I click on the Add step link in onboarding templates tab$")
    public void iClickAddItem() {
        settingsPage().onBoardingPage().onBoardingTemplateTab().addStepLink().click();
        settingsPage().waitForAjaxAndJSToLOad();
    }

    @Then("^Add step to template dialogue should be displayed$")
    public void dialogueDisplay() {
        boolean isDialogueVisible = settingsPage().onBoardingPage().onBoardingTemplateTab().addStepDialogue().isVisible();
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

}
