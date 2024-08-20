package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//img[@alt='shopping-cart']")
    WebElement bagIcon;

    @FindBy(className = "cart-header__shadow")
    WebElement cartHeader;

    @FindBy(xpath = "//span[contains(text(),'₹')]")
    List<WebElement> productOriginalPrices;

    @FindBy(xpath = "//span[contains(text(),'₹')]/following-sibling::span")
    List<WebElement> discountPercentages;

    @FindBy(xpath = "//div[text()='Total Payable amount']/following-sibling::div")
    WebElement totalPayableAmountOnWeb;

    @FindBy(xpath = "//div[text()='Your Total Savings']//following-sibling::div[contains(text(),'₹')]")
    WebElement totalSavingsOnWeb;

    public void clickBagIcon() {
        bagIcon.click();
    }

    public boolean isCartPageDisplayed() {
        return cartHeader.isDisplayed();
    }

    public boolean isFinalPriceIsMatchingWithItemTotalPrice() {
        double totalItemPriceWithoutDiscount = 0;
        double totalPayableAmount = 0;
        double totalSavings;

        // Calculating Original price without adding discount
        for (WebElement price : productOriginalPrices) {
            System.out.println("Original Prices :" + price.getText().replace("₹", " "));
            totalItemPriceWithoutDiscount = totalItemPriceWithoutDiscount + Double.parseDouble(price.getText().replace("₹", " "));
        }
        System.out.println("Total price without discount: " + totalItemPriceWithoutDiscount);

        List<Double> discountedPriceList = new ArrayList<>();

        // Calculate price after applying discount offer
        for (int i = 0; i < productOriginalPrices.size(); i++) {
            //Original price
            double price = Double.parseDouble(productOriginalPrices.get(i).getText().replace("₹", " "));

            // Discount percentage
            double discount = Double.parseDouble(discountPercentages.get(i).getText().replaceAll("[^\\d]", ""));

            double discountedPrice = price - (price * (discount / 100));
            String formattedPrice = String.format("%.2f", discountedPrice);
            discountedPriceList.add(Double.valueOf(formattedPrice));
        }
        System.out.println("Discounted Price List: " + discountedPriceList);

        // Total Payable Amount after apply discount
        for (Double payableAmount : discountedPriceList) {
            totalPayableAmount = totalPayableAmount + payableAmount;
        }
        System.out.println("Total Payable amount Calculated: " + totalPayableAmount);

        // Total savings amount = Total original amount - Total amount payable
        totalSavings = totalItemPriceWithoutDiscount - totalPayableAmount;
        System.out.println("Total Savings Amount Calculated: " + totalSavings);

        // Total payable amount on web
        double totalPayablePriceOnWeb = Double.parseDouble(totalPayableAmountOnWeb.getText().replace("₹", "").replace(",", ""));
        System.out.println("Total Payable amount on Web: " + totalPayablePriceOnWeb);

        // Total Savings Amount on web
        double totalSavingsAmountOnWeb = Double.parseDouble(totalSavingsOnWeb.getText().replace("₹", "").replace(",", ""));
        System.out.println("Total Savings Amount on Web: " + totalSavingsAmountOnWeb);

        return totalPayablePriceOnWeb == totalPayableAmount
                && totalSavingsAmountOnWeb == totalSavings;
    }

}