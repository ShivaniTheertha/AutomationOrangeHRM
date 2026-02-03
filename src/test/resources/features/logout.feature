Feature: LogOut Functionality from DashBoard Page
  As a user of OrangeHRM Management Systems
  I want to access the logout functionality from the dashboard page
  so that the session can be securely terminated.

Background: User is logged into OrangeHRM
  Given the user is on the OrangeHRM login page
  When the user enters a valid username and password
  And the user clicks the login button after entering credentials
  Then the user should be redirected to the OrangeHRM dashboard page

Scenario: Logout from Dashboard Page
  Given User clicks on the user profile icon on the dashboard page
  When User selects the Logout option from the dropdown menu
  Then The user should be redirected to the OrangeHRM login page


