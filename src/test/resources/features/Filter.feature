Feature: Validate filter functionality of Shoppers Stop

  Scenario Outline:Verify user can filter products using brand names
    Given user opens the website
    Then  verify user is on home page
    When  When  user hovers over WOMEN and choose Ethnic Dresses option
    Then  verify  result page is displayed
    When  user clicks on "<brand>" names
    Then  verify products are displayed based on "<brand>"

    Examples:
      | brand         |
      | haute curry   |
      | juniper       |
      | black scissor |
      | myshka        |

