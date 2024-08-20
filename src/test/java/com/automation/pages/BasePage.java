package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    WebDriver driver;
    static WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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

    public static boolean isPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickUsingJavaScriptExecutor(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public void switchWindow() {
        String originalWindow = driver.getWindowHandle();
        Set<String> listOfWindow = driver.getWindowHandles();

        for (String window : listOfWindow) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
            }
        }
    }
}
