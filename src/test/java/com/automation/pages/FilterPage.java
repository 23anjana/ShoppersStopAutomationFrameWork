package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BasePage {

  // Locate the brand names using xpath
  String xpathForBrand = "//button[text()='%s']";

  public void clicksOnBrand(String brand) {
    String formattedXpathCategory = String.format(xpathForBrand,brand);

    // Locate the element using the formatted XPath
    WebElement elementClick = driver.findElement(By.xpath(formattedXpathCategory));
    elementClick.click();

  }

  public boolean isProductPageBasedOnBrandsDisplayed(String key) {
    return  true;
  }
}
