package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AdminPageObjects;
import pages.DashboardPageObjects;
import pages.LoginPageObjects;
import base.DriverFactory;
import utils.ConfigReader;

public class LoginSteps{


    WebDriver driver;
    LoginPageObjects loginPage;

    public LoginSteps() {
        // Fetch the same driver initialized by TestHooks
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPageObjects(driver);
    }
    /*
     Given the user is on the OrangeHRM login page
  When the user enters a valid username and password
  And the user clicks the login button
  Then the user should be redirected to the OrangeHRM dashboard page
     */

    @Given("the user is on the OrangeHRM login page")
    public void the_user_is_on_the_orange_hrm_login_page() {
        DashboardPageObjects dashboardPage = new DashboardPageObjects(driver);
        dashboardPage.verifyLoginPage();
    }

    @When("the user enters a valid username and password")
    public void when_the_user_enters_a_valid_username_and_password() {
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
    }

    @And("the user clicks the login button after entering credentials")
    public void and_the_user_clicks_the_login_button() {
        // This step is already handled in the previous step
        loginPage.clickLoginAfterEnteringCredentials();
    }

    @And("the user clicks the login button without entering credentials")
    public void and_the_user_clicks_the_login_button_without_entering_credentials() {
        // This step is already handled in the previous step
        loginPage.ClickLoginWithoutEnteringCredentials();
    }

    @And("the user clicks the login button after entering invalid credentials")
    public void and_the_user_clicks_the_login_button_after_entering_invalid_credentials() {
        // This step is already handled in the previous step
        loginPage.ClickLoginWithInvalidCredentials();
    }


    @Then("the user should be redirected to the OrangeHRM dashboard page")
    public void the_user_should_be_redirected_to_the_orange_hrm_dashboard_page() {
        loginPage.verifySuccessfulLogin();
    }


    @When("the user enters an invalid username and password")
    public void when_the_user_enters_an_invalid_username_and_password() {
        loginPage.enterUsername(ConfigReader.get("invalidUsername"));
        loginPage.enterPassword(ConfigReader.get("invalidPassword"));
    }


    @Then("an error message should be displayed indicating invalid credentials")
    public void an_error_message_should_be_displayed_indicating_invalid_credentials() {
        loginPage.verifyInvalidCredentialsMessage();
    }

    @When("the user leaves the username and password fields empty")
    public void when_the_user_leaves_the_username_and_password_fields_empty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @Then("an error message should be displayed indicating that username and password are required")
    public void an_error_message_should_be_displayed_indicating_that_username_and_password_are_required() {
        loginPage.verifyEmptyFieldsMessage();
    }



}
