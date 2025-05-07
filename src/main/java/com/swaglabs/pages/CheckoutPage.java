package com.swaglabs.pages;

import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    //variables
    WebDriver driver;

    //constructor
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.cssSelector("input.btn_primary.cart_button");


    //actions
    @Step("entering first name")
    public CheckoutPage enterFirstName(String fistName){
        ElementActions.sendData(driver,this.firstName,fistName );
        return this;
    }
    @Step("entering last name")
    public CheckoutPage enterLastName(String lastName){
        ElementActions.sendData(driver,this.lastName,lastName );
        return this;
    }
    @Step("entering postal code")
    public CheckoutPage enterPostalCode(String postalCode){
        ElementActions.sendData(driver,this.postalCode,postalCode );
        return this;
    }
    @Step("clicking the continue button")
    public CheckoutPage clickContinueButton(){
    ElementActions.clickElement(driver,continueButton);
    return this;
    }

    //validations
    @Step("asserting the data entered")
    public CheckoutPage assertCheckoutPageData(String firstName,String lastName,String postalCode){
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getValue(driver,this.firstName),firstName);
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getValue(driver,this.lastName),lastName);
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getValue(driver,this.postalCode),postalCode);
        return this;
    }

}
