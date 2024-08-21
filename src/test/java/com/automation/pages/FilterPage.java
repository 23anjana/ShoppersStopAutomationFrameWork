package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterPage extends BasePage {

    // Define the XPath for locating brand buttons. The '%s' will be replaced with the actual brand name.
    String xpathForBrand = "//button[text()='%s']";

    public void clicksOnBrand(String brand) {

        // Format the XPath with the provided brand name
        String formattedXpathForCategory = String.format(xpathForBrand, brand);

        // Locate the brand button element using the formatted XPath
        WebElement elementClick = driver.findElement(By.xpath(formattedXpathForCategory));
        elementClick.click();
    }

    public boolean isProductPageBasedOnBrandsDisplayed(String key) {
        // Define the XPath expression to locate product brand names. The '%s' will be replaced with the actual brand name.
        String xpath = "//div[contains(@class,'text-ssBlack dark:text-white') and text()='%s'] ";

        // Perform scroll operation until all products are loaded
        scroll();

        // Map the text of each element to a list
        List<String> brandList = driver.findElements(By.xpath(String.format(xpath, key.toUpperCase()))).stream().map(WebElement::getText).toList();
        System.out.println(brandList);

        // Initialize a flag to indicate whether all brand names match the expected brand name
        boolean flag = true;

        // Iterate through the list of brand names
        for (String brand : brandList) {
            if (!brand.equals(key.toUpperCase())) {
                flag = false;
            }
        }
        return flag;
    }

}
