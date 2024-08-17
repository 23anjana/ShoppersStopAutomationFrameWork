package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'md:!grid-cols-3')]")
    List<WebElement> productList;

    @FindBy(xpath = "//div[contains(@class,'mb-6 text-lg font-normal')]//h1")
    WebElement shirtText;

    @FindBy(xpath = "//img[@class='transition-transform duration-500 rotate-0']")
    WebElement sortBtn;

    @FindBy(xpath = "//span[contains(@class,'absolute right-2 flex size-3.5 items-center justify-center')]//following-sibling::span[text()='Price Low to High']")
    WebElement chooseLowToHigh;

    @FindBy(xpath = "//span[text()='Price High to Low']")
    WebElement chooseHighToLow;

    @FindBy(xpath = "//h1[text()='Topwear']")
    WebElement topWearText;

    @FindBy(xpath = "//span[text()='Discount']")
    WebElement chooseDiscount;

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

    public String shirtPageDisplayed() {
        return shirtText.getText();
    }

    public void sortOption() throws InterruptedException {
        sortBtn.click();
        Thread.sleep(2000);
    }

    public void sortLowToHigh() {
        chooseLowToHigh.click();
    }

    public void sortHighToLow() {
        chooseHighToLow.click();
    }

    public String topWearPageDisplayed(){
        return  topWearText.getText();
    }

    public void sortDiscount() {
        chooseDiscount.click();
    }
}
