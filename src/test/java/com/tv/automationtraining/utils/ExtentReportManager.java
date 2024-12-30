package com.tv.automationtraining.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ThreadLocal<ExtentReports> extentThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<ExtentSparkReporter> htmlReporterThreadLocal = new ThreadLocal<>();
    private static String reportPath = "test-output/extent-reports/";
    private static String timestamp;
    
    // Initialize ExtentReports
    public static void setup() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        timestamp = sdf.format(new Date());
        String fileName = reportPath + timestamp + "/" + "ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Optionally, you can add system information (e.g., browser, OS)
        extent.setSystemInfo("OS", "Mac OS");
        extent.setSystemInfo("Tester", "Sri Madhan");

        extentThreadLocal.set(extent);
        htmlReporterThreadLocal.set(htmlReporter);
    } 

    // Create a test case entry in the report
    public static void startTest(String testName) {
        ExtentReports extent = extentThreadLocal.get();
        if (extent != null) {
            ExtentTest test = extent.createTest(testName);
            testThreadLocal.set(test);
        }
    }

    // Capture screenshot and add to report
    public static String captureScreenshot(AppiumDriver driver, String status) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String scrrenshotTimestamp= System.currentTimeMillis()+"";
            String destFile = 
                    "./test-output/extent-reports/"+ timestamp +"/screenshots/" + status + "_" + scrrenshotTimestamp + ".png";
            FileUtils.copyFile(srcFile, new File(destFile));

            return "./screenshots/"+status + "_" + scrrenshotTimestamp + ".png";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    // Log test step information (non-pass/fail)
    public static void logStepInfo(String stepDescription) {
        ExtentTest test = testThreadLocal.get();
        if (test != null) {
            test.info(stepDescription); 
        }
    }

    // Log test status as PASS
    public static void logPass(String message, AppiumDriver driver) {
        ExtentTest test = testThreadLocal.get();
        if (test != null) {
           
            test.pass(message,
                    MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(driver, "pass")).build());

        }
    }

    // Log test status as FAIL
    public static void logFail(String message, AppiumDriver driver) {
        ExtentTest test = testThreadLocal.get();
        if (test != null) {
            test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(driver, "fail")).build());
        }
    }

    // This method will be called at the end of the test suite to write the results to the report
    public static void flush() {
        ExtentReports extent = extentThreadLocal.get();
        if (extent != null) {
            extent.flush(); 
        }
    }
}
