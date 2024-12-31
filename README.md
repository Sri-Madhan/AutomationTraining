# Mobile Automation Testing Framework

## Overview
This project is a robust mobile automation testing framework built using Appium and Java. It's designed to provide efficient and reliable automated testing for mobile applications on both Android and iOS platforms.

## Key Features

### 1. Page Object Model (POM)
- Implemented POM design pattern for better maintainability and reusability of code.
- Each screen/page of the application has its own class, encapsulating the locators and methods specific to that screen.

### 2. Parallel Execution
- Configured for parallel test execution to reduce overall execution time.
- Utilizes TestNG for managing parallel runs efficiently.

### 3. Reporting
- Integrated ExtentReports for comprehensive and visually appealing test reports.
- Custom `ExtentReportManager` class for centralized report management.

### 4. Logging
- Implemented Log4j2 for efficient logging throughout the framework.
- Custom `LogAndReportUtils` class for combined logging and reporting functionality.

### 5. Base Class
- `BaseClass` provides common utilities and methods used across test classes.
- Includes methods for assertions, waiting for elements, and other common operations.

### 6. Driver Management
- Centralized driver management through `AppiumDriverManager` class.
- Ensures single instance of driver throughout the test execution.

### 7. Test Suites
- Separate XML files for Regression and Smoke test suites.
- Allows for easy management and execution of different types of test runs.

### 8. Data-Driven Testing with Excel
- Supports data-driven testing using Excel files.
- Custom `ExcelDataProvider` class to read test data from Excel sheets.
- Allows easy management and updates of test data without changing the code.

### 9. Customizable Waits
- Implementation of explicit waits for better handling of dynamic elements.
- Custom wait methods in `BaseClass` for element visibility and clickability.

### 10. Assertion Handling
- Custom assertion method with integrated logging and reporting.

### 11. CI/CD Integration with Jenkins
- Jenkinsfile for automated build and test execution.
- Parameterized builds allowing choice between Smoke and Regression tests.
- Automated email notifications with build status and test reports.


## Project Structure
- `src/main/java`: Contains main source code
- `src/test/java`: Contains test classes
- `suites`: XML files for different test suites
- `pom.xml`: Maven configuration file
- `log4j2.xml`: Logging configuration

## Getting Started
1. Ensure you have Java and Maven installed.
2. Clone the repository.

## Running Tests
- Locally:
  - For regression tests: `mvn test -PRegression`
  - For smoke tests: `mvn test -PSmoke`
- Via Jenkins:
  - Create a new pipeline job in Jenkins.
  - Configure the job to use the Jenkinsfile from the repository.
  - Run the job, selecting the desired test profile (Smoke or Regression).

## Jenkins Pipeline
- The Jenkinsfile defines a pipeline with stages for checkout, build, test, and report generation.
- It uses a parameterized build to choose between Smoke and Regression tests.
- After test execution, it zips the test reports and sends them via email.

## Email Notifications
- Uses the Email Extension plugin in Jenkins.
- Sends emails with build status (success/failure) and test reports.
- Configure the recipient email address in the Jenkinsfile.
- For sending emails, use an app password for the sender's email account for enhanced security.

## Customization
- Modify `BaseClass` to add or update common utilities.
- Adjust `log4j2.xml` for customizing logging behavior.
