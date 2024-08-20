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
        leftArrow.click();
    }

    public void clickOnDesiredPage() {
        pageNumber.click();
    }

    public void clicksOnFirstProduct() {
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
}
