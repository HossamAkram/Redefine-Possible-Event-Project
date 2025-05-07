package com.swaglabs.pages;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    //variables
    WebDriver driver;

    //constructor
    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By productName = By.cssSelector(".inventory_item_name");
    private By productPrice = By.cssSelector(".inventory_item_price");
    private By checkoutButton = By.cssSelector("a.btn_action.checkout_button");


    //navigate to page
    public static void navigateToCartPage(){
        BrowserActions.navigateToUrl(DriverManager.getDriver(),PropertiesUtil.getPropertyValue("cartPage"));
    }

    //actions
    @Step("getting product name")
    private String getProductName(){
        return ElementActions.getText(driver,productName);
    }
    @Step("getting product price")
    private String getProductPrice(){
        return ElementActions.getText(driver,productPrice);
    }

    @Step("clicking on checkout button")
    public CheckoutPage clickCheckout(){
        ElementActions.clickElement(driver,checkoutButton);
        return new CheckoutPage(driver);
    }



    //validations
    @Step("asserting the product's name and price")
    public CartPage assertProductDetails(String productName,String productPrice){
        String actualProductName = getProductName();
        String actualproductPrice  = getProductPrice();
        CustomSoftAssertion.softAssertion.assertEquals(actualProductName,productName,"product name is a mismatch");
        CustomSoftAssertion.softAssertion.assertEquals(actualproductPrice,productPrice,"product price is a mismatch");
        return this;
    }

}
