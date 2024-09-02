package com.automation.steps;

import com.automation.pages.GiftCardPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GiftCardSteps {

    GiftCardPage giftCardPage = new GiftCardPage();

    @When("user clicks on Gift Card link")
    public void user_clicks_on_gift_card_link() {
        giftCardPage.clickOnGiftCardLink();
    }

    @Then("verify user is on gift card page")
    public void verify_user_is_on_gift_card_page() {
        Assert.assertEquals(giftCardPage.isOnGIftCardPage(), "Gift Card/EGV");
    }

    @When("user clicks on the first gift card")
    public void user_clicks_on_the_first_gift_card() {
        giftCardPage.clickOnFirstGiftCard();
    }

    @When("user clicks on ADD TO BAG")
    public void user_clicks_on_add_to_bag() {
        giftCardPage.addToBag();
    }

    @When("user fills all the details and clicks on PROCEED")
    public void user_fills_all_the_details_and_clicks_on_proceed() {
       giftCardPage.fillDetails();
       giftCardPage.clickOnViewBag();
    }

    @Then("verify the product is successfully added to the bag")
    public void verify_the_product_is_successfully_added_to_the_bag() {
        Assert.assertTrue(giftCardPage.isProductAddedToBag());
    }

    @When("user clicks on the remove")
    public void userClicksOnTheRemove() {
        giftCardPage.removeFromBag();
    }

    @Then("verify remove message {string} displayed")
    public void verifyRemoveMessageDisplayed(String message) {
        Assert.assertEquals(giftCardPage.isRemoveSuccessful(), ConfigReader.getConfigValue(message));
    }
}
