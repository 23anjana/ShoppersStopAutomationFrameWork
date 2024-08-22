package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StyleHubPage extends BasePage {

    // *** Women's Fashion paths ***

    @FindBy(id = "site-logo")
    WebElement styleHubLogo;

    @FindBy(xpath = "//span[text()='Women’s Fashion']")
    WebElement womenFashionLink;

    @FindBy(xpath = "//span[text()='Style Guide']")
    WebElement styleGuideLink;

    @FindBy(xpath = "//div[@data-title='Loading ...']")
    List<WebElement> firstGuideLink;

    @FindBy(xpath = "(//h3[@class='entry-title']/a)[1]")
    WebElement guideTitle;

    // Finding element using css selector
    @FindBy(css = ".entry-header.clr")
    WebElement guideDescriptionPage;

    @FindBy(xpath = "//span[@class='breadcrumb-home has-icon']/ancestor::span[@itemprop='name']")
    WebElement homeIcon;

    // *** Watches paths ***

    @FindBy(xpath = "//span[text()='Watches']")
    WebElement watchesLink;

    @FindBy(xpath = "(//div[@data-title='Loading ...']//h3/a)[1]")
    WebElement watchesGuideTitle;

    // *** Search bar methods ***

    // Finding element using css selector
    @FindBy(css = ".search-toggle-li")
    WebElement searchIcon;

    // Finding element using id
    @FindBy(id = "ocean-search-form-1")
    WebElement searchBar;

    @FindBy(xpath = "//span[@class='breadcrumb-search']/ancestor::span[@itemprop='name']")
    WebElement resultPageTitle;

    @FindBy(id = "content")
    List<WebElement> resultLink;

    // *** Women's Fashion methods ***

    public boolean isStyleHubPageDisplayed() {
        return styleHubLogo.isDisplayed();
    }

    public void clickOnFirstGuide() {
        Actions action = new Actions(driver);
        action.moveToElement(womenFashionLink).build().perform();
    }

    public void clickOnStyleGuideLink() {
        styleGuideLink.click();
    }

    public boolean isStyleGuidePageDisplayed() {

        // Get the title of the guide
        String guideName = guideTitle.getText();

        // Checks if the title contains the keyword "Guide"
        return guideName.contains("Guide");
    }

    public void clickOnFirstStyleGuideLink() {
        firstGuideLink.get(0).click();
    }

    public boolean isGuideDescriptionPageDisplayed() {
        return guideDescriptionPage.isDisplayed();
    }

    public void clickOnHomeIcon() {
        homeIcon.click();
    }

    // *** Watches methods ***

    public void clickOnWatchesLink() {
        watchesLink.click();
    }

    public boolean isWatchesGuidePageDisplayed() {

        // Gets the title of the guide
        String watchesGuideName = watchesGuideTitle.getText();

        // Checks if the title contains the keyword "Watch"
        return watchesGuideName.contains("Watch");
    }

    public void clickOnFirstWatchGuideLink() {
        firstGuideLink.get(0).click();
    }

    // *** Search bar methods ***

    public void search(String keyword) {
        searchIcon.click();
        searchBar.sendKeys(keyword);
        searchBar.sendKeys(Keys.ENTER);
    }

    public boolean isResultPageDisplayed() {
        return resultPageTitle.isDisplayed();
    }

    public void clickOnFirstSearchResultLink() {
        resultLink.get(0).click();
    }
}
