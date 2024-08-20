package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
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
        Assert.assertEquals(productPage.isShirtPageDisplayed(),"SHIRTS");
    }

    @When("user clicks on sort button")
    public void user_clicks_on_sort_button()  {
        productPage.sortOption();
    }

    @When("user choose the price low to high sort option")
    public void user_choose_the_price_low_to_high_sort_option(){
        productPage.sortLowToHigh();
    }

    @And("user choose the price high to low sort option")
    public void userChooseThePriceHighToLowSortOption(){
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
        Assert.assertEquals(productPage.productPageDisplayed(),ConfigReader.getConfigValue("product.name").toUpperCase());
    }

    @When("user choose first product from result page")
    public void userChooseFirstProductFromResultPage() {
       productPage.chooseFirstProduct();
    }
    @Then("verify searched product page is displayed")
    public void verifySearchedProductPageIsDisplayed() {
        Assert.assertEquals(productPage.productPageDisplayed(), ConfigReader.getConfigValue("product.first_name"));
        Assert.assertEquals(productPage.isFirstProductPageDisplayed(),"FILTERS");
    }

    @When("user choose first product and preferred size of the first product")
    public void userChooseFirstProductAndPreferredSizeOfTheFirstProduct() throws InterruptedException {
        productPage.chooseFirstProduct();
        productPage.chooseSize();
        Thread.sleep(2000);
    }

    @Then("verify second product page is displayed")
    public void verifySecondProductPageIsDisplayed() {
        Assert.assertEquals(productPage.productPageDisplayed(),ConfigReader.getConfigValue("product.second_name"));
        Assert.assertEquals(productPage.isFirstProductPageDisplayed(),"FILTERS");

    }

    @When("user choose first product from the second product result page")
    public void userChooseFirstProductFromTheSecondProductResultPage() throws InterruptedException {
        productPage.chooseFirstProduct();
        Thread.sleep(2000);
    }

    @Then("verify  result page is displayed")
    public void verifyResultPageIsDisplayed() {
        Assert.assertEquals(productPage.isEthnicDressPageDisplayed(),"ETHNIC DRESSES");
    }
}
