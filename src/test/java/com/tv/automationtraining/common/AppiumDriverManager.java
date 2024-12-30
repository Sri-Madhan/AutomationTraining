package com.tv.automationtraining.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import java.io.File;
import java.net.URL;

import com.tv.automationtraining.utils.LogAndReportUtils;

public class AppiumDriverManager {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();


    public AppiumDriver setup(String platformName) throws Exception {

        File app = null;

        // Define the app path based on platform
        if (platformName.equalsIgnoreCase("android")) {
            app = new File("src/test/java/com/tv/automationtraining/resources/app/android.apk");
        } else if (platformName.equalsIgnoreCase("ios")) {
            app = new File("src/test/java/com/tv/automationtraining/resources/apps/ios.app");
        }

        if(platformName.equalsIgnoreCase("android")){
            var options = new BaseOptions()
                    .amend("appium:udid", "emulator-5554")
                    .amend("platformName", "Android")
                    .amend("appium:automationName", "UiAutomator2")
                    .amend("appium:ensureWebviewsHavePages", true)
                    .amend("appium:nativeWebScreenshot", true)
                    .amend("appium:newCommandTimeout", 3600)
                    .amend("appium:connectHardwareKeyboard", true)
                    .amend("appium:app", app.getAbsolutePath());
                    driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723"),options));
        }else{
            var options = new BaseOptions()
                    .amend("appium:udid", "emulator-5554")
                    .amend("platformName", "Android")
                    .amend("appium:automationName", "XCUITest")
                    .amend("appium:ensureWebviewsHavePages", true)
                    .amend("appium:nativeWebScreenshot", true)
                    .amend("appium:newCommandTimeout", 3600)
                    .amend("appium:connectHardwareKeyboard", true)
                    .amend("appium:app", app.getAbsolutePath());
            driver.set(new IOSDriver(new URL("http://127.0.0.1:4723"), options));
        }
        LogAndReportUtils.logAndReportInfo("Driver initiated with "+platformName);
        return driver.get();
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }
   
    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            LogAndReportUtils.logAndReportInfo("Driver closed");
        }
    }
}
