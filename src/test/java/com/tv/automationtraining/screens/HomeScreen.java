package com.tv.automationtraining.screens;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tv.automationtraining.common.BaseClass;
import com.tv.automationtraining.common.UiConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends BaseClass{

    AppiumDriver driver;

    public HomeScreen(AppiumDriver driver ){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver,Duration.ofSeconds(20)), this);
    }

    // Find elements
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='"+ UiConstants.HomeScreenConstants.PAGE_DISCRIPTION +"']")
    WebElement descripElement;

    // Actions
    public String getHomeDescription() {
        return getElementText(descripElement);
    }
    
}
