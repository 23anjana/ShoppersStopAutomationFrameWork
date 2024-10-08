package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
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
        homePage.searchProductFromSearchBar(ConfigReader.getConfigValue(searchKeyword));
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
    public void userHoversOverMANAndChooseShirtsOption() {
        homePage.hoverManOption();
    }


    @When("user hovers over KIDS and choose TopWear")
    public void userHoversOverKIDSAndChooseTopWear() {
        homePage.hoverKidsOption();
    }

    @When("user searches for {string} on search bar")
    public void userSearchesForOnSearchBar(String key) {
        homePage.searchItem(ConfigReader.getConfigValue(key));
    }

    @When("user clicks on the store icon")
    public void user_clicks_on_the_store_icon() {
        homePage.clickOnStoreIcon();
    }

    @When("user clicks on style hub link")
    public void user_clicks_on_style_hub_link() {
        homePage.clickOnStyleHubLink();
    }

    @When("user hovers over WOMEN and choose Ethnic Dresses option")
    public void userHoversOverWOMENAndChooseEthnicDressesOption(){
        homePage.hoverWomenOption();
    }

    @When("user hovers over {string}")
    public void userHoversOver(String key) {
        homePage.hoverElement(key);
    }
}
