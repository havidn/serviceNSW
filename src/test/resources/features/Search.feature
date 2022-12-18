Feature: Search by keyword
  Scenario Outline: Search service center
    Given User already on home page
    And User search for "Apply for a number plate"
    When User click on Locate us button
    Then User redirect to "Find a Service NSW location" page
    And User enter suburb "<suburb>"
    Then Should show service centre name as "<Name>"
    Examples:
    |suburb|Name|
    |Sydney 2000|Marrickville Service Centre|
    |Sydney Domestic Airport 2020|Rockdale Service Centre|