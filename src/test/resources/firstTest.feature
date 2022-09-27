Feature: Web Amazon Search

  @Chrome
  Scenario: Search a product in amazon
    Given the user open amazon web page
    When the user searches "Pokemon" on amazon
    And hits submit
    Then the user see the different products

    @Edge
  Scenario Outline: Search list of products in amazon
    Given the user open amazon web page
    When the user entered the <word> on amazon
    And hits submit
    Then the user see the different products
    Examples:
      | word |
      | Pokemon |
      | Digimon |
      | Yi-Gi-Oh |


#    Cucumber tags, hooks