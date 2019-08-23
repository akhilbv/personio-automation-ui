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

    When I click on the Add item link in onboarding steps tab
    Then Add item to step dialogue should be displayed
    When I add an item of type "Text information" to step
    Then Success message should be displayed
    Then "textarea" should be displayed in the "0" row of step items

    When I click on the Add item link in onboarding steps tab
    Then Add item to step dialogue should be displayed
    When I add an item of type "Document for download" to step
    Then Success message should be displayed
    Then "input[@type='file']" should be displayed in the "1" row of step items
    And "input[@type='text']" should be displayed in the "1" row of step items

    When I click on the Add item link in onboarding steps tab
    Then Add item to step dialogue should be displayed
    When I add an item of type "Profile picture" to step
    Then Success message should be displayed
    Then "input[@type='text']" should be displayed in the "2" row of step items

    Then I set the value "Please brief yourself" to the field "textarea" in the "0" row of step items
    And I set the value "Please download the guidelines from here" to the field "input[@type='text']" in the "1" row of step items
    And I set the value "Please upload your recent profile picture" to the field "input[@type='text']" in the "2" row of step items
    When I Save the onboarding steps
    Then Success message should be displayed
    And The field "textarea" in the "0" row of step items has value "Please brief yourself"
    And The field "input[@type='text']" in the "1" row of step items has value "Please download the guidelines from here"
    And The field "input[@type='text']" in the "2" row of step items has value "Please upload your recent profile picture"

    When I select the "Onboarding Templates" tab from Onboarding page
    Then "Onboarding Templates" tab should be selected
    When I add a new onboarding template "An Onboarding Template"
    Then template "An Onboarding Template" should be listed in the template list
    When I click on the Add step link in onboarding templates tab
    Then Add step to template dialogue should be displayed
    And I select the step "An Onboarding Step" from the step list
    And I select the responsible "Employee" from the response list
    And I add deadline as "2" days "after hire"

