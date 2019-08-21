@module=on/offboarding
@feature=onboarding
Feature: Onboarding

  @id=onboarding01
  Scenario: As a user,I can create an onboarding template with steps for a new employee
    Given I am logged in to the application as "akhilbabuv@gmail.com" with password "Welcome@123"
    Then Home page of the user "Akhil Babu V" is loaded
    When I click on the settings link in the navigation bar
    Then Settings page should be loaded
    When I click on the on-offboarding link in the settings page
    Then Onboarding page should be loaded
    And "Onboarding Templates" tab should be selected
    When I select the "Onboarding Steps" tab from Onboarding page
    Then "Onboarding Steps" tab should be selected
    When I add a new onboarding step "An Onboarding Step"
    Then Step "An Onboarding Step" should be listed in the step list
    When I click on the Add item link
    Then "Add item to step" dialogue should be displayed
    When I add an item of type "Text information" to step
    Then "textarea" should be displayed in the row "0" of "An Onboarding Step" step





