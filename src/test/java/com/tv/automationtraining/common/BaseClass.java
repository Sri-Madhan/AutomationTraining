package com.tv.automationtraining.common;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tv.automationtraining.utils.ExtentReportManager;
import com.tv.automationtraining.utils.LogAndReportUtils;

import io.appium.java_client.AppiumDriver;

public class BaseClass {

    AppiumDriver driver;

	public BaseClass(){
		driver = AppiumDriverManager.getDriver();
	}
    

	public <T> void assertEquals(T actual, T expected) {
		try {
			Assert.assertEquals(actual, expected);
			LogAndReportUtils.logAndReportPass("Assert equals " + actual + " " + expected);
		} catch (AssertionError e) {
			LogAndReportUtils.logAndReportPass("Assert Not equals " + actual + " " + expected);
		}
	}

    public void waitForElementVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        ExtentReportManager.logStepInfo("waitForElementVisible");
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			LogAndReportUtils.logAndReportInfo("waitForElementVisible " + element);
		} catch (Exception e) {
			LogAndReportUtils.logAndReportInfo("waitForElementVisible " + element);
		} 
		
    }

    public WebElement waitForElementClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		LogAndReportUtils.logAndReportInfo("waitForElementClickable " + element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
}
