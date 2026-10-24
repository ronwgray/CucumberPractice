Feature: Work in progress

  @wip
  Scenario: Test
    When I read employee data from CSV file "C:\\Users\\rongr\\Downloads\\test.csv"
    Then I display Employee records alphabetically by first name
    When I read employee data from fixed-length file "C:\\Users\\rongr\\Downloads\\test.fixed"
    Then I display Employee records alphabetically by first name

