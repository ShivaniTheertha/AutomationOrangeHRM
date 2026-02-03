package utils;

import base.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Base64;

public class ExtentCucumberListener implements ConcurrentEventListener {

    private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        String scenarioName = event.getTestCase().getName();
        scenarioTest.set(extent.createTest(scenarioName));
    }

    private void onTestStepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            String stepName = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
            switch (event.getResult().getStatus()) {
                case PASSED:
                    scenarioTest.get().pass(stepName);
                    break;
                case FAILED:
                    scenarioTest.get().fail(stepName + " - " + event.getResult().getError());
                    try {
                        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
                        scenarioTest.get().addScreenCaptureFromBase64String(Base64.getEncoder().encodeToString(screenshot), stepName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case SKIPPED:
                    scenarioTest.get().skip(stepName);
                    break;
            }
        }
    }

    private void onTestCaseFinished(TestCaseFinished event) {
        extent.flush();
    }
}
