package com.automation.steps;

import com.automation.pages.GiftCardPage;
import com.automation.pages.MembershipPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MembershipSteps {

    MembershipPage membershipPage = new MembershipPage();
    GiftCardPage giftCardPage = new GiftCardPage();

    @When("user clicks on the First Citizen Club link")
    public void user_clicks_on_the_first_citizen_club_link() {
        membershipPage.clickOnMembershipLink();
    }

    @Then("verify user is on membership page")
    public void verify_user_is_on_membership_page() {
        Assert.assertEquals(membershipPage.isMembershipPage(), "Membership Details & Benefits");
    }

    @When("user clicks on the Buy Now button of the first card")
    public void user_clicks_on_the_buy_now_button_of_the_first_card() {
        membershipPage.clickOnBuyNowLink();
    }

    @When("user clicks on the plus sign to read the description")
    public void user_clicks_on_the_plus_sign_to_read_the_description() {
        membershipPage.readProductDescription();
    }

    @When("user clicks on ADD TO BAG button")
    public void user_clicks_on_add_to_bag_button() {
        giftCardPage.addToBag();
    }

    @When("user clicks on VIEW BAG and removes card from bag")
    public void userClicksOnVIEWBAGAndRemovesCardFromBag() {
        giftCardPage.clickOnViewBag();
        giftCardPage.removeFromBag();
    }

    @Then("verify the bag empty message {string} displayed")
    public void verifyTheBagEmptyMessageDisplayed(String removeMessage) {
        Assert.assertEquals(giftCardPage.isRemoveSuccessful(), ConfigReader.getConfigValue(removeMessage));
    }

    @When("user clicks on GO TO SHOPPING")
    public void user_clicks_on_go_to_shopping() {
        membershipPage.clickOnGetShoppingButton();
    }

    @Then("verify user is in home page")
    public void verify_user_is_in_home_page() {
        Assert.assertTrue(membershipPage.isBackToHomePage());
    }
}
