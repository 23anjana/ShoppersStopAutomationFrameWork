package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "mb-2.5")
    WebElement websiteHeader;

    @FindBy(xpath = "(//div[@class='slick-slide slick-active slick-current'])[1]")
    WebElement banner;

    @FindBy(tagName = "input")
    WebElement searchBar;

    @FindBy(xpath = "(//div[contains(@class,'xs:text-sm')])[1]")
    WebElement firstTrendingSearch;

    @FindBy(xpath = "//div[contains(@class,'lg:text')and text()='Stop']")
    WebElement popularBrandStop;

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("website.url"));
    }

    public boolean isHomePageDisplayed() {
        return websiteHeader.isDisplayed()
                && banner.isDisplayed();
    }

    // Function to facilitate clicking on search bar
    public void clickOnSearchBar() {
        searchBar.click();
    }

    public void searchProductFromSearchBar(String productName) {
        // Calling the search bar function
        clickOnSearchBar();
        searchBar.sendKeys(productName);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void trendingSearchProduct() {
        firstTrendingSearch.click();
    }

    public void popularBrand() {
        popularBrandStop.click();
    }
}
