package com.automation.steps;

import com.automation.pages.FilterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class FilterSteps {

    FilterPage filterPage=new FilterPage();

    @When("user clicks on brand {string} names")
    public void userClicksOnBrandNames(String key){
       filterPage.clicksOnFilterOptions(key);
    }

    @Then("verify products are displayed based on {string} brand names")
    public void verifyProductsAreDisplayedBasedOnBrandNames(String key) {
        Assert.assertTrue(filterPage.isProductPageBasedOnBrandsDisplayed(key));
    }

    @When("user clicks on categories {string} under filter options")
    public void userClicksOnCategoriesUnderFilterOptions(String key) {
        filterPage.clicksOnFilterOptions(key);
    }

    @And("user search filter option {string} in the filter categories search bar")
    public void userSearchFilterOptionInTheFilterCategoriesSearchBar(String key) {
        filterPage.searchOnFilterSearchBar(key);
    }

    @And("select the resultant filter option")
    public void selectTheResultantFilterOption() {
        filterPage.clicksOnSearchResults();
    }

    @Then("verify filtered {string} page is displayed")
    public void verifyFilteredPageIsDisplayed(String filteredOptionName) {
        Assert.assertEquals(filterPage.isFilteredPageDisplayed(filteredOptionName),filteredOptionName);
    }


    @When("user clicks on clear all option")
    public void userClicksOnClearAllOption() {
        filterPage.clicksOnClearAllButton();
        
    }

    @Then("verify all applied filters are cleared")
    public void verifyAllAppliedFiltersAreCleared() {
        Assert.assertTrue(filterPage.isAppliedFiltersCleared());
    }
}
