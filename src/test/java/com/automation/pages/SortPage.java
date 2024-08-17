package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPage extends BasePage{

    @FindBy(xpath = "//div[text()='Showing results ']")
    WebElement scrollUpTo;

    @FindBy(xpath = "//div[contains(@class,'bg-transparent')]//div[contains(text(),'₹')] ")
    List<WebElement> priceList;

    @FindBy(xpath = "//div[@class='bg-transparent']//div[contains(text(),'₹')]")
    List<WebElement> priceHighToLowList;

    @FindBy(xpath = "//p[contains(text(),'₹')]//following-sibling::p")
    List<WebElement> discountList;

    public void scroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public boolean verifyProductDisplayedLowToHigh() {
        scroll(scrollUpTo);
        List<String> str1=new ArrayList<>();
        for (WebElement i: priceList){
            str1.add(i.getText().replace("₹",""));
        }
        System.out.println(str1);
        List<String> str2=new ArrayList<>(str1);
        Collections.sort(str2);
        System.out.println(str2);
        return str1.equals(str2);
    }

    public boolean verifyProductDisplayedHighToLow() {
        scroll(scrollUpTo);
        List<String> str1=new ArrayList<>();
        for (WebElement i: priceHighToLowList){
            str1.add(i.getText().replace("₹",""));
        }
        System.out.println(str1);
        List<String> str2=new ArrayList<>(str1);
        Collections.sort(str2);
        System.out.println(str2);
        Collections.reverse(str2);
        System.out.println(str2);
        return str1.equals(str2);
    }

    public boolean verifyProductDisplayedDiscountHighToLow() {
        scroll(scrollUpTo);
        List<String> str1=new ArrayList<>();
        for (WebElement i: discountList){
            str1.add(i.getText().split("%")[0]);
        }
        System.out.println(str1);
        List<String> str2=new ArrayList<>(str1);
        Collections.sort(str2);
        System.out.println(str2);
        Collections.reverse(str2);
        System.out.println(str2);
        return str1.equals(str2);
    }
}
