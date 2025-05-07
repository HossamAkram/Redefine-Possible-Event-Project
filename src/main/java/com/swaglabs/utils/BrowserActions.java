package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {

    }
    @Step("navigating to url: {url}")
    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
        LogsUtil.info("navigated to url: ",url);
    }
    @Step("Getting current url")
    public static String getCurrentUrl(WebDriver driver){
        LogsUtil.info("currnet url:",driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    @Step("Getting page title")
    public static String getPageTitle(WebDriver driver){
        LogsUtil.info("page title: ",driver.getTitle());
        return driver.getTitle();
    }
    @Step("refreshing page")
    public static void reload(WebDriver driver){
        LogsUtil.info("refreshing page");
        driver.navigate().refresh();
    }
    @Step("closing browser")
    public static void closeBrowser(WebDriver driver){
        LogsUtil.info("closing browser");
        driver.quit();
    }
}
