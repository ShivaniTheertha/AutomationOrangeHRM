package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        // Initialize ExtentReports instance
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report.html");
            reporter.config().setReportName("OrangeHRM Test Report");
            reporter.config().setDocumentTitle("OrangeHRM Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Project", "OrangeHRM");
            extent.setSystemInfo("Tester", "Shivani");
            extent.setSystemInfo("environment", "QA");
        }
        return extent;
    }
}
