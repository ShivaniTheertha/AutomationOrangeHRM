package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PIMPageObjects;
import utils.ConfigReader;
import utils.TestDataUtils;


public class EmployeeSteps {

    static PIMPageObjects pimPage;
    static String FirstName= TestDataUtils.generateFirstName();
    static String LastName=TestDataUtils.generateLastName();

    WebDriver driver;

    public EmployeeSteps() {
        this.driver = DriverFactory.initDriver(ConfigReader.get("browser"));
    }


    @Given("User navigates to the PIM module")
    public void given_user_navigates_to_the_pim_module() {
        pimPage = new PIMPageObjects(driver);
        pimPage.navigateToPIMModule();
    }

    @When("User adds a new employee")
    public void user_adds_a_new_employee() {
        pimPage.clickAddEmployeeButton();
        pimPage.enterEmployeeFirstName(FirstName);
        pimPage.enterEmployeeLastName(LastName);
        System.out.println(TestDataUtils.generateFirstName()+" "+TestDataUtils.generateLastName());
        pimPage.clickSaveButton();
    }


    @And("User searches for the newly added employee")
    public void user_searches_for_the_newly_added_employee() {
        pimPage.clickEmployeeListTab();
        pimPage.setSearchEmployeeNameField(FirstName+" "+LastName);
        pimPage.clickSearchEmployeeButton();
    }

    @And("User modifies the employee details")
    public void user_modifies_the_employee_details() {
      //  pimPage.selectSearchedEmployee(LastName);
      //  pimPage.enterMiddleNameInPersonalDetails("A");
    }


    @Then("The employee details should be updated successfully")
    public void the_employee_details_should_be_updated_successfully() {
        // Verification logic can be added here
        //System.out.println(pimPage.getSuccessMessageText());
    }




}
