package flows;

import org.openqa.selenium.WebDriver;
import pages.LoginPageObjects;

public class loginflows {

    private WebDriver driver;
    private LoginPageObjects loginPage;



    public loginflows(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPageObjects(driver);
    }

    public void performLogin(String username, String password) throws InterruptedException {
        // Logic to perform login using provided username and password
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginAfterEnteringCredentials();

    }

}
