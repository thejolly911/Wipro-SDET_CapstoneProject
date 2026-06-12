Here is an expanded, comprehensive, and highly detailed version of your `README.md` text. It has been upgraded to a professional standard, incorporating deep technical details about your specific project structure, the exact automation mechanisms you used, and the explicit CI/CD workflow steps.

You can copy and paste the entire block below directly into your `README.md` file in Eclipse.

---

```markdown
# 🚀 SDET Capstone Automation Framework

## 📌 Project Overview
This project represents a robust, industry-standard **Selenium Automation Framework** engineered to demonstrate end-to-end web automation capabilities. Built using a modular architecture, the framework leverages **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, adhering strictly to the **Page Object Model (POM)** design pattern. 

The primary objective of this framework is to automate complex user journeys across multiple web platforms, ensuring high test coverage, seamless maintenance, reusable code components, and comprehensive graphical execution reporting.

---

## 🛠️ Tech Stack & Dependencies

The framework is built using modern open-source tools and libraries to ensure scalability and cross-platform compatibility:

*   **Core Language:** Java (JDK 11+)
*   **Web Automation:** Selenium WebDriver (v4.x)
*   **Test Management:** TestNG (Assertion, Parameterization, Data-Driven, Test Suites)
*   **Build & Dependency Tool:** Apache Maven
*   **Driver Management:** WebDriverManager (Automated browser binary management)
*   **Reporting Engine:** Extent Reports (Rich HTML test execution reports)
*   **Version Control:** Git & GitHub
*   **Continuous Integration:** Jenkins (Pipeline-as-Code)

---

## 🏗️ Architectural Design Pattern

To eliminate code duplication and maximize test script readability, this project implements the **Page Object Model (POM)** design pattern. 

*   **Separation of Concerns:** Web elements and core actions are isolated within dedicated Page Classes, completely decoupled from the actual assertion-driven Test Cases.
*   **Maintainability:** Any UI changes on the web application require updates only in the specific Page Class, safeguarding test scripts from breaking globally.
*   **Encapsulation:** Web elements are located using `@FindBy` annotations and encapsulated behind public action methods.

---

## 📂 Project Structure & Directory Layout

The framework follows a standard Maven directory convention, organized logically for seamless navigation:

```text
src/test/java
├── base
│   └── BaseTest.java             # Framework setup (Browser initialization, implicit/explicit waits, tear down)
│
├── pages                         # Page Object Classes holding WebElements and element-specific actions
│   ├── GUI Element Pages         # Page classes handling complex HTML UI controls
│   ├── ParaBank Pages            # Authentication, registration, and account dashboard elements
│   └── BlazeDemo Pages           # Flight search, selection, and checkout elements
│
├── testcases                     # Test execution scripts containing TestNG annotations and assertions
│   ├── GuiElementsTest.java      # Validations for interactive web controls
│   ├── ParaBankRegistrationTest.java # Workflows for user creation and session lifecycle
│   └── BlazeDemoTest.java        # End-to-end booking verification
│
├── utilities
│   └── WaitUtils.java            # Custom synchronization wrapper for Fluent, Explicit Waits and Page Scrolling
│
├── reports
│   └── ExtentManager.java        # Configuration engine for Extent Reports initialization
│
└── listeners
    └── TestListener.java         # TestNG Listener capturing test status (Pass/Fail/Skip) and attaching artifacts

