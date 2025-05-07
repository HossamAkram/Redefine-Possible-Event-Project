package com.swaglabs.pages;

import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage {

    //variables
    WebDriver driver;

    //constructor
    public FinishPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By thankyouMessage =By.cssSelector("h2.complete-header");
    private By logoutLink = By.id("logout_sidebar_link");
    private By sideMenuButton = By.xpath("//button[text()='Open Menu']");



    //actions
    @Step("get confirmation message")
    public String getConfirmationMessage(){
        return ElementActions.getText(driver,thankyouMessage);
    }

    @Step("Click on Side Menu Button")
    public FinishPage clickSideMenu() {
        ElementActions.jsClick(driver, sideMenuButton);
        return this;
    }

    @Step("Click on Logout")
    public FinishPage clickLogout() {
        ElementActions.clickElement(driver, logoutLink);
        return this;
    }

    //validations
    @Step("validate confiramtion message")
    public void assertFinishPage(String expectedMessage){
        String actualMessage = getConfirmationMessage();
        Validations.validateEquals(actualMessage,expectedMessage,"finish message is a mismatch");
    }

    @Step("assert login page url")
    public FinishPage assertLoginPageUrl(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentUrl(driver), PropertiesUtil.getPropertyValue("baseUrl"),"url not as expected");
        return this;
    }
}
