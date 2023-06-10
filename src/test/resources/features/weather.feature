@weather
  Feature: converter feature

    @Temperature
    Scenario Outline: convert temperature
      Given I go to "converter" page
      When I click on "<Field>"
      And I set "<From>" to "<To>"
      Then I enter into From field "<Input>" and verify "<Result>" result
      And I wait for 2 sec
      Examples:
        | Field       | From       | To        | Input | Result |
        | Temperature | Fahrenheit | Celsius   | 54    | 12.2   |
        | Weight      | Pound     | Kilogram  | 170   | 77     |
        | Length      | Mile       | Kilometer | 50    | 80.4   |

