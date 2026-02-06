package tests;

import base.BaseTest;
import base.FreshBrowserBaseTest;
import flows.loginflows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DashboardPageObjects;
import pages.LoginPageObjects;
import utils.ConfigReader;

public class LogOutTests extends FreshBrowserBaseTest {

@Test
    public void logoutFromApplication() throws InterruptedException {
    loginflows loginFlow = new loginflows(driver);
    loginFlow.performLogin(
            ConfigReader.get("username"),
            ConfigReader.get("password")
    );
        DashboardPageObjects dashboardPage = new DashboardPageObjects(driver);
        dashboardPage.ClickMyAccountButton();
        dashboardPage.ClickLogOutButton();
        LoginPageObjects loginPage=new pages.LoginPageObjects(driver);
        loginPage.verifyLoginPage();
    }
}

