Feature: Validate My Account functionality

  Background:
    Given user opens the website
    Then verify user is on home page
    When user clicks on the store icon

    Scenario: Verify the stores of a city can be displayed and printed on console
      Then verify user is on store page
      When user selects a city under Stores section
      Then display the names of stores onto the console

    Scenario: Verify the Gift Card functionality
      When user clicks on Gift Card link
      Then verify user is on gift card page
      When user clicks on the first gift card
      And user clicks on ADD TO BAG
      And user fills all the details and clicks on PROCEED
      Then verify the product is successfully added to the bag
      When user clicks on the remove button indicated by a cross sign
      And user clicks on the REMOVE button
      Then verify the bag is empty

    Scenario: Verify the First Citizen Club membership functionality
      When user clicks on the First Citizen Club link
      Then verify user is on membership page
      When user clicks on the Buy Now button of the first card
      And user clicks on the plus sign to read the description
      And user clicks on ADD TO BAG button
      Then verify the product is added to the bag
      When user clicks on VIEW BAG
      And user clicks on the cross mark to remove card from bag
      And user clicks on the REMOVE button
      Then verify the bag is empty
      When user clicks on GO TO SHOPPING
      Then verify user is in home page

    Scenario: Verify the Logout functionality
      When user clicks on the Logout link
      Then verify user gets the logout alert
      When user clicks on the "YES,LOG OUT" button
      Then verify user is successfully logged out

