package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StoreNLogoutPage extends BasePage {

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

    //Logout feature paths
    @FindBy(xpath = "//div[text()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "p[text()='YES,LOG OUT']")
    WebElement logoutConfirmButton;

    @FindBy(xpath = "//div[text()='You have been logged out']")
    WebElement logoutSuccessfulMessage;

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
        for (WebElement storeName : storeNameList) {
            System.out.println(storeName.getText());
        }
    }

    // Logout feature methods
    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    public boolean isLogoutConfirmButtonVisible() {
        return logoutConfirmButton.isDisplayed();
    }

    public void confirmLogout() {
        logoutConfirmButton.click();
    }

    public boolean isLogoutSuccessful() {
        return logoutSuccessfulMessage.isDisplayed();
    }
}
