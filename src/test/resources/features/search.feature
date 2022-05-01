@search
Feature: This feature is to test the search functionality of TradeMe application

  As UI test: Query any existing Used Car and validate following details are shown for that car and it matches
  o Number plate
  o Kilometres
  o Body
  o Seats

  @smoke
  Scenario: Search used cars
    Given I am on the TradeMe site
    When I search for '2011 Mercedes-Benz ML 350 CDI' 'used' car
    Then I should see the following labels
      | expected fields |
      | Number Plate    |
      | Kilometers      |
      | Seats           |
      | Body            |

    And The details should match the following data
      | field        | value     |
      | Number Plate | FYH470    |
      | Kilometers   | 140,000km |
      | Seats        | 5         |
      | Body         | RV/SUV    |
