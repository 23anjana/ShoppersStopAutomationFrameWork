package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

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

    public void productAddToBag() {
        addToBag.click();
    }

    public void viewBag() {
        viewBag.click();
    }

    public void removeFromBag() {
        crossSign.click();
        removeButton.click();
    }

    public String productRemovedSuccessfully() {
        return removeMessage.getText();
    }
}
