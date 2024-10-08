Feature: Validate Sorting functionality of Shoppers Stop

  Background:
    Given user opens the website
    Then  verify user is on home page
    When  user hovers over MAN  and choose Shirts option
    Then  verify  product page is displayed
    When  user clicks on sort button

  Scenario: Verify user can sort products based on price low to high
    And   user choose the price low to high sort option
    Then  verify product displayed is in sorted order by price low to high

  Scenario: Verify user can sort products based on price high to low
    And   user choose the price high to low sort option
    Then  verify product displayed is in sorted order by price high to low

  Scenario: verify user can sort products based on Discount
    And   user choose the Discount option
    Then  verify products with highest to lowest discounts are displayed
