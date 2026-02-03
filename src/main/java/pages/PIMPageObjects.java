package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.waitutils;

import java.util.List;
import java.util.NoSuchElementException;

public class PIMPageObjects {

    WebDriver driver;
    By navigateToPIM= By.xpath("//span[text()='PIM']");
    By addEmployeeButton= By.xpath("//button[text()=' Add ']");
    By employeeFirstNameField = By.xpath("//input[@name='firstName']");
    By employeeLastNameField= By.xpath("//input[@name='lastName']");
    By saveButton= By.xpath("//button[@type='submit']");
    By searchEmployeeNameField= By.xpath("//input[@placeholder='Type for hints...']");
    By searchEmployeebutton= By.xpath("//div[@class='oxd-form-actions']/button[@type='submit']");
    By successMessage= By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    By EmployeeListTab= By.xpath("//a[text()='Employee List']");
    By EmployeeNameInList= By.cssSelector("div.oxd-autocomplete-text-input--after");
    By searchResultFound=By.xpath("//span[contains(normalize-space(.), 'Record Found')]");
    By lastNameinSearchedResult= By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[4]");
    By firstAndMiddleNameinSearchedResult= By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[3]");
    By rows = By.xpath("//div[contains(@class,'oxd-table-row--clickable')]");
    By MiddleNameFieldInPersonalDetails= By.xpath("//input[@name='middleName']");
    By saveButtonInPersonalDetails= By.xpath("(//div[@class='oxd-form-actions']/button)[1]");
    By loader = By.xpath("//div[contains(@class,'oxd-form-loader')]");

    public PIMPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPIMModule() {
        waitutils.waitForElement(driver, navigateToPIM, 10);
        driver.findElement(navigateToPIM).click();
    }

    public void clickAddEmployeeButton() {
        waitutils.waitForElement(driver, addEmployeeButton, 10);
        driver.findElement(addEmployeeButton).click();
    }

    public void enterEmployeeFirstName(String firstName) {
        waitutils.waitForElement(driver, employeeFirstNameField, 10);
        driver.findElement(employeeFirstNameField).sendKeys(firstName);
    }

    public void enterEmployeeLastName(String lastName) {
        driver.findElement(employeeLastNameField).sendKeys(lastName);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public String getSuccessMessageText()
    {
        waitutils.waitForElement(driver, successMessage, 10);
        return driver.findElement(successMessage).getText();
    }

    public void setSearchEmployeeNameField(String name)
    {
        waitutils.waitForElement(driver, searchEmployeeNameField, 10);
        driver.findElement(searchEmployeeNameField).sendKeys(name);
    }


    public void clickSearchEmployeeButton()
    {
        driver.findElement(searchEmployeebutton).click();
    }

    public void clickEmployeeListTab()
    {
        waitutils.waitForElement(driver, EmployeeListTab, 10);
        driver.findElement(EmployeeListTab).click();
    }

    public void searchthroughEmployeeNameInList(String name)
    {
        waitutils.waitForElement(driver, EmployeeNameInList, 10);
      List<WebElement> EmployeeList=  driver.findElements(EmployeeNameInList);
        for(WebElement emp: EmployeeList)
        {
            if(emp.getText().equals(name))
            {
                System.out.println("Employee found: "+name);
                emp.click();
                break;
            }
        }
    }

    public void selectSearchedEmployee(String name)
    {
        waitutils.waitForElement(driver,searchResultFound , 10);
        List<WebElement> lastNames= driver.findElements(lastNameinSearchedResult);
        lastNames.stream().filter(lastName->lastName.getText().trim().equals(name)).findFirst().ifPresent(WebElement::click);
    }

    public void enterMiddleNameInPersonalDetails(String middleName)
    {
        waitutils.waitForElement(driver, MiddleNameFieldInPersonalDetails, 10);
      //  driver.findElement(MiddleNameFieldInPersonalDetails).clear();
        driver.findElement(MiddleNameFieldInPersonalDetails).sendKeys(middleName);
        waitutils.waitForLoaderToDisappear(driver, loader, 10);
        driver.findElement(saveButtonInPersonalDetails).click();
    }

    public String getModifiedMiddleName(String name,String lastname)
    {
        clickEmployeeListTab();
        setSearchEmployeeNameField(name);
        clickSearchEmployeeButton();
        waitutils.waitForElement(driver,searchResultFound , 10);
        List<WebElement> rowsFromSearchedResult= driver.findElements(rows);

        return rowsFromSearchedResult.stream()
                .filter(row -> row.findElement(By.xpath("./div[4]"))
                        .getText()
                        .trim()
                        .equals(lastname))
                .map(row -> row.findElement(By.xpath("./div[3]"))
                        .getText()
                        .trim())
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("No record found for last name: " + name));
    }



}
