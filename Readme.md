# Doctor

## Website Overview
The website gesundheitspraxis-wertvoll.de is a platform for a medical clinic that allows users to book appointments, manage their profiles, and access information about services. The service simplifies appointment scheduling and ensures access to essential information.

## Project Overview
Doctor is a test automation project for the gesundheitspraxis-wertvoll.de website. It validates functionalities such as appointment booking, user registration, login, navigation, and the contact form using Cucumber, Selenium, and Java.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Setup](#project-setup)
- [Running Tests](#running-tests)
- [Test Scenarios](#test-scenarios)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

This project automates the testing of various functionalities on the `gesundheitspraxis-wertvoll.de` website, such as:

- Booking appointments
- Registration and login
- Viewing and managing appointments
- Contact form validation

It uses BDD (Behavior-Driven Development) with Cucumber to write feature files and step definitions in Java.

---

## Features

- Automated browser testing with Selenium.
- BDD-style scenarios using Cucumber.
- Modular Page Object Model (POM) for maintainable test code.
- Support for multiple browsers via WebDriverManager.
- Integrated with JUnit for running tests and generating reports.

---

## Technologies Used

- **Java**: Core programming language.
- **Cucumber**: For writing test scenarios.
- **Selenium WebDriver**: For browser automation.
- **JUnit**: For running tests.
- **Gradle**: Build automation tool.
- **WebDriverManager**: Simplifies WebDriver setup.

---

## Project Setup

### Prerequisites

1. Install Java 11 or later.
2. Install [Gradle](https://gradle.org/).
3. Clone the repository:

   ```bash
   git clone https://github.com/NatalyAlexeyev/Doctor_cucmber.git
   cd Doctor_cucmber
   ```

### Configure the Project

1. Ensure the `build.gradle` file has all required dependencies:

   ```groovy
   dependencies {
       implementation 'org.seleniumhq.selenium:selenium-java:4.26.0'
       implementation 'io.cucumber:cucumber-java:7.18.1'
       implementation 'io.cucumber:cucumber-junit:7.18.1'
       implementation 'io.github.bonigarcia:webdrivermanager:5.9.2'
       testImplementation 'org.junit.jupiter:junit-jupiter-api:5.10.0'
       testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.10.0'
   }
   ```

2. Sync the dependencies using Gradle:

   ```bash
   gradle build
   ```

3. Configure your `features` directory under `src/test/resources` to contain the Cucumber feature files.

---

## Running Tests

To run tests with specific tags or scenarios, use the following commands:

1. **Run all tests**:

   ```bash
   gradle clean test
   ```

2. **Run tests with specific tags**:

   ```bash
   gradle clean test -Dcucumber.filter.tags="@tagName"
   ```

3. **Generate reports**:
   Add the `CucumberOptions` plugin for reports:

   ```java
   @CucumberOptions(
       plugin = {"pretty", "html:target/cucumber-reports.html"},
       features = "src/test/resources/features",
       glue = "doctor.stepsDefinitions"
   )
   ```

   After running tests, check the `target/cucumber-reports.html` file for detailed reports.

---

## Test Scenarios

Feature files are located in the `src/test/resources/features` directory and include:

- **Login**: Verifies user login functionality.
- **Registration**: Tests user registration.
- **Appointment Booking**: Automates appointment scheduling.
- **Contact Form**: Validates contact form submission.
- **Navigation**: Checks navigation between pages.

Example of a feature file:

```gherkin
Feature: Appointment Booking

  @Booking
  Scenario: Book an appointment
    Given The user launches the browser
    When The user opens the gesundheitspraxis home page
    And The user clicks on the "Book Appointment" button
    Then The user selects a date and time
    And The user confirms the booking
```

---

## Contributing

We welcome contributions to improve this project! To contribute:

1. Fork the repository.
2. Create a feature branch:

   ```bash
   git checkout -b feature/your-feature
   ```

3. Commit your changes:

   ```bash
   git commit -m "Add your feature"
   ```

4. Push your changes:

   ```bash
   git push origin feature/your-feature
   ```

5. Open a pull request.

---



