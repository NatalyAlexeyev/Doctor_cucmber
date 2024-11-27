Feature: User Anmelden

  Background:
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    Then The user clicks on the Login button
    And Check that the Login page title is displayed

  @Login
  Scenario: Successful user login
    When The user logs in with random valid credentials
  #  When The user enters valid data
    Then The user enters Angemeldet bleiben
    And The user clicks on the Anmelden button
    Then The user is redirected to the home page
    And The user verifies that the Account button is displayed

  @InvalidPassword
  Scenario Outline: Unsuccessful user login
    And The user enters valid email and invalid password
      | email   | password   |
      | <email> | <password> |
    Then The user enters Angemeldet bleiben
    And The user clicks on the Anmelden button
    Then The user checks the display of a unsuccessful login message
    Examples:
      | email          | password |
      | Milka@gmx.test | milkacaT |
      | Milka@gmx.test | 12345678 |
      | Milka@gmx.test | milkaca! |
      | Milka@gmx.test | milkaca@ |
