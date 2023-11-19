@Regression
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
      And i should to be able to add all products from specific price
      When i navigate to card screen
      Then i should validate all elements into card
      When i proceed to buy

      Examples:
        | amazon_url          |
        | https://www.amazon.eg/?language=en_AE |
