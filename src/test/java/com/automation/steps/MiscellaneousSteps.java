package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.MiscellaneousPage;
import com.automation.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MiscellaneousSteps {

    MiscellaneousPage miscellaneousPage = new MiscellaneousPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @When("user scrolls to the bottom of the page and clicks on the Up Arrow")
    public void userScrollsToTheBottomOfThePageAndClicksOnTheUpArrow() {
        miscellaneousPage.scrollDownAndClickOnUpArrow();
    }

    @Then("Verify the page is scrolled to the top")
    public void verifyThePageIsScrolledToTheTop() {
        Assert.assertTrue(miscellaneousPage.isPageScrolledUp());
    }

    @Then("verify user is navigated to the desired page")
    public void verifyUserIsNavigatedToTheDesiredPage() {
        Assert.assertTrue(miscellaneousPage.isOnNextPageOfResult());
    }

    @When("user clicks on the right arrow")
    public void userClicksOnTheRightArrow() {
        miscellaneousPage.clickOnRightArrow();
    }

    @When("user clicks on the left arrow")
    public void userClicksOnTheLeftArrow() {
        miscellaneousPage.clickOnLeftArrow();
    }

    @When("user clicks on fifth page")
    public void userClicksOnFifthPage() {
        miscellaneousPage.clickOnDesiredPage();
    }

    @When("user clicks on the first product displayed")
    public void userClicksOnTheFirstProductDisplayed() {
        miscellaneousPage.clicksOnFirstProduct();
    }

    @And("user inputs the pin code and clicks on Check button")
    public void userInputsThePinCodeAndClicksOnCheckButton() {
        miscellaneousPage.inputsPinCode();
    }

    @Then("display the estimation information on to the console")
    public void displayTheEstimationInformationOnToTheConsole() {
        miscellaneousPage.displayEstimationInformation();
    }

    @When("user clicks on the website logo")
    public void userClicksOnTheWebsiteLogo() {
        miscellaneousPage.clickOnWebSiteLogoLink();
    }

    @When("user clicks on one of the category")
    public void userClicksOnOneOfTheCategory() {
        homePage.clickOnCategoryListAtPageBottom();
    }

    @Then("verify user is navigated to the category result page")
    public void verifyUserIsNavigatedToTheCategoryResultPage() {
        Assert.assertTrue(productPage.isBottomCategoryResultPageDisplayed());
    }
}
