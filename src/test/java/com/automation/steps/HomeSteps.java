package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens the website")
    public void user_opens_the_website() {
        homePage.openWebsite();
    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user enters {string} in the search bar")
    public void user_enters_in_the_search_bar(String searchKeyword) {
        homePage.searchProductFromSearchBar(searchKeyword);
    }

    @When("user clicks on the search bar")
    public void user_clicks_on_the_search_bar() {
        homePage.clickOnSearchBar();
    }

    @When("clicks the first product under the section")
    public void clicks_the_first_product_under_the_section() {
        homePage.trendingSearchProduct();
    }

    @When("clicks the first brand under the POPULAR BRAND section")
    public void clicks_the_first_brand_under_the_popular_brand_section() {
        homePage.popularBrand();
    }

    @When("user hovers over MAN  and choose Shirts option")
    public void userHoversOverMANAndChooseShirtsOption() throws InterruptedException {
        homePage.hoverManOption();
        Thread.sleep(3000);
    }


    @When("user hovers over KIDS and choose TopWear")
    public void userHoversOverKIDSAndChooseTopWear() {
        homePage.hoverKidsOption();
    }

    @When("user searches for {string} on search bar")
    public void userSearchesForOnSearchBar(String key) {
    }
}
