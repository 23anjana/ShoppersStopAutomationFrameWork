package com.automation.steps;

import com.automation.pages.BeautyStopPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BeautyStopSteps {

    BeautyStopPage beautyStopPage = new BeautyStopPage();

    @When("user clicks on The Beauty Shop link")
    public void userClicksOnTheBeautyShopLink() {
        beautyStopPage.clickOnBeautyStopLink();
    }

    @When("user selects the product from category list")
    public void user_selects_the_product_from_category_list() {
        beautyStopPage.chooseProductCategory();
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        beautyStopPage.searchProduct(ConfigReader.getConfigValue(product));
    }

    @Then("verify the result page is displayed")
    public void verify_the_result_page_is_displayed() {
        Assert.assertTrue(beautyStopPage.isResultPageDisplayed());
    }

    @When("user clicks on the first product")
    public void user_clicks_on_the_first_product() {
        beautyStopPage.clickOnFirstProduct();
    }

    @When("user clicks on ADD TO CART button")
    public void user_clicks_on_add_to_cart_button() {
        beautyStopPage.addProductToCart();
    }

    @Then("verify the product is successfully added to cart")
    public void verify_the_product_is_successfully_added_to_cart() {
        Assert.assertTrue(beautyStopPage.isProductAddedToCart());
    }

    @When("user clicks on cart icon")
    public void user_clicks_on_cart_icon() {
        beautyStopPage.clickOnCartIcon();
    }

    @When("user clicks on the plus sign to add the product quantity")
    public void user_clicks_on_the_plus_sign_to_add_the_product_quantity() {
        beautyStopPage.clickToAddQuantity();
    }

    @Then("verify quantity is successfully updated")
    public void verify_quantity_is_successfully_updated() {
        Assert.assertTrue(beautyStopPage.isQuantityUpdated());
    }

    @When("user clicks on remove button")
    public void user_clicks_on_remove_button() {
        beautyStopPage.removeProduct();
    }

    @Then("verify product is removed from the cart")
    public void verify_product_is_removed_from_the_cart() {
       Assert.assertTrue(beautyStopPage.isProductSuccessfullyRemoved());
    }

    @When("user clicks on GO SHOPPING button")
    public void user_clicks_on_go_shopping_button() {
        beautyStopPage.clickOnGetShoppingButton();
    }

    @Then("verify user is on SSBeauty home page")
    public void verify_user_is_on_ss_beauty_home_page() {
        Assert.assertTrue(beautyStopPage.isSSBeautyHomePageDisplayed());
    }
}
