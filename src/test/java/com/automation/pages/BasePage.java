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

    @FindBy(xpath = "//div[@class='css-1j5n2p2']//div[@class='css-1n0rqyi']")
    List<WebElement> images;

    public void switchWindow() {
        for (WebElement image : images) {
            image.click();
            String originalWindow = driver.getWindowHandle();
            Set<String> listOfWindow = driver.getWindowHandles();

            for (String window : listOfWindow) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                }
            }
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }

}
