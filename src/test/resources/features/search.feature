Feature: Search

  Background: Navigate to home page
    Given user is on the home page

  @Regression
  Scenario: Search for product, multiple results
    When I search for product "hammer"
    Then I verify that "Claw Hammer with Shock Reduction Grip" card is displayed
    Then I verify that "Claw Hammer with Fiberglass Handle" card is displayed
    Then I verify that "Court Hammer" card is displayed
    Then I verify that "Thor Hammer" card is displayed

  Scenario: Search for product, single result
    When I search for product "Thor Hammer"
    Then I verify that "Thor Hammer" card is displayed

  Scenario: Search for product, no results
    When I search for product "abcdefg"
    Then I verify that "hammer" card is displayed
