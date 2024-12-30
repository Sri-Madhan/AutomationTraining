package com.tv.automationtraining.test;

import com.tv.automationtraining.common.AppiumDriverManager;
import com.tv.automationtraining.common.BaseClass;
import com.tv.automationtraining.screens.BottomNavbar;
import com.tv.automationtraining.screens.HomeScreen;
import com.tv.automationtraining.screens.LoginScreen;
import com.tv.automationtraining.utils.ExtentReportManager;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class MasterTestSuite {

    private AppiumDriverManager appiumDriverManager;
    static BaseClass baseClass;
    static AppiumDriver driver;
    static HomeScreen homeScreen;
    static BottomNavbar bottomNavbar;
    static LoginScreen loginScreen;

    @BeforeSuite(alwaysRun = true)
    @Parameters({ "platform" })
    public void setup(@Optional("android")String platform)  {
        appiumDriverManager = new AppiumDriverManager();
        try {
            ExtentReportManager.setup();
            driver = appiumDriverManager.setup(platform);
            baseClass = new BaseClass();
            bottomNavbar = new BottomNavbar(driver);
            homeScreen = new HomeScreen(driver);
            loginScreen = new LoginScreen(driver);
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
