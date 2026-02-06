package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

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
                    chromeOptions.addArguments("--remote-allow-origins=*"); // Fixes connection issues
                    chromeOptions.addArguments("--headless=new");          // Run without UI (MUCH faster for Jenkins)
                 //   chromeOptions.addArguments("--blink-settings=imagesEnabled=false"); // Don't load images to save speed
                    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                    chromeOptions.addArguments("--disable-software-rasterizer");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--force-device-scale-factor=1");
                    chromeOptions.addArguments("--window-size=1920,1080"); // Force Desktop resolution
                  //  chromeOptions.addArguments("--start-maximized");// Prevents "Out of Memory" in Jenkins
                    chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36");
 //                   chromeOptions.addArguments("--start-maximized");
//                    chromeOptions.addArguments("--headless=new");
//                    chromeOptions.addArguments("--window-size=1920,1080");
//                    chromeOptions.addArguments("--disable-gpu");
//                    chromeOptions.addArguments("--no-sandbox");
//                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    driver.set(new ChromeDriver(chromeOptions));
                    driver.get().manage().window().setSize(new Dimension(1920, 1080));
                    driver.get().navigate().refresh();
                    ((ChromeDriver) driver.get()).executeCdpCommand(
                            "Emulation.setDeviceMetricsOverride",
                            Map.of("width", 1920, "height", 1080, "deviceScaleFactor", 1, "mobile", false)
                    );  break;

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
