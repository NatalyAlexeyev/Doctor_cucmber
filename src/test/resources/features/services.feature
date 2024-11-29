Feature: Services

  @Services
  Scenario: Check that the title is displayed on home page
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    And The user clicks on the Services link
    And Check that the home page title Services is displayed