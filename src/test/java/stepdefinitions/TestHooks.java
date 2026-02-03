package stepdefinitions;

import base.BaseTest;
import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class TestHooks extends BaseTest{


    @Before
    public void setup() {
        // Initialize WebDriver
        System.out.println("Browser in BaseTest: " + ConfigReader.get("browser"));
        driver= DriverFactory.initDriver(ConfigReader.get("browser"));
        driver.manage().window().maximize();
        // Navigate to application URL
        driver.get(ConfigReader.get("url"));
    }

    @After
    public void teardown() {
        DriverFactory.quitDriver();
    }

}
