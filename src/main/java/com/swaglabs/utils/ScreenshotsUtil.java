package com.swaglabs.utils;

import com.swaglabs.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotsUtil {
    public static final String SCREENSHOT_PATH="test-outputs/screenshots/";
    private ScreenshotsUtil(){
        super();
    }

    public static void takeScreenshot(String screenshotName){
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOT_PATH + screenshotName + ".png");
            FileUtils.copyFile(screenshot,screenshotFile);
            AllureUtil.attachScreenshot(screenshotName,screenshotFile.getPath());
        } catch (Exception e) {
            LogsUtil.error("failed to take a screenshot"+ e.getMessage());
        }
    }
}
