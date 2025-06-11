package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ExtentManager;

import java.io.IOException;

public class BaseTest {

    public static ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        extent = ExtentManager.createInstance();
    }


    @AfterSuite(alwaysRun = true)
    public void endSuite() throws IOException {
        extent.flush();
    }
}
