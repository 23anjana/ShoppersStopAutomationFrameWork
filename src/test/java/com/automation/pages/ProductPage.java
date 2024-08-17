package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'md:!grid-cols-3')]")
    List<WebElement> productList;

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

}
