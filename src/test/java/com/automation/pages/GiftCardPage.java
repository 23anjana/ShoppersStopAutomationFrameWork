package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GiftCardPage extends BasePage {

    @FindBy(xpath = "//div[text()='Gift Card/EGV']")
    WebElement giftCard;

    @FindBy(xpath = "//div[contains(@class,'text-black') and text()='Gift Card/EGV']")
    WebElement giftCardTitle;

    @FindBy(xpath = "//div[contains(@class,'rounded-lg')]")
    List<WebElement> giftCardList;

    // Finding element using id
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

    @FindBy(xpath = "//p[text()='Add to bag']")
    WebElement addToBag;

    @FindBy(xpath = "(//p[contains(@class,'tracking-sm') and text()='View Bag'])[2]")
    WebElement viewBag;

    @FindBy(xpath = "//img[@alt='remove product']")
    WebElement crossSign;

    @FindBy(xpath = "//p[text()='REMOVE']")
    WebElement removeButton;

    @FindBy(xpath = "//div[text()='Product removed from your cart successfully']")
    WebElement removeMessage;

    // *** Methods ***

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

    public void addToBag() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        addToBag.click();
    }

    public void fillDetails() {

        // Inputs details from config file to the details field
        firstName.sendKeys(ConfigReader.getConfigValue("first.name"));
        lastName.sendKeys(ConfigReader.getConfigValue("last.name"));
        email.sendKeys(ConfigReader.getConfigValue("email"));
        confirmEmail.sendKeys(ConfigReader.getConfigValue("confirm.email"));

        //click on PROCEED button
        proceedButton.click();
    }

    public void clickOnViewBag() {
        viewBag.click();
    }

    public boolean isProductAddedToBag() {
        return cardAddedToBag.isDisplayed();
    }

    public void removeFromBag() {
        waitForElementToBeClickable(crossSign);
        crossSign.click();
        removeButton.click();
    }

    public String isRemoveSuccessful() {

        // Waits until the element is visible
        waitForElementToBeVisible(removeMessage);

        // Prints the remove success message on te console
        System.out.println(removeMessage.getText());
        return removeMessage.getText();
    }
}
