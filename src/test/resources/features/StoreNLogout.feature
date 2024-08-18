Feature: Validate Stores & Events and logout functionalities\

  Background:
    Given user opens the website
    Then verify user is on home page
    When user clicks on the store icon

    Scenario: Verify the stores of a city can be displayed and printed on console
      Then verify user is on store page
      When user selects a city under Stores section
      Then display the names of stores onto the console

    Scenario: Verify the Logout functionality
      When user clicks on the Logout link
      Then verify user gets the logout confirm button
      When user clicks on the logout confirm button
      Then verify user is successfully logged out

