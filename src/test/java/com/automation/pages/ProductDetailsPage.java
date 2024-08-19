package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//div[text()='Select Size']//following-sibling::span")
    WebElement sizeChartElement;

    @FindBy(xpath = "//div[contains(@class,'rounded-full border border-black')]")
    WebElement chooseSizeOptions;

    @FindBy(xpath = "//button[@type='button']//img[@class='size-8 cursor-pointer']")
    WebElement closeButton;

    @FindBy(xpath = "//div[text()='Product added to your cart successfully'] ")
    WebElement successMessage;

    @FindBy(xpath = "//img[@class='w-full' and @alt='minus']")
    WebElement removeMinusIcon;

    public void clickSizeChart() {
        sizeChartElement.click();
    }

    public void chooseSize() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", chooseSizeOptions);
    }

    public void clickCloseBtn() {
        closeButton.click();
    }

    public void clickProductAddToBag() {
        productAddToBag();
    }

    public String productAddedSuccessfully() {
        return successMessage.getText();
    }

    public void clicksRemoveIcon() {
        removeMinusIcon.click();
    }

    public String isProductRemovedSuccessfully() {
        return productRemovedSuccessfully();
    }
}
