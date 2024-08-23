package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'md:!grid-cols-3')]")
    List<WebElement> productList;

    @FindBy(xpath = "//img[@class='transition-transform duration-500 rotate-0']")
    WebElement sortButton;

    @FindBy(xpath = "//span[contains(@class,'absolute right-2 flex size-3.5 items-center justify-center')]//following-sibling::span[text()='Price Low to High']")
    WebElement chooseLowToHigh;

    // Finding xpath using text
    @FindBy(xpath = "//span[text()='Price High to Low']")
    WebElement chooseHighToLow;

    @FindBy(xpath = "//h1[text()='Topwear']")
    WebElement topWearText;

    @FindBy(xpath = "//span[text()='Discount']")
    WebElement chooseDiscount;

    @FindBy(xpath = "//a[@data-testid='product-card']")
    List<WebElement> productImage;

    @FindBy(tagName = "h1")
    WebElement productText;

    @FindBy(xpath = "//div[text()='Filters']")
    WebElement filterElementText;

    @FindBy(xpath = "//p//div[contains(@class,'non-selectable')]")
    List<WebElement> sizeOptions;

    @FindBy(xpath = "//h1[text()='Shirts']")
    WebElement shirtTextElement;

    @FindBy(xpath = "//h1[text()='Ethnic Dresses']")
    WebElement ethnicTextElement;

    @FindBy(xpath = "//span[text()='LUXE BEAUTY']")
    WebElement pageTitle1;

    @FindBy(xpath = "//div[text()='SHOP ALL LUXE BEAUTY']")
    WebElement pageTitle2;

    //*** Methods ***

    // Checking if the first product is displayed from a list of products
    public boolean isResultPageDisplayed() {
        return productList.get(0).isDisplayed();
    }

    public boolean isTrendingSearchResultDisplayed() {
        return productList.get(0).isDisplayed();
    }

    public boolean isPopularBrandsResultDisplayed() {
        return productList.get(0).isDisplayed();
    }

    public String productPageDisplayed() {
        return productText.getText();
    }

    public  String isShirtPageDisplayed(){
        return shirtTextElement.getText();
    }

    public void sortOption() {
        sortButton.click();
    }

    public void sortLowToHigh() {
        chooseLowToHigh.click();
    }

    public void sortHighToLow() {
        chooseHighToLow.click();
    }

    public String topWearPageDisplayed() {
        return topWearText.getText();
    }

    public void sortDiscount() {
        chooseDiscount.click();
    }

    public void chooseProduct() {

        // Clicks the first product from product list
        productImage.get(0).click();

        //Switching to new window
        switchWindow();
    }

    public String isProductPageDisplayed() {
        return  filterElementText.getText();
    }

    public void chooseSize() {
        waitForAllElementToBeVisible(sizeOptions);

        // CLicks on the first available size
        sizeOptions.get(0).click();
    }

    public String isEthnicDressPageDisplayed(){
        return  ethnicTextElement.getText();
    }

    public boolean isBottomCategoryResultPageDisplayed() {
        return pageTitle1.isDisplayed() && pageTitle2.isDisplayed();
    }
}
