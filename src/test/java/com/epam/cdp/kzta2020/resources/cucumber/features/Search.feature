Feature: Search goods test

  Scenario Outline: user enter request in search form and goods are visible on th search page
    When  user sends a request in the search form "<request>"
    Then  goods quantity on the page equal certainly quantity "<goods_quantity>"
    Examples:
      | request | goods_quantity |
      | Машина  | 60             |
      | Ручка   | 60             |
      | Кукла   | 60             |