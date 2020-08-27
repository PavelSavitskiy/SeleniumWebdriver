Feature: Check category filtration

  Background:
    Given user navigates to books category
    And user navigates to fantasy sub category
    And enters author name in author filter form and choose first offered result "Кинг"

  Scenario: after user chose author in appropriate filter all the books on page have to have the same author
    Then  search page contains books with author "Кинг"

  Scenario: user can sort the list of goods by "In Stock" filter
    When user checks In Stock filter checkbox
    Then On the page there are only those goods that are in stock.

  Scenario Outline: user can sort the list of goods by price down way
    When user navigates to sort drop down menu
    And chooses price down sorting
    Then goods on page are sorted in sequence from the most expensive to the cheapest "<more expensive>" "<cheaper>"
    Examples:
      | more expensive | cheaper |
      | 2              | 3       |
      | 3              | 4       |