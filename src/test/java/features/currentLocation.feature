Feature: Current Location
  As a user
  I want to use the current location option
  So that I can see the weather of my current city

  @smoke
  Scenario: Verify Current Location Label
    Given The main page is opened
    When  I click on search field
    Then  the Use your current location label is displayed
    And   I click on current location button
    Then  the city weather page header contains city name "Wari"
