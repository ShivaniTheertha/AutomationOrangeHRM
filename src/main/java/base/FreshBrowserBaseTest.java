package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class FreshBrowserBaseTest extends BaseTest {

    @BeforeMethod
    public void setup() throws InterruptedException {
        // Initialize WebDriver
        System.out.println("Browser in BaseTest: " + ConfigReader.get("browser"));
        driver= DriverFactory.initDriver(ConfigReader.get("browser"));
        driver.manage().window().maximize();

        // Navigate to application URL
        driver.get(ConfigReader.get("url"));
//    waitutils.pageLoadWait(driver, 20);

    }

    @AfterMethod
    public void teardown() {

        DriverFactory.quitDriver();
    }
}
