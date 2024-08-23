package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends BasePage {

    @FindBy(xpath = "//div[text()='First Citizen Club']")
    WebElement membershipLink;

    @FindBy(xpath = "//div[text()='Membership Details & Benefits']")
    WebElement membershipTitle;

    @FindBy(xpath = "(//div[text()='Buy Now'])[1]")
    WebElement buyNowLink;

    // Finding ancestor element
    @FindBy(xpath = "//img[@alt='plus_icon']/ancestor::button[text()='Description']")
    WebElement productDescription;

    @FindBy(xpath = "//p[text()='GET SHOPPING']")
    WebElement getShoppingButton;

    @FindBy(xpath = "//img[@alt='near-by-store']")
    WebElement storeIcon;

    //*** Methods ***

    public void clickOnMembershipLink() {
        membershipLink.click();
    }

    public String isMembershipPage() {
        return membershipTitle.getText();
    }

    public void clickOnBuyNowLink() {
        buyNowLink.click();

        // Switching to a new window
        switchWindow();
    }

    public void readProductDescription() {
        productDescription.click();
    }

    public void clickOnGetShoppingButton() {
        getShoppingButton.click();
    }

    public boolean isBackToHomePage() {
        return storeIcon.isDisplayed();
    }
}
