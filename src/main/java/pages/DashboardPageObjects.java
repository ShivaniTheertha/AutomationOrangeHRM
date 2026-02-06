package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.waitutils;

public class DashboardPageObjects {

    WebDriver driver;

    public DashboardPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By DashboardHeader = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6[normalize-space()='Dashboard']");
    By logOutButton = By.xpath("//ul[@class='oxd-dropdown-menu']/li[normalize-space()='Logout']");
    By myAccountButton = By.xpath("//p[@class='oxd-userdropdown-name']");



    By spinner= By.className("oxd-loading-spinner");
    By topbarHeader= By.className("oxd-topbar-header");

    public void ClickMyAccountButton () {
        waitutils.waitForElement(driver, DashboardHeader, 10);
        driver.findElement(myAccountButton).click();
    }

    public void ClickLogOutButton ()
    {
        waitutils.waitForElement(driver, logOutButton, 10);
        driver.findElement(logOutButton).click();
    }






}
