Feature: goods are on price bounds after price filter applying

  Scenario Outline: user moves price filter slider and goods on page measure up to the price bounds
    When  user sends a request in the search form "<request>"
    And moves right price filter slider point "<xOffsetRight>" "<yOffsetRight>"
    And moves left price filter slider point "<xOffsetLeft>" "<yOffsetLeft>"
    And click confirm button
    Then goods on page are on bounds "<goodsOrdinalNumber>"

    Examples:
      | request    | goodsOrdinalNumber | xOffsetRight | yOffsetRight | xOffsetLeft | yOffsetLeft |
      | Велосипед  | 4                  | -80          | 0            | 2           | 0           |
      | Шкаф       | 1                  | -100         | 0            | 1           | 0           |
      | Машина     | 3                  | -90          | 0            | 1           | 0           |
      | Кроссовки  | 1                  | -150         | 0            | 1           | 0           |
      | Куртка     | 1                  | -130         | 0            | 0           | 0           |
      | Клавиатура | 3                  | -140         | 0            | 1           | 0           |
