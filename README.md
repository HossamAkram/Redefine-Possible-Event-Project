# Redefine Possible Web Test Automation Project

## Overview
Test Automation for a demo website using Selenium WebDriver with Java, based on Maven and TestNG.

- Implements Fluent Page Object Model (POM) for structuring test scripts.
- Automates a basic user flow including navigation and interactions.
- Manages test data using external files for flexibility.
- Generates detailed test reports with logs and screenshots via Allure.
- Supports local execution and remote execution on Selenium Grid.

## Features

### Structure of "main" Folder
- Implements Page Object Model (POM) with reusable page components.
- Uses locators and actions to interact with web elements efficiently.

### Structure of "test" Folder
- Includes Base Test Class to manage test setup and teardown.
- Uses annotations for configuring browser sessions.
- Ensures tests start from a clean state by resetting the session per test.

### Assertions
- Hard assertions ensure critical checkpoints are met before proceeding.
- Soft assertions allow validations within the test without stopping execution.

### Reporting
- Generates detailed test reports with steps and screenshots.
- Captures failure details including screenshots and logs.

### Configurations
- Reads global variables and settings from a properties file.
- Supports different execution types (local, remote).
- Allows configuring browser types (Chrome, Firefox, Edge).

### Test Data Management
- Uses external JSON files to store test data.
- Supports static data storage (messages, page titles, credentials).
- Allows updating test data dynamically for future test runs.

## Prerequisites
- Install Java (JDK 11+ recommended).
- Install an IDE such as IntelliJ IDEA or Eclipse.
- Install Maven (if not bundled with your IDE).
- Ensure necessary WebDriver binaries are available (ChromeDriver, GeckoDriver, etc.).
- Install Docker (for remote execution).

## Running the Tests Using an IDE
1. Open the project in your IDE.
2. Navigate to `src/test/java/org/project/tests/`.
3. Open the test class you want to execute.
4. Right-click inside the class and select `Run 'ClassName'`.

### Running on Selenium Grid (Remote Execution)

1. Install Docker.
2. Navigate to the directory containing `docker-compose_selenium4.yml`.
3. Start the Grid:

   ```bash
   docker-compose -f docker-compose_selenium4.yml up
   ```
4. Open a browser and go to `http://localhost:4444/ui` to view the Selenium Grid.
5. Navigate to the **Sessions** tab and click the video icon to see test execution live.
6. Run the tests with execution.type=Remote in configuration.properties.
