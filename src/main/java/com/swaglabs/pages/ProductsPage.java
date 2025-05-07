package com.swaglabs.pages;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ProductsPage {
    //variables
    private WebDriver driver;

    //constructor
    public ProductsPage(WebDriver driver){
        this.driver =driver;
    }

    //locators
    private By cartButton = By.cssSelector("svg.svg-inline--fa.fa-shopping-cart.fa-w-18.fa-3x");

    //actions
    //navigate to products page
    public ProductsPage navigateToProductsPage(){
        BrowserActions.navigateToUrl(driver, PropertiesUtil.getPropertyValue("loginPage"));
        return this;
    }
    @Step("adding {productName} to the cart")
    public ProductsPage addSpecificProductToCart(String productName){
        LogsUtil.info("adding "+productName+" to the cart");
        By addToCart = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + productName + "']"));
        ElementActions.clickElement(DriverManager.getDriver(),addToCart);
        return this;
    }
    @Step("click on the cart icon to navigate to the cart page")
    public CartPage clickOnCart(){
        ElementActions.clickElement(driver,cartButton);
        return new CartPage(driver);
    }


    //validations
    @Step("validating the product added: {productName} in the cart page")
    public ProductsPage assertAddingSpecificProductToCart(String productName){
        LogsUtil.info("assert adding "+productName+" to the cart");
        By addToCart = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + productName + "']"));
        Validations.validateEquals(ElementActions.getText(DriverManager.getDriver(),addToCart),"REMOVE","item wasn't added to the cart");
        LogsUtil.info(productName+" was added to the cart successfully!");
        return this;
    }

}
