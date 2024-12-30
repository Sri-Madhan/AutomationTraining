package com.tv.automationtraining.test;

import org.testng.annotations.Test;
import com.tv.automationtraining.common.AppiumDriverManager;
import com.tv.automationtraining.common.UiConstants;
import com.tv.automationtraining.screens.HomeScreen;
import com.tv.automationtraining.utils.ExtentReportManager;

import io.appium.java_client.AppiumDriver;

public class HomeScreenTest extends MasterTestSuite{

    AppiumDriver driver;
    HomeScreen homeScreen;

    @Test(groups = "regression")
    public void verifyHomeScreenDescription(){
        ExtentReportManager.startTest("homeScreenDescription");
        driver = AppiumDriverManager.getDriver();
        homeScreen = new HomeScreen(driver);
        baseClass.assertEquals(homeScreen.getHomeDescription(), UiConstants.HomeScreenConstants.PAGE_DISCRIPTION);
    }

    @Test(groups = {"smoke","regression"})
    public void verifyHomeScreenNavigation(){
        ExtentReportManager.startTest("homeScreenNavigation");
        driver = AppiumDriverManager.getDriver();
        homeScreen = new HomeScreen(driver);
        homeScreen.clickHomeButton();
    
    }

    
}
