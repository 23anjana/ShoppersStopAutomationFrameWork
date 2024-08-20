package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {
    CartPage cartPage = new CartPage();

    @When("user clicks on bag icon")
    public void userClicksOnBagIcon() {
        cartPage.clickBagIcon();
    }

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        cartPage.isCartPageDisplayed();
    }

    @Then("verify item prices display correctly on cart page")
    public void verifyItemPricesDisplayCorrectlyOnCartPage() {
        Assert.assertTrue(cartPage.isFinalPriceIsMatchingWithItemTotalPrice());
    }
}
