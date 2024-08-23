package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MiscellaneousPage extends BasePage {

    @FindBy(xpath = "//img[@alt='left_arrow_white']")
    WebElement upArrow;

    @FindBy(className = "mb-2.5")
    WebElement pageTop;

    @FindBy(xpath = "//img[@alt='right_arrow']")
    WebElement rightArrow;

    @FindBy(xpath = "//a[contains(@class,'font-bold text-ssBlackHeavy')]")
    WebElement pageNumberInBoldLetter;

    @FindBy(xpath = "//img[@alt='left_circle_arrow']")
    WebElement leftArrow;

    @FindBy(xpath = "//a[contains(@class,'font-normal text-dividerShade')]")
    WebElement pageNumber;

    @FindBy(xpath = "//div[contains(@class,'md:!grid-cols-3')]/div")
    List<WebElement> productList;

    @FindBy(xpath = "//input[@placeholder='Enter your PIN code']")
    WebElement pinCodeField;

    @FindBy(xpath = "//div[text()='Check']")
    WebElement checkButton;

    @FindBy(xpath = "//div[@class='mt-6 flex items-center gap-4 self-stretch']")
    WebElement estimationDetails;

    @FindBy(xpath = "//img[@alt='logo']")
    WebElement websiteLogoLink;

    @FindBy(xpath = "//div[text()='Help / Frequently Asked Questions']")
    WebElement helpNSupportPageTitle;

    @FindBy(xpath = "//input[@placeholder='Search your question']")
    WebElement querySearchBar;

    @FindBy(xpath = "//span[text()='What is Express Delivery']")
    WebElement helpNSupportQuery;

    @FindBy(xpath = "//div[contains(@class,'md:text-neutral-500')]")
    WebElement helpNSupportQueryAnswer;

    @FindBy(xpath = "//img[@alt='plus_icon']")
    List<WebElement> plusSignOfQuery;

    // *** Methods ***

    public void scrollDownAndClickOnUpArrow() {

        // Calling the scroll function
        scroll();

        // Clicks on up arrow
        upArrow.click();
    }

    public boolean isPageScrolledUp() {
        return pageTop.isDisplayed();
    }

    public void clickOnRightArrow() {
        rightArrow.click();
    }

    public boolean isOnNextPageOfResult() {
        return pageNumberInBoldLetter.isDisplayed();
    }

    public void clickOnLeftArrow() {
        waitForElementToBeClickable(leftArrow);
        leftArrow.click();
    }

    public void clickOnDesiredPage() {
        waitForElementToBeClickable(pageNumber);
        pageNumber.click();
    }

    public void clicksOnTheProduct() {

        // Clicks on the first product from a list of products
        productList.get(0).click();

        // Switching to new window
        switchWindow();
    }

    public void inputsPinCode() {

        // Clicks on pin code field
        pinCodeField.click();

        // Inputs pin code from config file
        pinCodeField.sendKeys(ConfigReader.getConfigValue("pinCode"));

        // Clicks on check button
        checkButton.click();
    }

    public void displayEstimationInformation() {

        // Reading the text and printing on to console
        String estimate = estimationDetails.getText();
        System.out.println(estimate);
    }

    public void clickOnWebSiteLogoLink() {
        websiteLogoLink.click();
    }

    public void searchQuery(String question) {

        waitForElementToBeClickable(querySearchBar);
        querySearchBar.click();

        waitForElementToBeClickable(querySearchBar);
        querySearchBar.sendKeys(question);

        waitForElementToBeClickable(helpNSupportQuery);
        helpNSupportQuery.click();
    }

    public boolean isOnHelpNSupportPage() {
        return helpNSupportPageTitle.isDisplayed();
    }

    public void displayQueryAnswer() {

        // Reads the text as a string
        String queryAnswer = helpNSupportQueryAnswer.getText();

        // Prints the text on the console
        System.out.println(queryAnswer + "\n");
    }

    public void clickOnPlusSignForQueryDetail() {

        // Clicks on the third question displayed
        plusSignOfQuery.get(2).click();
    }
}
