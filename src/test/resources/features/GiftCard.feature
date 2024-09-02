Feature: Validate Gift Card functionality of Shoppers Stop

  Scenario: Verify the Gift Card functionality
    Given user opens the website
    Then verify user is on home page
    When user clicks on the store icon
    When user clicks on Gift Card link
    Then verify user is on gift card page
    When user clicks on the first gift card
    And user clicks on ADD TO BAG
    And user fills all the details and clicks on PROCEED
    Then verify the product is successfully added to the bag
    When user clicks on the remove
    Then verify remove message "remove.message" displayed
