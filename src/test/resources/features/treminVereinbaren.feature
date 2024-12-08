Feature: Termin Vereinbar

  Background:
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
   # And The user clicks on the Termin Vereinbar button
   # And Check that title Timeslots  is displayed

  @TerminVereinbarenneuuser
  Scenario: TerminVereinbaren fur nue user
    And The user clicks on the Termin Vereinbar button
    #And Check that title Timeslots  is displayed
    Then The user chooses the service Infusionstherapie
    And The user selects the termin date with index 1
    And The user selects the termin time with index 0
    #And The user selects date 0 and timeslot 1
      #And User selects the termin date
    #And User selects the termin time
    And  The user confirms the appointment
    Then The user checks the display info message "Bitte melden Sie sich an, um fortzufahren."
    And The user clicks on the Schliessen button

  @TerminVereinbarenessage
  Scenario: The user does not select the service
    And The user clicks on the Termin Vereinbar button
    Then The user chooses the service Infusionstherapie
    And User selects the termin date
    And User selects the termin time
    And The user selects the service
    And  The user confirms the appointment
    Then The user checks the display info message "Bitte wählen Sie eine Dienstleistung aus"
    And The user clicks on the Schliessen button

  @RandomAppointment
  Scenario: Select a service, random date, and time, and book an appointment
    Then The user clicks on the Login button
    When The user logs in with random valid credentials
    And The user clicks on the Anmelden button
    Then The user is redirected to the home page
    And The user clicks on the Termin Vereinbar button
    And Check that title Timeslots  is displayed



