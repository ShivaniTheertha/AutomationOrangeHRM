package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AdminPageObjects;
import pages.DashboardPageObjects;
import pages.LoginPageObjects;
import utils.ConfigReader;

public class LogOutSteps {



    WebDriver driver;
    DashboardPageObjects dashboardPage;

    public LogOutSteps() {
        // Fetch the same driver initialized by TestHooks
        this.driver = DriverFactory.getDriver();
        dashboardPage = new DashboardPageObjects(driver);
    }

    @Given("User clicks on the user profile icon on the dashboard page")
    public void user_clicks_on_the_user_profile_icon_on_the_dashboard_page() {
        dashboardPage.ClickMyAccountButton();
    }


   @When("User selects the Logout option from the dropdown menu")
   public void user_selects_the_logout_option_from_the_dropdown_menu() {
       dashboardPage.ClickLogOutButton();
   }

    @Then("The user should be redirected to the OrangeHRM login page")
    public void the_user_should_be_redirected_to_the_orange_hrm_login_page() {
        LoginPageObjects loginPage = new LoginPageObjects(driver);
        loginPage.verifyLoginPage();
    }
}
