Feature: Account

  Background:
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    Then The user clicks on the Login button
    And Check that the Login page title is displayed
    When The user logs in with random valid credentials
      #The user enters valid data
    Then The user enters Angemeldet bleiben
    And The user clicks on the Anmelden button
    Then The user is redirected to the home page
    And The user verifies that the Account button is displayed
    Then The user clicks on the Account

  @Logout
  Scenario: Logout
    When The user clicks on the Logout
    And The user verifies that the Login button is displayed

  @ProfileVorNaname
  Scenario: Profile Vorname
    When The user clicks on the Profile
    And The user is redirected to the Profile page
    Then The user enters Vorname
    And The user clicks Speichern
    And  The user checks the display of successful enters message
    Then The user clicks Start Bootstrap
    When The user opens the gesundheitspraxis home page
    Then Check that the home page title is displayed
  @ProfileNachNaname
  Scenario: Profile Nachname
    When The user clicks on the Profile
    And The user is redirected to the Profile page
    Then The user enters Nachname
    And The user clicks Speichern
    And  The user checks the display of successful enters message
    Then The user clicks Start Bootstrap
    When The user opens the gesundheitspraxis home page
    Then Check that the home page title is displayed
  @ProfileTelefonnummer
  Scenario: Profile Telefonnummer
    When The user clicks on the Profile
    And The user is redirected to the Profile page
    Then The user enters Telefonnummer
    And The user clicks Speichern
    And  The user checks the display of successful enters message
    Then The user clicks Start Bootstrap
    When The user opens the gesundheitspraxis home page
    Then Check that the home page title is displayed



