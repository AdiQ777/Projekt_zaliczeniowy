Feature: New account address
  Scenario Outline: adding new address to account
    Given user is on the CodersLab MyStore main paige
    When user clicks SignIn button
    And fill "z.kowalczyk@mail.pl" and "qwerty" and click SingIn button on login page
    Then is logged successfully into account
    When logged user clicks AddFirstAddress button
    And fills user address data '<Alias>', '<Address>', '<Zip.PostalCode>', '<City>', '<Country>' and clisks Save button
    Then new address is added to account with proper data '<Alias>', '<Address>', '<Zip.PostalCode>', '<City>' and '<Country>'

    Examples:
    |Alias   |Address   |Zip.PostalCode |City   |Country        |
    |zenek   |Jurna 8   |00-245         |Londek |United Kingdom |

