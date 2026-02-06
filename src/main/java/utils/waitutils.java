package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitutils {

    WebDriver driver;

    public static void waitForElement(WebDriver driver, By elementLocator, int timeoutInSeconds)
    {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By elementLocator, int timeoutInSeconds)
    {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public static void waitForElementToBePresent(WebDriver driver, By elementLocator, int timeoutInSeconds)
    {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    public static void waitForurlToContain(WebDriver driver, String urlFraction, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.urlContains(urlFraction));
    }

    public static void waitForLoaderToDisappear(WebDriver driver, By loaderLocator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

    public static void waitForPageToLoad(WebDriver driver, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(webDriver ->
                        ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState")
                                .equals("complete")
                );
    }

    public static void waitForUIToSettle() {
        try {
            Thread.sleep(500); // Yes — intentional for headless
        } catch (InterruptedException ignored) {}
    }



}
