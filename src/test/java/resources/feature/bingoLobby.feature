Feature: Testing Bingo games API on Virgin games Application

  Scenario: I want to verify response data of the virgin games bingo API
    Given   I am on the Virgin games bingo api
    When    I send Get request to the Lobby feed endpoint
    Then    I get valid status code 200
    And      I verify that the stream name is "Adventure" at streams index 1
