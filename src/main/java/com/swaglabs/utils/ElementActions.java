package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions(){

    }
    @Step("sending data: {data} to the element {locator}")
    public static void sendData(WebDriver driver, By locator, String data){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        findElement(driver, locator).sendKeys(data);
        LogsUtil.info("data entered",data," in the field",locator.toString());
    }
    @Step("clicking the {locator} element")
    public static void clickElement(WebDriver driver, By locator){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        findElement(driver,locator).click();
        LogsUtil.info("clicked on element",locator.toString());
    }
    @Step("clicking the {locator} element")
    public static void jsClick(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step("Getting text from {locator} element")
    public static String getText(WebDriver driver, By locator){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        LogsUtil.info("getting text from ", locator.toString()," text:", findElement(driver,locator).getText());
        return findElement(driver,locator).getText();
    }

    public static String getValue(WebDriver driver,By locator){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        LogsUtil.info("getting value from ", locator.toString()," text:", findElement(driver,locator).getDomAttribute("value"));
        return findElement(driver,locator).getDomAttribute("value");

    }

    public static WebElement findElement(WebDriver driver, By locator){
        LogsUtil.info("finding element", locator.toString());
        return driver.findElement(locator);
    }
}
