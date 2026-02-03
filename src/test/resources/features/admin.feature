Feature: Verify Admin Module
  As a user of the OrangeHRM management system
  I want to navigate to the Admin module and verify its header
  so that I can ensure the module is functioning correctly.

Background: User is logged into OrangeHRM
  Given the user is on the OrangeHRM login page
  When the user enters a valid username and password
  And the user clicks the login button after entering credentials
  Then the user should be redirected to the OrangeHRM dashboard page

Scenario: Navigate to Admin Module and Verify Header
  When User Navigates to the Admin module
  Then the admin module header should be displayed correctly
