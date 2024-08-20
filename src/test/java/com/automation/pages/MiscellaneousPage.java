package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
