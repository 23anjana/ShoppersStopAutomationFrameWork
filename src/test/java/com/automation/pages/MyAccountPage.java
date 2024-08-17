package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//img[@alt='near-by-store']")
    WebElement storeIcon;

    @FindBy(xpath = "//div[contains(@class,'md:mb-6') and text()='Stores & Events']")
    WebElement storeNEventsTitle;

    @FindBy(id = "Select City")
    WebElement selectCityField;

    @FindBy(xpath = "//li[@value='Hyderabad']")
    WebElement selectCity;

    @FindBy(xpath = "//div[contains(@class,'md:!text-lg')]")
    List<WebElement> storeNameList;

    @FindBy(xpath = "//div[text()='Gift Card/EGV']")
    WebElement giftCard;

    @FindBy(xpath = "//div[contains(@class,'text-black') and text()='Gift Card/EGV']")
    WebElement giftCardTitle;

    @FindBy(xpath = "//div[contains(@class,'rounded-lg')]")
    List<WebElement> giftCardList;

    @FindBy(xpath = "//p[text()='Add to bag']")
    WebElement giftCardAddToBag;

    @FindBy(id = "First Name")
    WebElement firstName;

    @FindBy(id = "Last Name")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Confirm Email")
    WebElement confirmEmail;

    public void clickOnStoreIcon() {
        storeIcon.click();
    }

    public String isOnStorePage() {
        return storeNEventsTitle.getText();
    }

    public void chooseCity() {
        selectCityField.click();
        selectCity.click();
    }

    public void printStoreNames() {
        for(WebElement storeName : storeNameList) {
            System.out.println(storeName.getText());
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
    }

    public void giftCardAddToBag() {
        giftCardAddToBag.click();
    }

    public void fillDetails() {
        firstName.sendKeys(ConfigReader.getConfigValue("first.name"));
        lastName.sendKeys(ConfigReader.getConfigValue("last.name"));
        email.sendKeys(ConfigReader.getConfigValue("email"));
        confirmEmail.sendKeys(ConfigReader.getConfigValue("confirm.email"));
    }
}
