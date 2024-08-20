Feature: Validate Gift Card functionality

  Scenario: Verify the First Citizen Club membership functionality
    Given user opens the website
    Then verify user is on home page
    When user clicks on the store icon
    When user clicks on the First Citizen Club link
    Then verify user is on membership page
    When user clicks on the Buy Now button of the first card
    And user clicks on the plus sign to read the description
    And user clicks on ADD TO BAG button
    When user clicks on VIEW BAG and removes card from bag
    Then verify the bag empty message "Product removed from your cart successfully" displayed
    When user clicks on GO TO SHOPPING
    Then verify user is in home page