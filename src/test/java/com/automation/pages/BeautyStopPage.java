package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BeautyStopPage extends BasePage {

    // Finding element using xpath
    @FindBy(xpath = "//span[text()='The Beauty Stop']")
    WebElement theBeautyStopLink;

    @FindBy(xpath = "//a[text()='Category']")
    WebElement categoryLink;

    @FindBy(xpath = "//p[text()='Natural']")
    WebElement chooseCategory;

    @FindBy(xpath = "(//p[text()='Candles'])[1]")
    WebElement product;

    @FindBy(xpath = "//input[@placeholder='Tell us what are you looking for']")
    WebElement searchBar;

    // Finding element using tag name
    @FindBy(tagName = "h1")
    WebElement resultPageTitle;

    @FindBy(xpath = "//div[contains(@class,'css-isbt42')]")
    List<WebElement> firstProduct;

    @FindBy(xpath = "//p[text()='ADD TO CART']")
    WebElement addToCartButton;

    @FindBy(xpath = "//p[text()='Product successfully added to your cart']")
    WebElement addToCartSuccessMessage;

    @FindBy(xpath = "//span[contains(@class,'MuiBadge-root css-1g48zis')]")
    WebElement cartIcon;

    @FindBy(xpath = "//button[text()='+']")
    WebElement addTheQuantity;

    @FindBy(xpath = "//p[text()='Quantity has been updated']")
    WebElement quantityUpdated;

    @FindBy(xpath = "//p[text()='Remove']")
    WebElement removeLink;

    @FindBy(xpath = "//button[text()='Remove']")
    WebElement removeButton;

    @FindBy(xpath = "//p[text()='Product Removed']")
    WebElement productRemovedMessage;

    @FindBy(xpath = "//button[text()='get shopping']")
    WebElement getShoppingButton;

    @FindBy(xpath = "//img[@alt='web image SSBeauty']")
    WebElement ssBeautyLogo;

    public void chooseProductCategory() {
        Actions action = new Actions(driver);

        // Move to the category link and hover over it
        action.moveToElement(categoryLink).build().perform();

        // Move to the sub-category and hover over it
        action.moveToElement(chooseCategory).build().perform();

        // Move to the product and click on it
        action.moveToElement(product).click().perform();
    }

    public void clickOnBeautyStopLink() {
        theBeautyStopLink.click();

        // Switching to new window
        switchWindow();
    }

    public void searchProduct(String productName) {

        // Click on the search bar
        searchBar.click();

        // Input the product name
        searchBar.sendKeys(productName);

        // Click on enter or return
        searchBar.sendKeys(Keys.ENTER);
    }

    public boolean isResultPageDisplayed() {
        return resultPageTitle.isDisplayed();
    }

    public void clickOnFirstProduct() {

        // Clicks on the first product from a list of products displayed
        firstProduct.get(0).click();

        // Switching to new window
        switchWindow();
    }

    public void addProductToCart() {
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }

    public boolean isProductAddedToCart() {
        return addToCartSuccessMessage.isDisplayed();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void clickToAddQuantity() {
        waitForElementToBeClickable(addTheQuantity);
        addTheQuantity.click();
    }

    public boolean isQuantityUpdated() {
        waitForElementToBeClickable(quantityUpdated);
        return quantityUpdated.isDisplayed();
    }

    public void removeProduct() {

        // Clicks on the Remove link
        removeLink.click();

        // Clicks on the Remove button
        removeButton.click();
    }

    public boolean isProductSuccessfullyRemoved() {
        waitForElementToBeClickable(productRemovedMessage);
        return productRemovedMessage.isDisplayed();
    }

    public void clickOnGetShoppingButton() {
        waitForElementToBeClickable(getShoppingButton);
        getShoppingButton.click();
    }

    public boolean isSSBeautyHomePageDisplayed() {
        return ssBeautyLogo.isDisplayed();
    }
}
