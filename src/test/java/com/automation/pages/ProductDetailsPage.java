package com.automation.pages;

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

    //*** Methods ***

    public void clickSizeChart() {
        sizeChartElement.click();
    }

    public void chooseSize() {
        waitForElementToBeClickable(chooseSizeOptions);
        clickUsingJavaScriptExecutor(chooseSizeOptions);
    }

    public void clickCloseButton(){
        closeButton.click();
    }

    public String productAddedSuccessfully() {

        // Prints the message on successful addition of product to bag
        System.out.println(successMessage.getText());
        return successMessage.getText();
    }

    public void clicksRemoveIcon() {

        // Removes the product from the bag
        removeMinusIcon.click();
    }

}
