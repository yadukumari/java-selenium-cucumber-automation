@ups
Feature: UPS feature
  @ups1
  Scenario: E2E UPS Scenario
    Given I go to "ups" page oop
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    And I "Confirm" residential address
    Then I verify origin shipment fields submitted
    When I fill out destination shipment fields
    When I submit the shipment form
    And I wait for 6 sec
    And I "Confirm" residential address
    And I set packaging type and weight
    When I submit the shipment form
    Then I verify total charges appear
    And I select cheapest delivery option
    And I wait for 5 sec



    