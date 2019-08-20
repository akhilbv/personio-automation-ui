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
 


