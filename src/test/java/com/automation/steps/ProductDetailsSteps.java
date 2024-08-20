package com.automation.steps;

import com.automation.pages.GiftCardPage;
import com.automation.pages.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    GiftCardPage giftCardPage = new GiftCardPage();


    @And("user choose the preferred size from size chart")
    public void userChooseThePreferredSizeFromSizeChart() {
        productDetailsPage.clickSizeChart();
        productDetailsPage.chooseSize();
    }

    @And("user clicks on close button")
    public void userClicksOnCloseButton() {
        productDetailsPage.clickCloseButton();
    }

    @And("user clicks on ADD TO BAG button option")
    public void userClicksOnADDTOBAGButtonOption() {
        giftCardPage.addToBag();
    }

    @Then("verify user added product successfully to the bag")
    public void verifyUserAddedProductSuccessfullyToTheBag() {
        Assert.assertEquals(productDetailsPage.productAddedSuccessfully(), "Product added to your cart successfully");
    }

    @And("user remove product from bag")
    public void userRemoveProductFromBag() {
        productDetailsPage.clicksRemoveIcon();
    }

    @Then("verify product is removed successfully from bag")
    public void verifyProductIsRemovedSuccessfullyFromBag() {
        Assert.assertEquals(giftCardPage.isRemoveSuccessful(), "Product removed from your cart successfully");
    }

    @Then("verify user added first product successfully into the bag")
    public void verifyUserAddedFirstProductSuccessfullyIntoTheBag() {
        Assert.assertEquals(productDetailsPage.productAddedSuccessfully(), "Product added to your cart successfully");
    }
}
