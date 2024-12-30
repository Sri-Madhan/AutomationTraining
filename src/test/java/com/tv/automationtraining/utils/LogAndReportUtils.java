package com.tv.automationtraining.utils;

import com.tv.automationtraining.common.AppiumDriverManager;

public class LogAndReportUtils {

    static LoggerUtils loggerUtils = new LoggerUtils();

    public static void logAndReportInfo(String message) {
        ExtentReportManager.logStepInfo(message);
        loggerUtils.info(message);
    }

    // Log and report pass messages
    public static void logAndReportPass(String message) {
        loggerUtils.info(message);
        ExtentReportManager.logPass(message, AppiumDriverManager.getDriver());
    }

    // Log and report fail messages
    public static void logAndReportFail(String message, Exception e) {
        loggerUtils.error(message,e);
        ExtentReportManager.logFail(message, AppiumDriverManager.getDriver());
    }

    
}
