Feature: User Registration

  Background:
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    And The user clicks on the Login button
    And Check that the Login page title is displayed
    Then The user clicks on the Kontoerstellen button
    Then Check that the Konto erstellen page title is displayed

  @Registration
  Scenario: Successful user register
    When The user enters valid details
    Then The user clicks the Weiter button
    Then The user is redirected to the home page
    And The user verifies that the Account button is displayed

  @InvalidPassword
  Scenario Outline: Unsuccessful user registration with invalid details
    And The user enters invalid details and invalid password
      | vorname   | nachname   | email   | telefonnumer   | password   |
      | <vorname> | <nachname> | <email> | <telefonnumer> | <password> |
    Then The user clicks the Weiter button
    And The user checks the display of an unsuccessful registration message "<message>"
    Examples:
      | vorname | nachname   | email          | telefonnumer | password | message                                              |
      | Max     | Mustermann |                | 1234567890   | 12345678 | Passwords must have at least one lowercase ('a'-'z') |
      | Natalya | Alex       | Milka@gmx.test | 017647056276 | milkacat | This user already exists                             |


    @UsercliksAnmelden
    Scenario: User decides to cancel registration and logs in instead
      When The user enters valid details
      And The user clicks on the Anmelden link
      Then The user is redirected to the Login page
      When The user logs in with random valid credentials
      Then The user enters Angemeldet bleiben
      And The user clicks on the Anmelden button