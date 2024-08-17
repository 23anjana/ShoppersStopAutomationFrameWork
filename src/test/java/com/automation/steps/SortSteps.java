package com.automation.steps;

import com.automation.pages.SortPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SortSteps {
    SortPage sortPage=new SortPage();

    @Then("verify product displayed is in sorted order by price low to high")
    public void verifyProductDisplayedIsInSortedOrderByPriceLowToHigh() {
        Assert.assertTrue(sortPage.verifyProductDisplayedLowToHigh());
    }

    @Then("verify product displayed is in sorted order by price high to low")
    public void verifyProductDisplayedIsInSortedOrderByPriceHighToLow() {
        Assert.assertTrue(sortPage.verifyProductDisplayedHighToLow());
    }


    @Then("verify products with highest to lowest discounts are displayed")
    public void verifyProductsWithHighestToLowestDiscountsAreDisplayed() {
        sortPage.verifyProductDisplayedDiscountHighToLow();
    }
}
