Feature: Validate Filter functionality of Shoppers Stop

  Background:
    Given user opens the website
    Then  verify user is on home page

  Scenario Outline:Verify user can filter products using brand names
    When  user hovers over WOMEN and choose Ethnic Dresses option
    Then  verify  result page is displayed
    When  user clicks on brand "<brand>" names
    Then  verify products are displayed based on "<brand>" brand names

    Examples:
      | brand         |
      | haute curry   |
      | juniper       |
      | black scissor |
      | myshka        |

  Scenario Outline: Verify user can filter product using filter categories
    When  user enters "filter.product_1" in the search bar
    Then  verify result page is displayed
    When  user clicks on categories "<Filters>" under filter options
    And   user search filter option "<Subcategory>" in the filter categories search bar
    And   select the resultant filter option
    Then  verify filtered "<Subcategory>" page is displayed

    Examples:
      |   Filters    |    Subcategory |
      | Categories   |    Indianwear  |
      | Department   |    Women       |
      | Categories   |    Clothing    |

    Scenario: Verify user can clear all applied filters
      When  user enters "filter.product_2" in the search bar
      Then  verify result page is displayed
      When  user clicks on categories "Product Type" under filter options
      And   user search filter option "Chronograph" in the filter categories search bar
      And   select the resultant filter option
      Then  verify filtered "Chronograph" page is displayed
      When  user clicks on clear all option
      Then  verify all applied filters are cleared







