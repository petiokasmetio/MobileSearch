# MobileSearch UI Automation Project

Java-based UI automation project for testing and analyzing car search results on mobile.bg using Selenium WebDriver, TestNG and Maven.

This project demonstrates practical UI automation, search flow validation, result extraction and basic test organization for a real public website.

## Disclaimer

This project is created for QA automation practice, learning and portfolio demonstration purposes.

It works only with publicly available website content and does not interact with private systems, user accounts, payments or production back-office functionality.

The website structure may change over time, which can require locator or flow updates.

## Overview

MobileSearch automates a search flow on mobile.bg and processes the returned car listing results.

The project covers a realistic UI automation scenario where the test:

- opens the target website
- handles cookie notifications
- navigates through the search flow
- selects predefined search criteria
- applies filtering options
- starts the search
- iterates through result pages
- extracts listing information
- categorizes and analyzes the results
- writes the analysis into an output file

## Key Features

- Selenium WebDriver browser automation
- TestNG-based test execution
- Maven project structure
- WebDriverManager for browser driver setup
- Page Object style organization
- Automated search flow execution
- Cookie notification handling
- Search results page processing
- Listing data extraction
- Result categorization
- Output file generation
- Configuration-based test setup

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Maven Surefire Plugin

## Automated Flow

The automated flow follows these high-level steps:

```text
Open mobile.bg
Handle cookie notification
Open search functionality
Select search criteria
Apply predefined filters
Run the search
Open search results
Iterate through result pages
Extract listing data
Analyze result labels/categories
Write results to an output file
```

## Project Structure

```text
MobileSearch
├── src
│   └── test
│       ├── java
│       │   ├── Pages
│       │   │   ├── HomePage.java
│       │   │   ├── SearchPage.java
│       │   │   └── SearchResultsPage.java
│       │   ├── Tests
│       │   │   ├── BaseClass.java
│       │   │   ├── HomePageTest.java
│       │   │   ├── SearchPageTest.java
│       │   │   └── SearchResultsTest.java
│       │   └── Utilities
│       │       ├── FileOutputUtil.java
│       │       └── ReadConfig.java
│       └── resources
│           └── Configuration
├── pom.xml
├── README.md
└── .gitignore
```

## Test Classes

### BaseClass

Contains common setup and teardown logic used by the test classes.

### HomePageTest

Validates homepage access and initial page interactions.

### SearchPageTest

Automates the search criteria selection and search execution flow.

### SearchResultsTest

Processes the search result pages, extracts listing information and supports result analysis.

## Page Classes

### HomePage

Represents homepage actions such as opening the site and handling initial UI elements.

### SearchPage

Contains actions related to selecting search criteria and applying filters.

### SearchResultsPage

Contains logic for reading and processing search result listings.

## Utility Classes

### ReadConfig

Reads configuration values used by the test automation framework.

### FileOutputUtil

Handles writing extracted or analyzed result data into output files.

## Configuration

The project uses configuration values for runtime setup, such as the target base URL and browser/test settings.

Example configuration concept:

```properties
baseURL=https://www.mobile.bg/
cookiesAction=accept
```

## How to Run

Make sure the following are installed:

- Java
- Maven
- Google Chrome or another supported browser

Clone the repository:

```bash
git clone https://github.com/petiokasmetio/MobileSearch.git
cd MobileSearch
```

Run the tests:

```bash
mvn clean test
```

## Output

The automation can generate output files containing extracted and analyzed search result information.

Generated runtime output is excluded from version control because it is created during test execution.

## QA Skills Demonstrated

This project demonstrates:

- UI test automation
- Selenium WebDriver usage
- TestNG test organization
- Maven-based test execution
- browser driver management
- Page Object style test structure
- configuration handling
- public website automation
- search flow validation
- result extraction and analysis
- generated output handling
- practical QA automation mindset

## Current Project Status

Current version:

- Java Maven project
- Selenium WebDriver automation
- TestNG test execution
- Page Object style structure
- public website search flow automation
- result extraction and output generation

## Limitations

Current limitations:

- public website locators may change over time
- no CI/CD pipeline yet
- no advanced reporting yet
- no screenshots on failure yet
- no cross-browser setup yet
- limited assertion coverage
- generated output is not committed to the repository

## Potential Future Improvements

Possible next improvements:

- improve Page Object Model structure
- add stronger assertions
- add screenshots on failure
- add Allure or HTML reporting
- add GitHub Actions CI pipeline
- add cross-browser execution
- add headless browser execution
- add retry logic for unstable UI behavior
- add better logging
- add test execution screenshots to the README
- add clearer test data/configuration examples

## Author

Petar Nikolov

Test Automation Engineering Analyst with experience in ERP and banking systems, Java/Python automation, Selenium, QA tooling, XML test data generation and business-critical software testing.