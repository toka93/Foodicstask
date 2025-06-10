package utils;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static final String EXTENT_REPORT = "ExtentReport";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH-mm");

    private static final String REPORT_NAME = EXTENT_REPORT + LocalTime.now().format(TIME_FORMATTER) + ".html";
    private static final String HTML_REPORT_PATH = new StringBuilder()
            .append(System.getProperty("user.dir"))
            .append(File.separator)
            .append(EXTENT_REPORT)
            .append(File.separator)
            .append(LocalDate.now().format(DATE_FORMATTER))
            .append(File.separator)
            .append(REPORT_NAME)
            .toString();

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static ExtentReports createInstance() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(HTML_REPORT_PATH);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Functional Test Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Created By", "toka");
        extent.setSystemInfo("Environment", "test");
        return extent;
    }


    public static void logStep(ExtentTest test, String message, boolean isPassed) {
        if (isPassed) {
            test.pass(message);
        } else {
            test.fail(message);
        }
    }

    public static void logInfo(ExtentTest test, String message) {
        test.info(message);
    }
}