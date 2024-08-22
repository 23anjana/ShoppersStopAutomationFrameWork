package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterPage extends BasePage {

    // Define the XPath for locating brand buttons. The '%s' will be replaced with the actual brand name.
    String xpathForButtons = "//button[text()='%s']";

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement filterSearchBar;

    @FindBy(tagName = "label")
    WebElement searchResult;

    String xpathForFilterOptionName = "//div[text()='%s']";

    @FindBy(xpath = "//span[contains(text(),'Items')] ")
    WebElement totalItems;

    @FindBy(xpath = "//div[text()='Clear All']")
    WebElement clearAllButton;

    double totalNumberItems;
    double numberItemsAfterApplyFilter;
    double numberItemsAfterClear;

    public void clicksOnFilterOptions(String keyName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        totalNumberItems = Double.valueOf(totalItems.getText().replaceAll("[^0-9]", ""));
        System.out.println("Total number of items on first search  :" + totalNumberItems);

        // Format the XPath with the provided key name
        String formattedXpathForCategory = String.format(xpathForButtons, keyName);

        // Locate the key name button element using the formatted XPath
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

    public void searchOnFilterSearchBar(String key) {

        // Click on the filter search bar
        filterSearchBar.click();

        // Inputs the key name want to search
        filterSearchBar.sendKeys(key);
    }

    public void clicksOnSearchResults() {
        searchResult.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        numberItemsAfterApplyFilter = Double.valueOf(totalItems.getText().replaceAll("[^0-9]", ""));
        System.out.println("Total number of items after apply filter :" + numberItemsAfterApplyFilter);

    }

    public String isFilteredPageDisplayed(String filterName) {
        WebElement formattedXpathForFilterOptionName = driver.findElement(By.xpath(String.format(xpathForFilterOptionName, filterName)));

        return formattedXpathForFilterOptionName.getText();
    }

    public void clicksOnClearAllButton() {
        clearAllButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        numberItemsAfterClear = Double.valueOf(totalItems.getText().replaceAll("[^0-9]", ""));
        System.out.println("Total number of items after clearing filter  :" + numberItemsAfterClear);

    }

    public boolean isAppliedFiltersCleared() {
        return  totalNumberItems ==numberItemsAfterClear;
    }
}
