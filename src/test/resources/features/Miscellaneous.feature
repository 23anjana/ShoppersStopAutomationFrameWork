Feature: Validate different features of the website

  Background:
    Given user opens the website
    Then verify user is on home page

  Scenario: Verify that clicking the Up Arrow will scroll the page to the top
    When user scrolls to the bottom of the page and clicks on the Up Arrow
    Then Verify the page is scrolled to the top

  Scenario: Verify user can navigate to multiple pages of a product
    When user enters "shoes" in the search bar
    Then verify result page is displayed
    When user clicks on the right arrow
    Then verify user is navigated to the desired page
    When user clicks on the left arrow
    Then verify user is navigated to the desired page
    When user clicks on fifth page
    Then verify user is navigated to the desired page

  Scenario: Verify user can check the estimated delivery information
    When user enters "Hair oil" in the search bar
    Then verify result page is displayed
    When user clicks on the first product displayed
    And user inputs the pin code and clicks on Check button
    Then display the estimation information on to the console

  Scenario: Verify that clicking on website logo navigates user back to home page
    When user enters "Hair oil" in the search bar
    Then verify result page is displayed
    When user clicks on the website logo
    Then verify user is on home page
