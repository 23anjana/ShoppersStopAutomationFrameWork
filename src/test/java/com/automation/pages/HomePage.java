package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

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

    @FindBy(xpath = "//a[text()='MEN ']")
    WebElement elementMan;

    @FindBy(xpath = "//li[text()='Shirts']")
    WebElement elementShirt;

    @FindBy(xpath = "//a[@target='_self' and text()='KIDS']")
    WebElement elementKid;

    @FindBy(xpath = "//div[text()='Boys']//following-sibling::div//li[text()='Topwear']")
    WebElement elementTopWear;

    @FindBy(xpath = "//p[@data-testid='suggested-search']")
    List<WebElement> firstProductOption;

    @FindBy(xpath = "//img[@alt='near-by-store']")
    WebElement storeIcon;

    @FindBy(xpath = "//div[text()='Style Hub']")
    WebElement styleHub;

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
        searchBar.sendKeys(Keys.RETURN);
    }

    public void trendingSearchProduct() {
        firstTrendingSearch.click();
    }

    public void popularBrand() {
        popularBrandStop.click();
    }

    public void hoverManOption() {
        Actions action = new Actions(driver);
        action.moveToElement(elementMan).build().perform();
        elementShirt.click();

    }

    public void hoverKidsOption() {
        Actions action = new Actions(driver);
        action.moveToElement(elementKid).build().perform();
        elementTopWear.click();

    }

    public void searchItem(String productName){
        clickOnSearchBar();
        searchBar.sendKeys(productName);
        firstProductOption.get(0).click();
    }

    public void clickOnStoreIcon() {
        storeIcon.click();
    }

    public void clickOnStyleHubLink() {
        styleHub.click();
        switchWindow();
    }
}
