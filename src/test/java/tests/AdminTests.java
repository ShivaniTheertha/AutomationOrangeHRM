package tests;

import base.AuthenticatedBaseTest;
import flows.loginflows;
import org.testng.annotations.Test;
import pages.AdminPageObjects;
import utils.ConfigReader;

public class AdminTests extends AuthenticatedBaseTest {

    static AdminPageObjects adminPage;

    @Test
    public void adminTestExample() throws InterruptedException {
        loginflows loginFlow = new loginflows(driver);
        loginFlow.performLogin(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
        // Example test code for admin functionalities
        adminPage=new AdminPageObjects(driver);
        adminPage.clickOnAdminModule();
        adminPage.verifyAdminPageHeader();

    }



}
