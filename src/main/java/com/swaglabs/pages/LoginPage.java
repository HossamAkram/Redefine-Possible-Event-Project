package com.swaglabs.pages;

import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //variables
    private final WebDriver driver;

    //locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //navigate to login page
    @Step("navigating to login page")
    public LoginPage navigateToLoginPage(){
        BrowserActions.navigateToUrl(driver,PropertiesUtil.getPropertyValue("baseUrl"));
        return this;
    }

    //actions
    // wait scroll find send keys
    @Step("Enter username {0}")
    public LoginPage enterUsername(String username){
        ElementActions.sendData(driver,this.username,username);
        return this; //in fluent pattern each method returns the current object, allowing multiple methods to be called in a single statement._
    }
    @Step("Enter password {0}")
    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
        return this; //new LoginPage(driver)
    }
    @Step("Click on login button")
    public LoginPage clickLogin(){
        ElementActions.clickElement(driver,this.loginButton);
        return this;
    }
    @Step("Get error message")
    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }

    //validations (testng assertions)
    @Step("assert login page url")
    public LoginPage assertLoginPageUrl(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentUrl(driver),PropertiesUtil.getPropertyValue("loginPage"),"url not as expected");
        return this;
    }

    @Step("assert login page title")
    public LoginPage assertLoginPageTitle(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver),PropertiesUtil.getPropertyValue("pageTitle"),"title not as expected");
        return this;
    }

    @Step("assert successful login")
    public LoginPage assertSuccessfulLoginSoft(){
        assertLoginPageUrl().assertLoginPageTitle();
        return this;
    }
    @Step("Assert error message: Username is required")
    public LoginPage assertUsernameRequiredMessage() {
        Validations.validateEquals(
                getErrorMessage(),
                PropertiesUtil.getPropertyValue("errorMsgUsername"),
                "Username required error message mismatch"
        );
        return this;
    }

    @Step("Assert error message: Password is required")
    public LoginPage assertPasswordRequiredMessage() {
        Validations.validateEquals(
                getErrorMessage(),
                PropertiesUtil.getPropertyValue("errorMsgPassword"),
                "Password required error message mismatch"
        );
        return this;
    }

    @Step("Assert error message: Invalid credentials")
    public LoginPage assertInvalidCredentialsMessage() {
        Validations.validateEquals(
                getErrorMessage(),
                PropertiesUtil.getPropertyValue("errorMsgMismatch"),
                "Invalid credentials error message mismatch"
        );
        return this;
    }

    @Step("Assert error message: Locked out user")
    public LoginPage assertLockedOutUserMessage() {
        Validations.validateEquals(
                getErrorMessage(),
                PropertiesUtil.getPropertyValue("errorMsgLockedUser"),
                "Locked-out user error message mismatch"
        );
        return this;
    }






}
