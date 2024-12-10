Feature: Contact

  @Contact
  Scenario: Check that the title is displayed on home page
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    And The user clicks on the Contact link
    And Check that the home page title Contact is displayed
    Then The user enters Kontaktvalid details
    And The user clicks on the Nachricht senden button
    Then Check that the home page title is displayed
