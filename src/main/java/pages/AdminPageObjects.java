package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.waitutils;

import java.time.Duration;


public class AdminPageObjects{

    WebDriver driver;

    public AdminPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private WebElement AdminButton;

    By AdminButtonBy= By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");

    @FindBy (xpath = "//span[@class='oxd-topbar-header-breadcrumb']")
    private WebElement AdminPageHeader;

    By AdminPageHeaderBy= By.xpath("//span[@class='oxd-topbar-header-breadcrumb']");

    @FindBy (xpath="//div[@class='orangehrm-header-container']/button[@type='button']")
    private WebElement AddButton;

    @FindBy (xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[text()='Admin']")
    private WebElement AdminHeader;

  @FindBy(xpath="//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')] //div[contains(@class,'oxd-select-text-input')]")
  private WebElement UserRoleDropdown;

  By UserRoleDropdownBy= By.xpath("//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')] //div[contains(@class,'oxd-select-text-input')]");

  @FindBy(xpath="//div[@role='option' and normalize-space()='Admin']")
  private WebElement UserRoleAdminOption;

  @FindBy(xpath="//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]/div[normalize-space()='-- Select --']")
  private WebElement StatusDropdown;

  By StatusDropdownBy= By.xpath("//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]/div[normalize-space()='-- Select --']");

  @FindBy(xpath="//div[@role='option' and normalize-space()='Enabled']")
  private WebElement StatusEnabledOption;

  public void clickOnAdminModule() {
     waitutils.waitForElement(driver,AdminButtonBy,10);
        AdminButton.click();

  }

  public void verifyAdminPageHeader() {
        waitutils.waitForElement(driver,AdminPageHeaderBy,10);
      AdminPageHeader.isDisplayed();
  }

  public void AddButtonClick() {
      AddButton.click();
  }

  public void selectUserRoleAsAdmin() {
      waitutils.waitForElement(driver,UserRoleDropdownBy,10);
      UserRoleDropdown.click();
      UserRoleAdminOption.click();
  }

    public void selectStatusAsEnabled() {
        waitutils.waitForElement(driver,StatusDropdownBy,10);
        StatusDropdown.click();
        StatusEnabledOption.click();
    }







}
