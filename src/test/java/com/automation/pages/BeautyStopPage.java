package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Set;

public class BeautyStopPage extends BasePage {

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

    public void switchWindow() {
        String originalWindow = driver.getWindowHandle();
        Set<String> listOfWindow = driver.getWindowHandles();

        for (String window : listOfWindow) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
            }
        }
    }

    public void chooseProductCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(categoryLink).build().perform();
        action.moveToElement(chooseCategory).build().perform();
        action.moveToElement(product).click().perform();
    }

    public void clickOnBeautyStopLink() {
        theBeautyStopLink.click();
        switchWindow();
    }

    public void searchProduct(String productName) {
        searchBar.click();
        searchBar.sendKeys(productName);
        searchBar.sendKeys(Keys.RETURN);
    }

    public boolean isResultPageDisplayed() {
        return resultPageTitle.isDisplayed();
    }

    public void clickOnFirstProduct() {
        firstProduct.get(0).click();
        switchWindow();
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public boolean isProductAddedToCart() {
        return addToCartSuccessMessage.isDisplayed();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void clickToAddQuantity() {
        addTheQuantity.click();
    }

    public boolean isQuantityUpdated() {
        return quantityUpdated.isDisplayed();
    }

    public void removeProduct() {
        removeLink.click();
        removeButton.click();
    }

    public boolean isProductSuccessfullyRemoved() {
        return productRemovedMessage.isDisplayed();
    }

    public void clickOnGetShoppingButton() {
        getShoppingButton.click();
    }

    public boolean isSSBeautyHomePageDisplayed() {
        return ssBeautyLogo.isDisplayed();
    }
}
