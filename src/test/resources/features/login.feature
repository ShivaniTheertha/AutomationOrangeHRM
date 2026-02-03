Feature: Login Functionality of OrangeHRM Application
As a user of OrangeHRM application
I want to be able to log in with valid credentials
So that I can access the application's features

Scenario: Successful Login with Valid Credentials
  Given the user is on the OrangeHRM login page
  When the user enters a valid username and password
  And the user clicks the login button after entering credentials
  Then the user should be redirected to the OrangeHRM dashboard page

Scenario: Unsuccessful login with Invalid Credentials
  Given the user is on the OrangeHRM login page
  When the user enters an invalid username and password
  And the user clicks the login button after entering invalid credentials
  Then an error message should be displayed indicating invalid credentials

Scenario: Unsuccessful login with Empty Credentials
  Given the user is on the OrangeHRM login page
  When the user leaves the username and password fields empty
  And the user clicks the login button without entering credentials
  Then an error message should be displayed indicating that username and password are required
