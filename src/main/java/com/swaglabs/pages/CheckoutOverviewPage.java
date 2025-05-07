package com.swaglabs.pages;


import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    //variables
    WebDriver driver;

    //constructor
    public CheckoutOverviewPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By itemTotal =By.cssSelector("div.summary_subtotal_label");
    private By tax =By.cssSelector("div.summary_tax_label");
    private By total =By.cssSelector("div.summary_total_label");
    private By finishButton =By.cssSelector("a.btn_action.cart_button");


    //actions
    @Step("click on finish button")
    public CheckoutOverviewPage clickOnFinish(){
        ElementActions.clickElement(driver,finishButton);
        return this;
    }

    //validations
    /*@Step("validate the total calculation")
    public CheckoutOverviewPage assertTotal(String itemtotal){
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getText(driver,this.itemTotal),itemtotal,"total is a mismatch");
        return this;
    }*/

}
