package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

public class AuthenticatedBaseTest extends BaseTest {


    @BeforeClass
    public void setup() throws InterruptedException {
        // Initialize WebDriver
        System.out.println("Browser in BaseTest: " + ConfigReader.get("browser"));
        driver= DriverFactory.initDriver(ConfigReader.get("browser"));
        driver.manage().window().maximize();

        // Navigate to application URL
        driver.get(ConfigReader.get("url"));
//    waitutils.pageLoadWait(driver, 20);

    }

    @AfterClass
    public void teardown() {

        DriverFactory.quitDriver();
    }
}
