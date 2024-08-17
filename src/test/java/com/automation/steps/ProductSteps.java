package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @Then("verify result page is displayed")
    public void verify_result_page_is_displayed() {
        Assert.assertTrue(productPage.isResultPageDisplayed());
    }

    @Then("verify the product result page is displayed")
    public void verify_the_product_result_page_is_displayed() {
        Assert.assertTrue(productPage.isTrendingSearchResultDisplayed());
    }

    @Then("verify products of a particular brand are displayed")
    public void verify_products_of_a_particular_brand_are_displayed() {
        Assert.assertTrue(productPage.isPopularBrandsResultDisplayed());
    }

    @Then("verify  product page is displayed")
    public void verify_product_page_is_displayed() {
        Assert.assertEquals(productPage.shirtPageDisplayed(),"SHIRTS");
    }

    @When("user clicks on sort button")
    public void user_clicks_on_sort_button() throws InterruptedException {
        productPage.sortOption();
    }

    @When("user choose the price low to high sort option")
    public void user_choose_the_price_low_to_high_sort_option() throws InterruptedException {
        productPage.sortLowToHigh();
        Thread.sleep(2000);
    }

    @And("user choose the price high to low sort option")
    public void userChooseThePriceHighToLowSortOption() {
        productPage.sortHighToLow();
    }

    @Then("verify kids products page displayed")
    public void verifyKidsProductsPageDisplayed() {
        Assert.assertEquals(productPage.topWearPageDisplayed(),"TOPWEAR");
    }
    @And("user choose the Discount option")
    public void userChooseTheDiscountOption() {
        productPage.sortDiscount();
    }

    @Then("verify search result page is displayed")
    public void verifySearchResultPageIsDisplayed() {

    }

    @When("user choose first product from result page")
    public void userChooseFirstProductFromResultPage() {

    }

}
