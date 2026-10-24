Feature: Search

  Background: Navigate to home page
    Given user is on the home page

  @Search
  Scenario: Search for product, multiple results
    When I search for product "hammer"
    Then I verify that product "Claw Hammer with Shock Reduction Grip" is displayed
    Then I verify that product "Claw Hammer with Fiberglass Handle" is displayed
    Then I verify that product "Court Hammer" is displayed
    Then I verify that product "Thor Hammer" is displayed
    Then I verify that the following products are displayed:
      | Product                               | Price |
      | Claw Hammer with Shock Reduction Grip | 13.41 |
      | Claw Hammer with Fiberglass Handle    | 20.14 |
      | Court Hammer                          | 18.63 |
      | Thor Hammer                           | 11.14 |
    Then I verify that the following products are displayed POJO:
      | Product                               | Price |
      | Claw Hammer with Shock Reduction Grip | 13.41 |
      | Claw Hammer with Fiberglass Handle    | 20.14 |
      | Court Hammer                          | 18.63 |
      | Thor Hammer                           | 11.14 |

  @Search
  Scenario: Search for product, single result
    When I search for product "Thor Hammer"
    Then I verify that product "Thor Hammer" is displayed

  @Search
  Scenario: Search for product, no results
    When I search for product "abcdefg"
    #Then I verify that product "hammer" is displayed

  @Search
  Scenario Outline: Search for product and verify it is displayed
    When I search for product "<productName>"
    Then I verify that product "<productName>" is displayed

    Examples:
    | productName |
    | Combination Pliers |
    | Long Nose Pliers   |
