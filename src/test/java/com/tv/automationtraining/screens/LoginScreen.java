package com.tv.automationtraining.screens;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tv.automationtraining.common.BaseClass;
import com.tv.automationtraining.common.UiConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends BaseClass{

    AppiumDriver driver;

    public LoginScreen(AppiumDriver driver ){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver,Duration.ofSeconds(20)), this);
    }

    // Find elements
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='"+ UiConstants.LoginScreenConstants.PAGE_DISCRIPTION +"']")
    WebElement loginPageTile;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
    WebElement emailInput;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
    WebElement passwordInput;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]\n")
    WebElement loginButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
    WebElement popupMessElement;
    @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    WebElement popupOkButton;

    // Actions
    public String getPageTile() {
        return getElementText(loginPageTile);
    }

    public void enterEmail(String email) {
        clearAndSendKeys(emailInput, email);
    }

    public void enterPassword(String password) {
        clearAndSendKeys(passwordInput, password);
    }

    public void clickLogin(){
        clickElement(loginButton);
    }

    public String getPopupMessage() {
        return getElementText(popupMessElement);
    }

    public void closePopup() {
        clickElement(popupOkButton);
    }


    //Flow methods
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

}
