Feature: Web Amazon Search
  Scenario: Search a product in amazon
    Given the user open amazon web page
    When the user searches "Pokemon" on amazon
    And hits submit
    Then the user see the different products


    #Scenario Outline: Search multiple products on Amazon.
    #examples: Digimon, Pokemon, Yu-Gi-Oh