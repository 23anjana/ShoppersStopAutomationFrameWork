package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class MembershipPage extends BasePage {

    @FindBy(xpath = "//div[text()='First Citizen Club']")
    WebElement membershipLink;

    @FindBy(xpath = "//div[text()='Membership Details & Benefits']")
    WebElement membershipTitle;

    @FindBy(xpath = "(//div[text()='Buy Now'])[1]")
    WebElement buyNowLink;

    @FindBy(xpath = "//div[contains(@class,'md:grid-cols-4')]")
    List<WebElement> membershipImage;

    @FindBy(xpath = "//img[@alt='plus_icon']/ancestor::button[text()='Description']")
    WebElement productDescription;

    @FindBy(xpath = "//p[text()='GET SHOPPING']")
    WebElement getShoppingButton;

    @FindBy(xpath = "//img[@alt='near-by-store']")
    WebElement storeIcon;

    public void clickOnMembershipLink() {
        membershipLink.click();
    }

    public String isMembershipPage() {
        return membershipTitle.getText();
    }

    public void switchWindow() {
        for (WebElement image : membershipImage) {
            image.click();
            String originalWindow = driver.getWindowHandle();
            Set<String> listOfWindow = driver.getWindowHandles();

            for (String window : listOfWindow) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                }
            }
        }
    }

    public void clickOnBuyNowLink() {
        buyNowLink.click();
        switchWindow();
    }

    public void addToBag() {
        productAddToBag();
    }

    public void readProductDescription() {
        productDescription.click();
    }

//    public boolean isCardSuccessfullyAddedToBag() {
//        return addedSuccessfully.isDisplayed();
//    }

    public void removeMembershipCardFromBag() {
        viewBag();
        removeFromBag();
    }

    public String isCardRemovedFromBag() {
        return productRemovedSuccessfully();
    }

    public void clickOnGetShoppingButton() {
        getShoppingButton.click();
    }

    public boolean isBackToHomePage() {
        return storeIcon.isDisplayed();
    }
}