```

---

## 🧪 Detailed Automation Scenarios & Test Coverage

### 1. Advanced GUI Elements Automation

Comprehensive validation of core and complex web elements, checking cross-browser stability and dynamic element handling:

* **Basic Form Elements:** Text fields validation, absolute/relative radio buttons selection, and multi-checkbox configurations.
* **Complex Dropdowns:** Static select tags and dynamic, auto-suggestive bootstrap search dropdowns.
* **Dynamic Synchronization & Timing:** Interactive handling of date pickers, loading spinners, dynamic buttons, and AJAX content.
* **User Interactions (Actions Class):** Complex mouse hovers, double-clicks, drag-and-drop operations, slider adjustments, and pagination tables.
* **Advanced Web Components:** Text extraction from Shadow DOM elements, validation of broken links using HTTP status codes, pagination traversing, and nested footer link interaction.
* **Window Management:** Managing JavaScript Alerts/Prompts, multi-tab transitions, and modal popup windows.

### 2. ParaBank User Management Pipeline

End-to-end transactional workflow validating user authentication security and data integrity:

* **Dynamic Data Insertion:** Run-time generation of unique usernames to prevent database collision during registration.
* **Account Provisioning:** Completing registration forms, handling success screens, and logging out securely.
* **Session Lifecycle Validation:** Logging back in with newly generated runtime credentials and verifying secure landing page parameters.

### 3. BlazeDemo Flight E-Commerce Funnel

A continuous user flow validating a transaction funnel from discovery to conversion:

* **Search Query Routing:** Filtering flights based on parameterized departure and destination hubs.
* **Flight Evaluation:** Dynamic scanning of the flight list and choosing an optimal option.
* **Checkout & Gateway Processing:** populating comprehensive passenger details, fake credit card billing data, and submitting the purchase.
* **Receipt Parsing:** Scraping and asserting the booking confirmation ID, total costs, and final checkout transaction state.

---

## ✨ Framework Engineering Features

* **Robust Synchronization:** Employs centralized custom explicit wait utilities (`WaitUtils.java`) to combat flaky test runs caused by fluctuating network speeds.
* **Globalized Suite Controller:** Centralized control via `testng.xml` facilitating parallel test execution, test grouping, and localized execution routing.
* **Dynamic Listeners:** Integrated TestNG listeners that actively monitor test states, programmatically triggering logging events upon test passage, failure, or skips.

---

## 📊 Comprehensive Reporting Strategy

Test results are compiled into visual dashboards using **Extent Reports**.

```text
test-output/
└── ExtentReport.html

```

### Report Analytics Include:

* **High-Level Dashboard:** Clear graphical charts summarizing overall Passed vs. Failed test counts.
* **Chronological Logging:** Step-by-step logging of script operations with precise execution timestamps.
* **Failure Analysis:** Injection of runtime exception stack traces directly into failed test panels for fast debugging.

---

## ⚙️ How to Set Up and Execute Locally

### Prerequisites

Ensure you have the following installed locally:

* Java Development Kit (JDK 11 or higher)
* Apache Maven (configured in environment variables)
* Eclipse IDE (or IntelliJ IDEA)

### Local Deployment Steps

1. **Clone the Project:**

```bash
   git clone [https://github.com/thejolly911/Wipro-SDET_CapstoneProject.git](https://github.com/thejolly911/Wipro-SDET_CapstoneProject.git)

```

2. **Import into Workspace:** Open Eclipse, select `File -> Import -> Existing Maven Projects`, browse to the root directory, and finish.
3. **Download Dependencies:** Right-click on the project root folder $\rightarrow$ `Maven -> Update Project`.
4. **Execution via TestNG:**
* Locate the `testng.xml` file in the root directory.
* Right-click `testng.xml` $\rightarrow$ `Run As -> TestNG Suite`.



---

## 🚀 Continuous Integration (CI/CD) Jenkins Pipeline

The framework is production-ready and fully integrated with a **Jenkins Pipeline** via a declarative workflow (`Jenkinsfile`).

### Pipeline Stages:

1. **Source Code Management (SCM):** Polling and checking out the latest source code additions pushed to the `main` branch of the GitHub repository.
2. **Environment Verification:** Checking for appropriate Java and Maven system variables within the execution agent.
3. **Execution Phase:** Compiling test files and running the test matrix via headless browser modes using Maven commands:

```bash
   mvn clean test

```

4. **Artifact Archiving:** Aggregating generated HTML execution reports and hosting them directly on the Jenkins build history panel for historical tracking.

### Pipeline Business Outcomes:

* **Automated Continuous Validation:** Tests execute automatically without manual supervision.
* **Instant Regression Alerts:** Immediate visibility into functional regressions or code stability issues.
* **Historical Tracking:** Build metrics allow team leads to track framework health over time.

---

## ✍️ Author

* **Arya Kumar Dash**
* *SDET Automation Testing Capstone Project Associate*

```

```