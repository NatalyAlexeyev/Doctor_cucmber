Feature: Leistungen

  Background:
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    Then Check that the home page title is displayed


  @Infusionstherapienewuser
  Scenario: Check that "Infusionstherapie" is displayed on home page new user
    Then The user clicks on the Leisungen
    Then Check that the title Meine Leistungen is displayed
    When The user clicks on the Infusionstherapie
    Then Check that the title Infusionstherapie is displayed
    And  The user clicks on the Termin Vereinbar
    And The user clicks Date
    And The user clicks Time
    And  The user confirms the appointment
    Then The user checks the display info message
    And The user clicks on the Schliessen button

  @Infusionstherapie
  Scenario: Make appointment for Infusionstherapie (existing user)
    Then The user clicks on the Login button
    When The user logs in with random valid credentials
    Then The user enters Angemeldet bleiben
    And The user clicks on the Anmelden button
    And The user verifies that the Account button is displayed
    Then The user clicks on the Leisungen
    Then Check that the title Meine Leistungen is displayed
    When The user clicks on the Infusionstherapie
    Then Check that the title Infusionstherapie is displayed
    And  The user clicks on the Termin Vereinbar
    And The user clicks Date
    And The user clicks Time
    #Then The user clicks a random Date
   # And The user clicks a random Time
    And  The user confirms the appointment
    And The user checks the display infoMessage
