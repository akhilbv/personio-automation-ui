@module=on/offboarding
@feature=onboarding
Feature: Onboarding

  Background:
    Given I am logged in to the application as "akhilbabuv@gmail.com" with password "Welcome@123"
    Then Home page of the user "Akhil Babu V" is loaded
    When I click on the settings link in the navigation bar
    Then Settings page should be loaded
    When I click on the on-offboarding link in the settings page
    Then Onboarding page should be loaded

  @id=onboarding01 @smoketest
  Scenario: As a user,I can create an onboarding template with steps for a new employee

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

    Then I set the value "Please brief about yourself" to the field "textarea" in the "0" row of step items
    And I set the value "Please download the guidelines from here" to the field "input[@type='text']" in the "1" row of step items
    And I set the value "Please upload your recent profile picture" to the field "input[@type='text']" in the "2" row of step items
    When I Save the onboarding steps
    Then Success message should be displayed
    And The field "textarea" in the "0" row of step items has value "Please brief about yourself"
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
    And I add deadline as "2" days after hire
    When I click on the create button of steps to template dialogue
    Then Success message should be displayed
    Then Step list contains the step "An Onboarding Step" at row "0" and column "1"
    And The field "select" at row "0" and column "2" of step lists has value "Employee"
    And The field "input" at row "0" and column "3" of step lists has value "2"
    And The field "select" at row "0" and column "3" of step lists has value "after hire"

    When I Save the onboarding steps
    Then Success message should be displayed

    When I click on the employees link in the navigation bar
    Then Employees page should be loaded
    When I search for the employee "akhilbabuv@gmail.com"
    And I select the profile of employee "Akhil"
    Then Profile page of employee "Akhil Babu V" should be loaded
    Then I select the profile tab "Onboarding"
    When I assign the template "An Onboarding Template" to employee
    Then Success message should be displayed
    And Template "An Onboarding Template" should be listed under to do


  @id=onboarding02 @dataCleanup
  Scenario: As a user,I can delte the onboarding templates and steps

    And "Onboarding Templates" tab should be selected
    When I delete the onboarding templates with name "An Onboarding Template"
    Then template "An Onboarding Template" should not be listed in the template list
    When I select the "Onboarding Steps" tab from Onboarding page
    Then "Onboarding Steps" tab should be selected
    When I delete the onboarding steps with name "An Onboarding Step"
    Then Step "An Onboarding Step" should not be listed in the step list





