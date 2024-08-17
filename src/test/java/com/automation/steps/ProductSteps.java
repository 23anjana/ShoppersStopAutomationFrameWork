package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.Then;
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

}
