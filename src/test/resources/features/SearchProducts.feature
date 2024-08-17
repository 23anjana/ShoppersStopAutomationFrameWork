Feature: Validate search functionality of Shoppers Stop

  Background:
    Given user opens the website
    Then verify user is on home page

  Scenario: Verify user can search product through search bar
    When user enters "Perfumes" in the search bar
    Then verify result page is displayed

  Scenario: Verify user can search product from the TRENDING SEARCH section
    When user clicks on the search bar
    And clicks the first product under the section
    Then verify the product result page is displayed

  Scenario: Verify user can search product by brand
    When user clicks on the search bar
    And clicks the first brand under the POPULAR BRAND section
    Then verify products of a particular brand are displayed
