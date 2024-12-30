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
	final long waitTime=30;

	public BaseClass(){
		driver = AppiumDriverManager.getDriver();
	}

	public void clickElement(WebElement element) {
		try {
			waitForElementClickable(element);
			LogAndReportUtils.logAndReportInfo(element + " is clicked ");
			element.click();
		} catch (Exception e) {
			LogAndReportUtils.logAndReportFail(element + " is not clicked ",e);
		}
	}

	public String getElementText(WebElement element){
		try {
			waitForElementVisible(element);
			LogAndReportUtils.logAndReportInfo(element + " text is "+ element.getText());
			element.click();
			return element.getText();
		} catch (Exception e) {
			LogAndReportUtils.logAndReportFail("Not able to get text of the "+element, e);
			return null;
		}
	}

	public void clearAndSendKeys(WebElement element, String text) {
		try {
            waitForElementVisible(element);
            LogAndReportUtils.logAndReportInfo("Clearing and sending keys to " + element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            LogAndReportUtils.logAndReportFail("Not able to clear and send keys to " + element, e);
        }
	}
    

	public <T> void assertEquals(T actual, T expected) {
		try {
			Assert.assertEquals(actual, expected);
			LogAndReportUtils.logAndReportPass(actual + " equals " + expected);
		} catch (Exception e) {
			LogAndReportUtils.logAndReportFail(actual + " not equals " + expected,e);
		}
	}

    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        ExtentReportManager.logStepInfo("waitForElementVisible");
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			LogAndReportUtils.logAndReportInfo("waitForElementVisible " + element);
		} catch (Exception e) {
			LogAndReportUtils.logAndReportFail("waitForElementVisible " + element,e);
		} 
		
    }

    public void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			LogAndReportUtils.logAndReportInfo("waitForElementClickable " + element);	
		} catch (Exception e) {
			LogAndReportUtils.logAndReportFail("waitForElementClickable " + element, e);
		}
		
    }
    
}
