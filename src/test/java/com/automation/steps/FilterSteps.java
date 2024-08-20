package com.automation.steps;

import com.automation.pages.FilterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FilterSteps {

    FilterPage filterPage=new FilterPage();

    @When("user clicks on {string} names")
    public void userClicksOnNames(String key) {
       filterPage.clicksOnBrand(key);
    }

    @Then("verify products are displayed based on {string}")
    public void verifyProductsAreDisplayedBasedOn(String key) {
       Assert.assertTrue(filterPage.isProductPageBasedOnBrandsDisplayed(key));
    }

}
