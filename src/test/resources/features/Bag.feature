Feature: Validate ADD TO BAG and REMOVE To Bag functionality of Shoppers Stop

  Scenario: Verify user can add product into bag
    Given user opens the website
    Then  verify user is on home page
    When  user searches for "product.name" on search bar
    Then  verify search result page is displayed
    When  user choose first product from result page
    And   user clicks on ADD TO BAG button option
    Then  verify user added product successfully to the bag