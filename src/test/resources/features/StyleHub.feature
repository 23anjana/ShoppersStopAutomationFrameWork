Feature: Validate style hub functionality

  Background:
    Given user opens the website
    When user clicks on style hub link
    Then verify user is on style hub page

  Scenario: Verify Women's Fashion feature works
    When user clicks on Women's Fashion link
    And user selects the style guide option
    Then verify user is on style guide options page
    When user clicks on the first guide
    Then verify user is on the guide description page
    When user clicks on the home icon
    Then verify user is on style hub page

  Scenario: Verify Watches feature works
    When user clicks on Watches link
    Then verify user is on watch guide
    When user clicks on the first watch guide option
    Then verify user is on the guide description page
    When user clicks on the home icon
    Then verify user is on style hub page

  Scenario: Verify guides can be searched using search bar
    When user searches for "decor ideas" in the search bar
    Then verify user is in the result page
    When user clicks on the first link
    Then verify user is on the guide description page
    When user clicks on the home icon
    Then verify user is on style hub page