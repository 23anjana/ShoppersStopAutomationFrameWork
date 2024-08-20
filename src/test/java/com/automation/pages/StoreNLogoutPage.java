package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StoreNLogoutPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'md:mb-6') and text()='Stores & Events']")
    WebElement storeNEventsTitle;

    // Finding element using id
    @FindBy(id = "Select City")
    WebElement selectCityField;

    @FindBy(xpath = "//li[@value='Hyderabad']")
    WebElement selectCity;

    @FindBy(xpath = "//div[contains(@class,'md:!text-lg')]")
    List<WebElement> storeNameList;

    // *** Logout feature paths ***
    @FindBy(xpath = "//div[text()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[text()='Are you sure you want to log out?']")
    WebElement logoutConfirmPage;

    @FindBy(xpath = "//button[contains(@class,'text-sm')]/p[text()='YES,LOG OUT']")
    WebElement logoutConfirmButton;

    @FindBy(xpath = "//div[text()='You have been logged out!!']")
    WebElement logoutSuccessfulMessage;

    public String isOnStorePage() {
        return storeNEventsTitle.getText();
    }

    public void chooseCity() {
        selectCityField.click();
        selectCity.click();
    }

    public void printStoreNames() {
        for (WebElement storeName : storeNameList) {
            System.out.println(storeName.getText());
        }
    }

    // *** Logout feature methods ***
    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    public boolean isLogoutConfirmButtonVisible() {
        return logoutConfirmPage.isDisplayed();
    }

    public void confirmLogout() {
        logoutConfirmButton.click();
    }

    public String isLogoutSuccessful() {
        return logoutSuccessfulMessage.getText();
    }

}
