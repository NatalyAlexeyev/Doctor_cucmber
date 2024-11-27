Feature: Portfolio

  Background:
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    Then Check that the home page title is displayed
    Then The user clicks on the Portfolio
    Then Check that the title Meine Leistungen is displayed

  @Infusionstherapie
  Scenario: Check that "Infusionstherapie" is displayed on home page
    When The user clicks on the Infusionstherapie
    Then Check that the title Infusionstherapie is displayed
   # And The user closes the browser
  @Neuraltherapie
  Scenario: Check that "Neuraltherapie" is displayed on home page
    When The user clicks on the Neuraltherapie
    Then Check that the title Neuraltherapie is displayed

  @Schrüpftherapie
  Scenario: Check that "Schrüpftherapie" is displayed on home page
    When The user click on the Schröpftherapie
    Then Check that Schrüpftherapie is displayed

  @Phytotherapie
  Scenario: Check that "Phytotherapie" is displayed on home page
    When The user click on the Phytotherapie
    Then Check that Phytotherapie is displayed

  @Aromatherapie
  Scenario: Check that "Aromatherapie" is displayed on home page
    When The user click on the Aromatherapie
    Then Check that Aromatherapie is displayed

  @Ernährungsberatung
  Scenario: Check that "Ernährungsberatung" is displayed on home page
    When The user click on the Ernährungsberatung
    Then Check that Ernährungsberatung is displayed

  @Labordiagnostik
  Scenario: Check that "Labordiagnostik" is displayed on home page
    When The user click on the Labordiagnostik
    Then Check that Labordiagnostik is displayed
