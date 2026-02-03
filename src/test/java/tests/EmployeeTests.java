package tests;

import base.AuthenticatedBaseTest;
import flows.loginflows;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PIMPageObjects;
import utils.ConfigReader;
import utils.TestDataUtils;

public class EmployeeTests extends AuthenticatedBaseTest {

    static String FirstName=TestDataUtils.generateFirstName();
    static String LastName=TestDataUtils.generateLastName();
    static PIMPageObjects pimPage;
    static String middleName="A";

    @Test
    public void addEmployee() throws InterruptedException {
        // add employee
        loginflows loginFlow = new loginflows(driver);
        loginFlow.performLogin(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
        pimPage = new PIMPageObjects(driver);
        pimPage.navigateToPIMModule();
        pimPage.clickAddEmployeeButton();
        pimPage.enterEmployeeFirstName(FirstName);
        pimPage.enterEmployeeLastName(LastName);
        System.out.println(TestDataUtils.generateFirstName()+" "+TestDataUtils.generateLastName());
        pimPage.clickSaveButton();
       Assert.assertEquals(pimPage.getSuccessMessageText(),"Success\n" +
               "Successfully Saved\n" +
               "×");
    }

    @Test(dependsOnMethods = "addEmployee")
    public void searchEmployee() {
        // independent read test
        pimPage.clickEmployeeListTab();
        pimPage.setSearchEmployeeNameField(FirstName+" "+LastName);
        pimPage.clickSearchEmployeeButton();
    }

    @Test(dependsOnMethods = "searchEmployee")
    public void editEmployee() {
        // edit same employee
        pimPage.selectSearchedEmployee(LastName);
        pimPage.enterMiddleNameInPersonalDetails("A");
     //  Assert.assertEquals(pimPage.getModifiedMiddleName(FirstName+" "+middleName+" "+LastName,LastName),FirstName+" "+middleName);
    }


}
