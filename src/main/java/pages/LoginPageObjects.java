package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.waitutils;

import java.time.Duration;

public class LoginPageObjects {

    WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
    }


By username= By.xpath("//input[@name='username']");
By password= By.xpath("//input[@name='password']");
By loginButton= By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]");
By loggedInVerification= By.xpath("//h6[normalize-space()='Dashboard']");
By invalidCredentialsMessage= By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
By userNameRequiredMessage= By.xpath("//input[@name='username']/ancestor::div[1]/following-sibling::span");
By passwordRequiredMessage= By.xpath("//input[@name='password']/ancestor::div[1]/following-sibling::span");


public void enterUsername(String user) {
    waitutils.waitForElement(driver, username, 10);
    driver.findElement(username).sendKeys(user);
}
public void enterPassword(String pass) {
    driver.findElement(password).sendKeys(pass);
}

public void clickLoginAfterEnteringCredentials() {
    waitutils.waitForPageToLoad(driver, 10);
   // waitutils.waitForElementToBeClickable(driver, loginButton, 10);
   driver.findElement(loginButton).click();
     DashboardPageObjects dashboardPage = new DashboardPageObjects(driver);
   waitutils.waitForurlToContain(driver, "dashboard", 10);
   waitutils.waitForLoaderToDisappear(driver, dashboardPage.spinner, 10);
   waitutils.waitForElementToBePresent(driver, dashboardPage.topbarHeader, 10);

       //waitutils.waitForElement(driver, dashboardPage.DashboardHeader, 10);
    //waitutils.waitForUIToSettle();
   // ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
}

public void ClickLoginWithInvalidCredentials() {
    // Wait for login page to be ready
    waitutils.waitForPageToLoad(driver, 10);
  //  waitutils.waitForElementToBeClickable(driver, loginButton, 10);
    driver.findElement(loginButton).click();
    waitutils.waitForElement(driver, invalidCredentialsMessage, 10);
}

public void ClickLoginWithoutEnteringCredentials() {
   // waitutils.waitForElementToBeClickable(driver, loginButton, 10);
    waitutils.waitForPageToLoad(driver, 10);
   driver.findElement(loginButton).click();
}

public void verifySuccessfulLogin() {
    waitutils.waitForElement(driver, loggedInVerification, 10);
    driver.findElement(loggedInVerification).isDisplayed();
}

public void verifyInvalidCredentialsMessage() {
    driver.findElement(invalidCredentialsMessage).isDisplayed();
}

public void verifyEmptyFieldsMessage() {
    waitutils.waitForElement(driver, userNameRequiredMessage, 10);
    driver.findElement(userNameRequiredMessage).isDisplayed();
    driver.findElement(passwordRequiredMessage).isDisplayed();
}


}
