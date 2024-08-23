Feature: Verify Order functionality of Shoppers Stop

  Scenario:Verify user can see correct prices in cart page
    Given user opens the website
    Then  verify user is on home page
    When  user searches for "product.first_name" on search bar
    Then  verify searched product page is displayed
    When  user choose  product and preferred size of the first product
    And   user clicks on ADD TO BAG button option
    And   user clicks on close button
    Then  verify user added first product successfully into the bag
    When  user searches for "product.second_name" on search bar
    Then  verify second product page is displayed
    When  user choose first product from the second product result page
    And   user clicks on ADD TO BAG button option
    And   user clicks on close button
    Then  verify user added first product successfully into the bag
    When  user clicks on bag icon
    Then  verify user is on cart page
    And   verify item prices display correctly on cart page








