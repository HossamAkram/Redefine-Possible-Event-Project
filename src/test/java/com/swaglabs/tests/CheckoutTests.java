package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.CheckoutOverviewPage;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.pages.FinishPage;
import com.swaglabs.utils.PropertiesUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class CheckoutTests extends TestBase{

    @Test(dependsOnMethods = {"com.swaglabs.tests.LoginTests.successfullLogin","com.swaglabs.tests.ProductsTests.addProductToCart","com.swaglabs.tests.ProductsTests.checkoutProduct"})
    public void checkoutData(){
        new CheckoutPage(DriverManager.getDriver())
                .enterFirstName(testData.getJsonData("checkout-credentials.firstName"))
                .enterLastName(testData.getJsonData("checkout-credentials.lastName"))
                .enterPostalCode(testData.getJsonData("checkout-credentials.postalCode"))
                .assertCheckoutPageData(testData.getJsonData("checkout-credentials.firstName"),
                        testData.getJsonData("checkout-credentials.lastName"),
                        testData.getJsonData("checkout-credentials.postalCode"))
                .clickContinueButton();

    }

    @Test(dependsOnMethods = "checkoutData")
    public void finishOrder(){
        new CheckoutOverviewPage(DriverManager.getDriver())
                .clickOnFinish();
    }

    @Test(dependsOnMethods = "finishOrder")
    public void confirmationMessage(){
        new FinishPage(DriverManager.getDriver())
                .assertFinishPage(PropertiesUtil.getPropertyValue("confirmationMessage"));
    }

    @Test( dependsOnMethods = "confirmationMessage")
    public void logout(){
        new FinishPage(DriverManager.getDriver())
                .clickSideMenu()
                .clickLogout()
                .assertLoginPageUrl();
    }
}
