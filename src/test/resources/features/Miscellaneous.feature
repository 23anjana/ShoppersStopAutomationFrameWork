Feature: Validate different features of Shoppers Stop

  Background:
    Given user opens the website
    Then verify user is on home page

  Scenario: Verify that clicking the Up Arrow will scroll the page to the top
    When user scrolls to the bottom of the page and clicks on the Up Arrow
    Then Verify the page is scrolled to the top

  Scenario: Verify user can navigate to multiple pages of a product
    When user enters "miscellaneous.search_1" in the search bar
    Then verify result page is displayed
    When user clicks on the right arrow
    Then verify user is navigated to the desired page
    When user clicks on the left arrow
    Then verify user is navigated to the desired page
    When user clicks on fifth page
    Then verify user is navigated to the desired page

  Scenario: Verify user can check the estimated delivery information
    When user enters "miscellaneous.search_2" in the search bar
    Then verify result page is displayed
    When user clicks on a product displayed
    And user inputs the pin code and clicks on Check button
    Then display the estimation information on to the console

  Scenario: Verify that clicking on website logo navigates user back to home page
    When user enters "miscellaneous.search_2" in the search bar
    Then verify result page is displayed
    When user clicks on the website logo
    Then verify user is on home page

  Scenario: Verify user can select a category present at the bottom of the page
    When user clicks on one of the category
    Then verify user is navigated to the category result page

  Scenario: Verify Help & Support functionality
    When user clicks on Help & Support link
    Then verify user is in Help & Support page
    When user enters "query" in the query search bar
    Then display the result onto the console
    When user clicks on any of the questions displayed
    Then display the result onto the console

  Scenario: Verify user can choose brands in alphabetical order
    When user hovers over "Brands"
    And  user choose letter "brand.letter" under brands name
    And  user chooses a brand staring with letter "brand.letter"
    Then verify product page based on corresponding brand starting with "brand.letter" is displayed
