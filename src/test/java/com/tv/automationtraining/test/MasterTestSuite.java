package com.tv.automationtraining.test;

import com.tv.automationtraining.common.AppiumDriverManager;
import com.tv.automationtraining.common.BaseClass;
import com.tv.automationtraining.utils.ExtentReportManager;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class MasterTestSuite {

    private AppiumDriverManager appiumDriverManager;
    BaseClass baseClass;

    @BeforeSuite(alwaysRun = true)
    @Parameters({ "platform" })
    public void setup(@Optional("android")String platform)  {
        appiumDriverManager = new AppiumDriverManager();
        try {
            ExtentReportManager.setup();
            appiumDriverManager.setup(platform);
            baseClass = new BaseClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        appiumDriverManager.quitDriver();
        ExtentReportManager.flush();
    }

}
