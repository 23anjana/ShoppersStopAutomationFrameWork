package com.automation.steps;

import com.automation.pages.StoreNLogoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreNLogoutSteps {

    StoreNLogoutPage storeNLogoutPage = new StoreNLogoutPage();

    @When("user clicks on the store icon")
    public void user_clicks_on_the_store_icon() {
        storeNLogoutPage.clickOnStoreIcon();
    }

    @Then("verify user is on store page")
    public void verify_user_is_on_store_page() {
        Assert.assertEquals(storeNLogoutPage.isOnStorePage(), "Stores & Events");
    }

    @When("user selects a city under Stores section")
    public void user_selects_a_city_under_stores_section() {
        storeNLogoutPage.chooseCity();
    }

    //Logout functionality steps
    @Then("display the names of stores onto the console")
    public void display_the_names_of_stores_onto_the_console() {
        storeNLogoutPage.printStoreNames();
    }

    @When("user clicks on the Logout link")
    public void user_clicks_on_the_logout_link() {
        storeNLogoutPage.clickOnLogoutLink();
    }

    @Then("verify user gets the logout confirm button")
    public void verify_user_gets_the_logout_confirm_button() {
        Assert.assertTrue(storeNLogoutPage.isLogoutConfirmButtonVisible());
    }

    @When("user clicks on the logout confirm button")
    public void userClicksOnTheLogoutConfirmButton() {
        storeNLogoutPage.confirmLogout();
    }

    @Then("verify user is successfully logged out")
    public void verify_user_is_successfully_logged_out() {
        Assert.assertTrue(storeNLogoutPage.isLogoutSuccessful());
    }

}
