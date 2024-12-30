package com.tv.automationtraining.test;

import org.testng.annotations.Test;

import com.tv.automationtraining.common.UiConstants;
import com.tv.automationtraining.data_provider.ExcelDataProvider;
import com.tv.automationtraining.utils.ExtentReportManager;

public class LoginScreenTest extends MasterTestSuite{

    

    @Test(groups = {"regression","smoke"})
    public void verifyLoginPage(){
        ExtentReportManager.startTest("verifyLoginPage");
        bottomNavbar.clickLoginButton();
        baseClass.assertEquals(loginScreen.getPageTile(), UiConstants.LoginScreenConstants.PAGE_DISCRIPTION);
    }

    @Test(groups = {"regression","smoke"}, dataProvider = "excelData",dataProviderClass = ExcelDataProvider.class)
    public void verifyLoginWithCredentials(String email,String password){
        ExtentReportManager.startTest("verifyLoginWithCredentials");
        bottomNavbar.clickLoginButton();
        loginScreen.login(email, password);
        baseClass.assertEquals(loginScreen.getPopupMessage(), UiConstants.LoginScreenConstants.POPUP_MESSAGE);
        // loginScreen.closePopup();
    }

}
