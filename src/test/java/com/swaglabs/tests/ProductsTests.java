package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.ProductsPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class ProductsTests extends TestBase {

    @Test(dependsOnMethods = "com.swaglabs.tests.LoginTests.successfullLogin")
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

}
