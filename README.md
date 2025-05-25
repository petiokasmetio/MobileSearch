# 📱 MobileSearch – Automated Search on Mobile.bg

**MobileSearch** is a Java-based Maven project that automates the search and analysis of car listings on [mobile.bg](https://www.mobile.bg), using **Selenium WebDriver** and **TestNG**.

## 🧪 Key Features

- Accepts or declines cookie notifications
- Navigates to the search menu
- Selects VW as a brand and applies the 4x4 filter
- Initiates a search based on selected criteria
- Analyzes the listings by type: **VIP**, **TOP**, or **No Label**
- Saves results to a file: `output/output_N/full_search_result_analysis.txt`

## ⚙️ Technologies & Dependencies

The project uses the following libraries and tools:

- 🧭 **Selenium WebDriver** `4.20.0`
- ✅ **TestNG** `7.10.2`
- 🌐 **WebDriverManager** `5.8.0` – automatic driver management
- 🧪 **Maven Surefire Plugin** – runs TestNG tests
- ☕ **Java 17**

## 🚀 Test Structure

- **HomePageTest** – Verifies the homepage and the search button
- **SearchPageTest** – Performs a search for VW with the 4x4 filter
- **SearchResultsTest** – Iterates through all result pages and extracts data

## 🧾 Configuration

The `config.properties` file contains basic settings like:

```properties
baseURL=https://www.mobile.bg/
cookiesAction=accept

This project is ideal for demonstrating skills in UI automation, handling dynamic web content, and real-world data analysis.
