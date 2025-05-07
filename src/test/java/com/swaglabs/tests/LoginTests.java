package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.*;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class LoginTests extends TestBase {

    //tests
    @Test(priority = 1)
    public void successfullLogin(){
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLogin()
                .assertSuccessfulLoginSoft();
    }

    @Test
    public void loginWithInvalidUsername() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterUsername("invalid_user")
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLogin()
                .assertInvalidCredentialsMessage();
    }

    @Test
    public void loginWithInvalidPassword() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword("wrong_password")
                .clickLogin()
                .assertInvalidCredentialsMessage();
    }

    @Test
    public void loginWithEmptyUsername() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterUsername("")
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLogin()
                .assertUsernameRequiredMessage();
    }

    @Test
    public void loginWithEmptyPassword() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword("")
                .clickLogin()
                .assertPasswordRequiredMessage();
    }

    @Test
    public void loginWithLockedOutUser() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterUsername("locked_out_user")
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLogin()
                .assertLockedOutUserMessage();
    }



}
