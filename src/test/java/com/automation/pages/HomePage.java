package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    // Finding element using class name
    @FindBy(className = "mb-2.5")
    WebElement websiteHeader;

    @FindBy(xpath = "(//div[@class='slick-slide slick-active slick-current'])[1]")
    WebElement banner;

    // Finding element using tag name
    @FindBy(tagName = "input")
    WebElement searchBar;

    @FindBy(xpath = "//div[contains(@class,'cursor-pointer justify-between')]")
    List<WebElement> firstSearchOption;

    @FindBy(xpath = "//div[contains(@class,'gap-2 bg-neutral-100')]")
    List<WebElement> firstTrendingSearch;

    @FindBy(xpath = "//div[contains(@class,'flex-col flex-wrap')]")
    List<WebElement> popularBrandStop;

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

    @FindBy(xpath = "//a[text()='WOMEN']")
    WebElement elementWomen;

    @FindBy(xpath = "//li[text()='Ethnic Dresses']")
    WebElement ethnicDress;

    @FindBy(xpath = "//div[@class='flex justify-between']")
    WebElement scrollUpTo;

    @FindBy(xpath = "//li[contains(@class,'lg:text-xs xl:text-sm font-normal')]/a")
    List<WebElement> bottomCategoryList;

    public void openWebsite() {

        // Passing the Website URL from config file
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

        // Inputs the product name
        searchBar.sendKeys(productName);

        firstSearchOption.get(0).click();

//        // Clicks on enter
//        searchBar.sendKeys(Keys.RETURN);
    }

    public void trendingSearchProduct() {
        firstTrendingSearch.get(0).click();
    }

    public void popularBrand() {
        popularBrandStop.get(1).click();
    }

    public void hoverManOption() {

        // Using Actions class to do the hover functionality
        Actions action = new Actions(driver);

        // Hovers on the element
        action.moveToElement(elementMan).build().perform();
//
//        // Clicks the product
        elementShirt.click();

    }

    public void hoverKidsOption() {

        // Hovering functionality to navigate to Kids Top Wear page
        Actions action = new Actions(driver);
        action.moveToElement(elementKid).build().perform();
        elementTopWear.click();
    }

    public void searchItem(String productName) {

        // Calling search bar function
        clickOnSearchBar();

        // Inputs product name
        searchBar.sendKeys(productName);

        // Clicks on the first product from the list
        firstProductOption.get(0).click();
    }

    public void clickOnStoreIcon() {
        storeIcon.click();
    }

    public void clickOnStyleHubLink() {

        // Clicks on Style Hub link
        styleHub.click();

        // Switching to new window
        switchWindow();
    }

    public void hoverWomenOption() {
        // Using Actions class to do the hover functionality
        Actions action = new Actions(driver);

        // Hovers on the element
        action.moveToElement(elementWomen).build().perform();

        // Clicks the product
        ethnicDress.click();
    }

    public void clickOnCategoryListAtPageBottom() {

        // Scroll till the element is displayed
        scrollTillTheElement(scrollUpTo);

        // Selecting a category
        bottomCategoryList.get(9).click();
    }
}
