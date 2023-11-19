@Test_BDD_SCRIPT
Feature: Foodics amazon script
  @HomeScreen
  Scenario Outline: validate amazon welcome screen
    Given I navigated to "<amazon_url>"
    Then I should validate amazon welcome screen

    Examples:
      | amazon_url          |
      | https://www.amazon.eg/?language=en_AE |

    @allMenu
  Scenario Outline: validate all screen
    Given I navigated to "<amazon_url>"
    Then I should validate amazon welcome screen
    And I Click on all icon
    Then I should validated that all menu opened successfully

      Examples:
        | amazon_url          |
        | https://www.amazon.eg/?language=en_AE |


 @videoGame
  Scenario Outline: validate video game screen
    Given I navigated to "<amazon_url>"
    Then I should validate amazon welcome screen
    And I Click on all icon
    Then I should validated that all menu opened successfully
    When I click on video games element
    Then I should be navigated dto video game screen

    Examples:
      | amazon_url          |
      | https://www.amazon.eg/?language=en_AE |

@VideoGameFilter
    Scenario Outline: video game screen filtering
      Given I navigated to "<amazon_url>"
      Then I should validate amazon welcome screen
      And I Click on all icon
      Then I should validated that all menu opened successfully
      When I click on video games element
      Then I should be navigated dto video game screen
      When I filter screen with free shipping and with new from condition filter
      Then I Should validate That Filter done successfully

      Examples:
        | amazon_url          |
        | https://www.amazon.eg/?language=en_AE |


    Scenario Outline:
      Given I navigated to "<amazon_url>"
      Then I should validate amazon welcome screen
      And I Click on all icon
      Then I should validated that all menu opened successfully
      When I click on video games element
      Then I should be navigated dto video game screen
      When I filter screen with free shipping and with new from condition filter
      Then I Should validate That Filter done successfully
      When I open sort menu
      And I sort by price from high to low
      Then I should validate screen after sort

      Examples:
        | amazon_url          |
        | https://www.amazon.eg/?language=en_AE |
