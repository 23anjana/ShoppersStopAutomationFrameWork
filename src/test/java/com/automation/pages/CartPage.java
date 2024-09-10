package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//img[@alt='shopping-cart']")
    WebElement bagIcon;

    // Finding element using class name
    @FindBy(className = "cart-header__shadow")
    WebElement cartHeader;

    // Finding path of a list of elements
    @FindBy(xpath = "//span[contains(text(),'₹')]")
    List<WebElement> productOriginalPrices;

    // Finding list of prices
    @FindBy(xpath = "//div[contains(@class,'text-xs font-medium !leading-4 text-black md:text-base')]")
    List<WebElement> priceList;

    // Finding the following sibling
    @FindBy(xpath = "//span[contains(text(),'₹')]/following-sibling::span")
    List<WebElement> discountPercentages;

    @FindBy(xpath = "//div[text()='Total Payable amount']/following-sibling::div")
    WebElement totalPayableAmountOnWeb;

    // Finding the following sibling
    @FindBy(xpath = "//div[text()='Your Total Savings']//following-sibling::div[contains(text(),'₹')]")
    WebElement totalSavingsOnWeb;

    //*** Method ***

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


        for (WebElement p : priceList) {
            if (!p.getText().contains("OFF")) {
                System.out.println("Original Prices :" + p.getText().replace("₹", " "));
                totalItemPriceWithoutDiscount = totalItemPriceWithoutDiscount + Double.parseDouble(p.getText().replace("₹", " "));
            } else {
                for (WebElement price : productOriginalPrices) {
                    System.out.println("Original Prices :" + price.getText().replace("₹", " "));
                    totalItemPriceWithoutDiscount = totalItemPriceWithoutDiscount + Double.parseDouble(price.getText().replace("₹", " "));
                }
            }
        }

        List<Double> discountedPriceList = new ArrayList<>();

        // Calculate price after applying discount offer

        for (int i = 0; i < priceList.size() - 1; i++) {
            double price = 0;
            //Original price
            for (WebElement p : priceList) {
                if (!p.getText().contains("OFF")) {
                    price = Double.parseDouble(p.getText().replace("₹", " "));

                } else {
                    for (WebElement pi : productOriginalPrices) {
                        price = Double.parseDouble(pi.getText().replace("₹", " "));
                    }
                }
            }

            // Discount percentage

            for (WebElement p : priceList) {
                double discount;
                double discountedPrice;
                if (!p.getText().contains("OFF")) {
                    discountedPrice = Double.parseDouble(p.getText().replace("₹", " "));
                } else {
                    discount = Double.parseDouble(discountPercentages.get(i).getText().replaceAll("[^\\d]", ""));
                    discountedPrice = price - (price * (discount / 100));
                }
                String formattedPrice = String.format("%.2f", discountedPrice);
                discountedPriceList.add(Double.valueOf(formattedPrice));

            }
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

        // Verifying if the estimated and displayed amounts match
        return totalPayablePriceOnWeb == totalPayableAmount
                && totalSavingsAmountOnWeb == totalSavings;
    }

}
