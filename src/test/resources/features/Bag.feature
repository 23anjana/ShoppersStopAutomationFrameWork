Feature: Validate ADD TO BAG and REMOVE To Bag functionality of Shoppers Stop

  Scenario: Verify user can add and remove product from bag
    Given user opens the website
    Then  verify user is on home page
    When  user searches for "product.name" on search bar
    Then  verify search result page is displayed
    When  user choose first product from result page
    And   user choose the preferred size from size chart
    And   user clicks on close button
    And   user clicks on ADD TO BAG button option
    Then  verify user added product successfully to the bag
    When  user clicks on close button
    And   user remove product from bag
    Then  verify product is removed successfully from bag




