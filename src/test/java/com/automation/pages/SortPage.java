package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPage extends BasePage {

    @FindBy(xpath = "//div[@class='flex justify-between']")
    WebElement scrollUpTo;

    @FindBy(xpath = "//div[@data-item-type='ProdctSCCard']//div//div[contains(@class,'bg-transparent')]//div[contains(text(),'₹')]")
    List<WebElement> priceList;

    @FindBy(xpath = "//div[@class='bg-transparent']//div[contains(text(),'₹')]")
    List<WebElement> priceHighToLowList;

    @FindBy(xpath = "//p[contains(text(),'₹')]/following-sibling::p")
    List<WebElement> discountList;

    public boolean verifyProductDisplayedLowToHigh() {
//        scroll(scrollUpTo);
//        Actions actions=new Actions(driver);
//        actions.scrollToElement(scrollUpTo).pause(1000).build().perform();
        isPresent(scrollUpTo);
        List<String> str1 = new ArrayList<>();

        for (WebElement price : priceList) {
            str1.add(price.getText().replace("₹", ""));
        }
        System.out.println(str1);
        List<String> str2 = new ArrayList<>(str1);

        Collections.sort(str2);
        System.out.println(str2);

        return str1.equals(str2);
    }

    public boolean verifyProductDisplayedHighToLow() {
//        scroll(scrollUpTo);
        List<String> str1 = new ArrayList<>();

        for (WebElement price : priceHighToLowList) {
            str1.add(price.getText().replace("₹", ""));
        }
        System.out.println("Original price list high to low" + str1);

        List<String> str2 = new ArrayList<>(str1);
        Collections.sort(str2);
        System.out.println("Low to high" + str2);

        Collections.reverse(str2);
        System.out.println("High to Low" + str2);

        return str1.equals(str2);
    }

    public boolean verifyProductDisplayedDiscountHighToLow() {
//        scroll(scrollUpTo);
        List<String> str1 = new ArrayList<>();

        for (WebElement discount : discountList) {
            str1.add(discount.getText().split("%")[0]);
        }
        System.out.println(str1);

        List<String> str2 = new ArrayList<>(str1);
        Collections.sort(str2);
        System.out.println(str2);

        Collections.reverse(str2);
        System.out.println(str2);

        return str1.equals(str2);
    }
}
