package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class GiftCardPage extends BasePage {

    @FindBy(xpath = "//div[text()='Gift Card/EGV']")
    WebElement giftCard;

    @FindBy(xpath = "//div[contains(@class,'text-black') and text()='Gift Card/EGV']")
    WebElement giftCardTitle;

    @FindBy(xpath = "//div[contains(@class,'rounded-lg')]")
    List<WebElement> giftCardList;

    @FindBy(xpath = "//div[contains(@class,'md:grid-cols-3')]")
    List<WebElement> cardsImage;

    @FindBy(id = "First Name")
    WebElement firstName;

    @FindBy(id = "Last Name")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Confirm Email")
    WebElement confirmEmail;

    @FindBy(xpath = "//p[text()='Proceed']")
    WebElement proceedButton;

    @FindBy(xpath = "//div[@data-item-type='CartProductCard']")
    WebElement cardAddedToBag;

    public void switchWindow() {
        for (WebElement image : cardsImage) {
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

    public void clickOnGiftCardLink() {
        giftCard.click();
    }

    public String isOnGIftCardPage() {
        return giftCardTitle.getText();
    }

    public void clickOnFirstGiftCard() {
        giftCardList.get(0).click();
        switchWindow();
    }

    public void giftCardAddToBag() {
        productAddToBag();
    }

    public void fillDetails() {
        firstName.sendKeys(ConfigReader.getConfigValue("first.name"));
        lastName.sendKeys(ConfigReader.getConfigValue("last.name"));
        email.sendKeys(ConfigReader.getConfigValue("email"));
        confirmEmail.sendKeys(ConfigReader.getConfigValue("confirm.email"));

        //click on PROCEED button
        proceedButton.click();
    }

    public void clickOnViewBag() {
        viewBag();
    }

    public boolean isProductAddedToBag() {
        return cardAddedToBag.isDisplayed();
    }

    public void removeCardFromBag() {
        removeFromBag();
    }

    public String isCardRemovedSuccessfully() {
        return productRemovedSuccessfully();
    }
}
