package com.tv.automationtraining.screens;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tv.automationtraining.common.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BottomNavbar extends BaseClass{
    AppiumDriver driver;

    public BottomNavbar(AppiumDriver driver ){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver,Duration.ofSeconds(20)), this);
    }

    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Home\"]")
    WebElement navHomeBtn;
    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Login\"]")
    WebElement navLoginBtn;

    public void clickHomeButton() {
        clickElement(navHomeBtn);
    }

    public void clickLoginButton() {
        clickElement(navLoginBtn);
    }

}
