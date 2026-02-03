package tests;

import base.BaseTest;
import base.FreshBrowserBaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageObjects;
import utils.ConfigReader;

public class LoginTests extends FreshBrowserBaseTest {


    LoginPageObjects loginPage;


    @Test
    public void validLoginTest() {
        // Test code for valid login
        loginPage=new LoginPageObjects(driver);
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLoginAfterEnteringCredentials();
        loginPage.verifySuccessfulLogin();
    }

    @Test
    public void invalidLoginTest() {
        // Test code for invalid login
        loginPage=new LoginPageObjects(driver);
        loginPage.enterUsername(ConfigReader.get("invalidUsername"));
        loginPage.enterPassword(ConfigReader.get("invalidPassword"));
        loginPage.clickLoginAfterEnteringCredentials();
        loginPage.verifyInvalidCredentialsMessage();
    }

    @Test
    public void LoginWithEmptyFields(){
        // Test code for login with empty fields
        loginPage=new LoginPageObjects(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.ClickLoginWithoutEnteringCredentials();
        loginPage.verifyEmptyFieldsMessage();
    }



}
