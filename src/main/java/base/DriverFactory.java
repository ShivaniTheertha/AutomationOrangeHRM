package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        if (driver.get() == null) {

            if (browser == null) {
                browser = "chrome";
            }

            switch (browser.toLowerCase()) {

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
//                    chromeOptions.addArguments("--headless=new");
//                    chromeOptions.addArguments("--window-size=1920,1080");
//                    chromeOptions.addArguments("--disable-gpu");
//                    chromeOptions.addArguments("--no-sandbox");
//                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    driver.set(new FirefoxDriver(firefoxOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver.set(new EdgeDriver(edgeOptions));
                    break;

                default:
                    throw new RuntimeException("Invalid browser name: " + browser);
            }
        }

        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }


    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }

    }
}
