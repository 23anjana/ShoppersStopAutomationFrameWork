package com.automation.steps;

import com.automation.pages.MyAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyAccountSteps {

    MyAccountPage myAccountPage = new MyAccountPage();

    @When("user clicks on the store icon")
    public void user_clicks_on_the_store_icon() {
        myAccountPage.clickOnStoreIcon();
    }

    @Then("verify user is on store page")
    public void verify_user_is_on_store_page() {
        Assert.assertEquals(myAccountPage.isOnStorePage(), "Stores & Events");
    }

    @When("user selects a city under Stores section")
    public void user_selects_a_city_under_stores_section() {
        myAccountPage.chooseCity();
    }

    @Then("display the names of stores onto the console")
    public void display_the_names_of_stores_onto_the_console() {
        myAccountPage.printStoreNames();
    }

    @When("user clicks on Gift Card link")
    public void user_clicks_on_gift_card_link() {
        myAccountPage.clickOnGiftCardLink();
    }

    @Then("verify user is on gift card page")
    public void verify_user_is_on_gift_card_page() {
        Assert.assertEquals(myAccountPage.isOnGIftCardPage(), "Gift Card/EGV");
    }

    @When("user clicks on the first gift card")
    public void user_clicks_on_the_first_gift_card() {

    }

    @When("user clicks on ADD TO BAG")
    public void user_clicks_on_add_to_bag() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user fills all the details and clicks on PROCEED")
    public void user_fills_all_the_details_and_clicks_on_proceed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify the product is successfully added to the bag")
    public void verify_the_product_is_successfully_added_to_the_bag() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the remove button indicated by a cross sign")
    public void user_clicks_on_the_remove_button_indicated_by_a_cross_sign() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the REMOVE button")
    public void user_clicks_on_the_remove_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify the bag is empty")
    public void verify_the_bag_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the First Citizen Club link")
    public void user_clicks_on_the_first_citizen_club_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user is on membership page")
    public void verify_user_is_on_membership_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the Buy Now button of the first card")
    public void user_clicks_on_the_buy_now_button_of_the_first_card() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the plus sign to read the description")
    public void user_clicks_on_the_plus_sign_to_read_the_description() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on ADD TO BAG button")
    public void user_clicks_on_add_to_bag_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify the product is added to the bag")
    public void verify_the_product_is_added_to_the_bag() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on VIEW BAG")
    public void user_clicks_on_view_bag() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the cross mark to remove card from bag")
    public void user_clicks_on_the_cross_mark_to_remove_card_from_bag() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on GO TO SHOPPING")
    public void user_clicks_on_go_to_shopping() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user is in home page")
    public void verify_user_is_in_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the Logout link")
    public void user_clicks_on_the_logout_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user gets the logout alert")
    public void verify_user_gets_the_logout_alert() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the {string} button")
    public void user_clicks_on_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user is successfully logged out")
    public void verify_user_is_successfully_logged_out() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
