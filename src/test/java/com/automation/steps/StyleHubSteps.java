package com.automation.steps;

import com.automation.pages.StyleHubPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StyleHubSteps {

    StyleHubPage styleHubPage = new StyleHubPage();

    @Then("verify user is on style hub page")
    public void verify_user_is_on_style_hub_page() {
        Assert.assertTrue(styleHubPage.isStyleHubPageDisplayed());
    }

    @When("user clicks on Women's Fashion link")
    public void userClicksOnWomenSFashionLink() {
        styleHubPage.clickOnFirstGuide();
    }

    @And("user selects the style guide option")
    public void userSelectsTheStyleGuideOption() {
        styleHubPage.clickOnStyleGuideLink();
    }

    @Then("verify user is on style guide options page")
    public void verify_user_is_on_style_guide_options_page() {
        Assert.assertTrue(styleHubPage.isStyleGuidePageDisplayed());
    }

    @When("user clicks on the first guide")
    public void user_clicks_on_the_first_guide() {
        styleHubPage.clickOnFirstStyleGuideLink();
    }

    @Then("verify user is on the guide description page")
    public void verify_user_is_on_the_guide_description_page() {
        Assert.assertTrue(styleHubPage.isGuideDescriptionPageDisplayed());
    }

    @When("user clicks on the home icon")
    public void userClicksOnTheHomeIcon() {
        styleHubPage.clickOnHomeIcon();
    }

    @When("user clicks on Watches link")
    public void user_clicks_on_watches_link() {
        styleHubPage.clickOnWatchesLink();
    }

    @Then("verify user is on watch guide")
    public void verify_user_is_on_watch_guide() {
        Assert.assertTrue(styleHubPage.isWatchesGuidePageDisplayed());
    }

    @When("user clicks on the first watch guide option")
    public void user_clicks_on_the_first_watch_guide_option() {
        styleHubPage.clickOnFirstWatchGuideLink();
    }

    @When("user searches for {string} in the search bar")
    public void user_searches_for_in_the_search_bar(String searchKeyword) {
        styleHubPage.search(searchKeyword);
    }

    @Then("verify user is in the result page")
    public void verify_user_is_in_the_result_page() {
        Assert.assertTrue(styleHubPage.isResultPageDisplayed());
    }

    @When("user clicks on the first link")
    public void user_clicks_on_the_first_link() {
        styleHubPage.clickOnFirstSearchResultLink();
    }
}
