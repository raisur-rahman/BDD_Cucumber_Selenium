Feature: Search City
  As a user
  I want to search for cities
  So that I can see the weather of the city

  @smoke @regression
  Scenario: Search for New York
    Given The main page is opened
    And   I click on search field
    When  I input "New York" in the search field
    Then  the search results list is displayed
    When  I click on the first search result
    Then  the city weather page header contains city name "New York"
