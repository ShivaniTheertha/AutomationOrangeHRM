package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AdminPageObjects;


public class AdminSteps {


    WebDriver driver;
    AdminPageObjects adminPage;

    public AdminSteps() {
        // Fetch the same driver initialized by TestHooks
        this.driver = DriverFactory.getDriver();
        adminPage = new AdminPageObjects(driver);
    }

   @When("User Navigates to the Admin module")
   public void user_navigates_to_the_admin_module() {
       adminPage = new AdminPageObjects(driver);
       adminPage.clickOnAdminModule();
   }

    @Then("the admin module header should be displayed correctly")
    public void the_admin_module_header_should_be_displayed_correctly() {
        adminPage.verifyAdminPageHeader();
    }


}
