Feature: Validate The Beauty Stop page functionality

  Background:
    Given user opens the website
    When user clicks on style hub link
    Then verify user is on style hub page
    When user clicks on The Beauty Shop link

  Scenario: Verify product page is displayed
    When user selects the product from category list
    Then verify the result page is displayed

  Scenario: Verify a product can be added to bag
    When user searches for "conditioner"
    Then verify the result page is displayed
    When user clicks on the first product
    And user clicks on ADD TO CART button
    Then verify the product is successfully added to cart
    When user clicks on cart icon
    And user clicks on the plus sign to add the product quantity
    Then verify quantity is successfully updated
    When user clicks on remove button
    Then verify product is removed from the cart
    When user clicks on GO SHOPPING button
    Then verify user is on SSBeauty home page