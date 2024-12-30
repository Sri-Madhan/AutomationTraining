package com.tv.automationtraining.test;

import org.testng.annotations.Test;
import com.tv.automationtraining.common.UiConstants;
import com.tv.automationtraining.utils.ExtentReportManager;

public class HomeScreenTest extends MasterTestSuite{

    @Test(groups = "regression")
    public void verifyHomeScreenDescription(){
        ExtentReportManager.startTest("homeScreenDescription");
        baseClass.assertEquals(homeScreen.getHomeDescription(), UiConstants.HomeScreenConstants.PAGE_DISCRIPTION);
    }

    @Test(groups = {"smoke","regression"})
    public void verifyHomeScreenNavigation(){
        ExtentReportManager.startTest("homeScreenNavigation");
        bottomNavbar.clickHomeButton();
        baseClass.assertEquals(homeScreen.getHomeDescription(), UiConstants.HomeScreenConstants.PAGE_DISCRIPTION);
    }

    
}
