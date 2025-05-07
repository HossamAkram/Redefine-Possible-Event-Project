package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.*;
import com.swaglabs.utils.PropertiesUtil;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class E2eTest extends TestBase {

    //tests
    @Test
    public void successfullLogin(){
        new LoginPage(DriverManager.getDriver())
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLogin()
                .assertSuccessfulLoginSoft();
    }

    @Test(dependsOnMethods = "successfullLogin")
    public void addProductToCart(){
        new ProductsPage(DriverManager.getDriver()).
                addSpecificProductToCart(testData.getJsonData("product-names.item1.name"))
                .assertAddingSpecificProductToCart(testData.getJsonData("product-names.item1.name"));
    }

    @Test(dependsOnMethods = "addProductToCart")
    public void checkoutProduct(){
        new ProductsPage(DriverManager.getDriver()).clickOnCart()
                .assertProductDetails(testData.getJsonData("product-names.item1.name"),testData.getJsonData("product-names.item1.price"))
                .clickCheckout();

    }

    @Test(dependsOnMethods = "checkoutProduct")
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



}

