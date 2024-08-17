package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//img[contains(@class,'my-[6px] max-h-[20px] self-center')]")
    WebElement websiteLogo;

    @FindBy(id = "radix-:r0:")
    WebElement loginDisplay;

    @FindBy(xpath = "(//div[@class='slick-slide slick-active slick-current'])[1]")
    WebElement banner;

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("website.url"));
    }

    public boolean isHomePageDisplayed() {
        return websiteLogo.isDisplayed()
                && loginDisplay.isDisplayed()
                && banner.isDisplayed();
    }
}
