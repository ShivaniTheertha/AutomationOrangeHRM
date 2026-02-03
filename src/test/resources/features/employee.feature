Feature: Verify Employee Module
As a user of the OrangeHRM management system
I want to add and employee, search for the employee, and modify the employee details.

Background: User is logged into OrangeHRM
  Given the user is on the OrangeHRM login page
  When the user enters a valid username and password
  And the user clicks the login button after entering credentials
  Then the user should be redirected to the OrangeHRM dashboard page


Scenario: Add, Search, and Modify Employee Details
Given User navigates to the PIM module
When User adds a new employee
And User searches for the newly added employee
And User modifies the employee details
Then The employee details should be updated successfully

