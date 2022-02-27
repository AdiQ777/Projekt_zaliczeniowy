Feature: shopping in Presta Shop
  Scenario: item purchase in CodersLab Presta Shop
    Given user is on the main paige CodersLab Presta Shop
    When user login with proper credentials - email 'z.kowalczyk@mail.pl' and password 'qwerty'
    Then user is logged into the account
    Given logged user is on the CodersLab Presta Shop main paige
    When user choose the correct item 'Hummingbird Printed Sweater'
    And select the proper size 'M' and quantity of items '5' and add item to cart
    And go to the checkout page to confirm the address
    And choose correct delivery 'PrestaShop' and payment type 'Pay by Check'
    And confirm the order
    Then the order is placed correctly - screenshot for confirmation
