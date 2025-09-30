Feature: Recent Locations
  As a user
  I want to use the recent location options
  So that I can see the weather of the recent city

  @regression
  Scenario: Verify Recent Locations
    Given  The main page is opened
    When   I input "London" in the search field
    And    I click on the first search result
    When   I go back to the main page
    Then   the recent location result is displayed
    And    I click on the first result in the recent location result
    Then   the city weather page header contains city name "London"
