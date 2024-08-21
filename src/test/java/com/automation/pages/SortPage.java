package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPage extends BasePage {

    @FindBy(xpath = "//div[@data-item-type='ProdctSCCard']//div[contains(text(),'₹')]")
    List<WebElement> priceList;

    @FindBy(xpath = "//p[contains(text(),'₹')]/following-sibling::p")
    List<WebElement> discountList;

    public boolean verifyProductDisplayedLowToHigh() {
        // Scroll the page to ensure all product prices are loaded
        scroll();

        // Create a list to store the prices extracted from the web elements
        List<Double> str1 = new ArrayList<>();

        // Iterate over each price element in the priceList and added to the list
        for (WebElement price : priceList) {
            str1.add(Double.valueOf(price.getText().replace("₹", "")));
        }
        System.out.println("Original price list low to high :\n" + str1);

        // Create a copy of the original price list to sort
        List<Double> str2 = new ArrayList<>(str1);

        // Sort the copied list of prices
        Collections.sort(str2);
        System.out.println("Sorted price list low to high :\n" + str2);

        // Compare the original list of prices with the sorted list
        return str1.equals(str2);
    }

    public boolean verifyProductDisplayedHighToLow() {
        // Scroll the page to ensure all product prices are loaded
        scroll();

        // Create a list to store the prices extracted from the web elements
        List<String> str1 = new ArrayList<>();

        // Iterate over each price element in the priceList and added to the list
        for (WebElement price : priceList) {
            str1.add(price.getText().replace("₹", ""));
        }
        System.out.println("Original price price list high to low :\n" + str1);

        // Create a copy of the original price list to sort
        List<String> str2 = new ArrayList<>(str1);

        // Sort the copied list of prices in ascending order
        Collections.sort(str2);
        System.out.println("Sorted list ie,Low to high :\n" + str2);

        // Reverse the sorted list to get it in descending order
        Collections.reverse(str2);
        System.out.println("Reversed list ie,High to Low :\n" + str2);

        // Compare the original list of prices with the reversed sorted list
        return str1.equals(str2);
    }

    public boolean verifyProductDisplayedDiscountHighToLow() {
        // Scroll the page to ensure all product prices are loaded
        scroll();

        // Create a list to store the prices extracted from the web elements
        List<Double> str1 = new ArrayList<>();

        // Iterate over each price element in the priceList and added to the list
        for (WebElement discount : discountList) {
            str1.add(Double.valueOf(discount.getText().split("%")[0]));
        }
        System.out.println("Original price price list high to low :\n" + str1);

        // Create a copy of the original price list to sort
        List<Double> str2 = new ArrayList<>(str1);

        // Sort the copied list of prices in ascending order
        Collections.sort(str2);
        System.out.println("Sorted list ie,Low to high :\n" + str2);

        // Reverse the sorted list to get it in descending order
        Collections.reverse(str2);
        System.out.println("Reversed list ie,High to Low :\n" + str2);

        // Compare the original list of prices with the reversed sorted list
        return str1.equals(str2);
    }
}
