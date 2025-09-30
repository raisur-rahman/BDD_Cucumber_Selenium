
# 🌦️ BDD Cucumber framework with Selenium Automation

![Java](https://img.shields.io/badge/Java-17-orange?logo=java\&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3+-C71A36?logo=apache-maven\&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Automation-blueviolet?logo=testng\&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23D96C?logo=cucumber\&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reports-FF69B4?logo=allure\&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?logo=selenium\&logoColor=white)

This project is a **UI test automation framework** built for [AccuWeather](https://www.accuweather.com/) using **Selenium + Aquality Framework + Cucumber (BDD)**.
It demonstrates **Page Object Model (POM)** design, **Allure reporting**, and **multi-environment support**.

---

## ✨ Features

* ✅ **BDD with Cucumber** – human-readable Gherkin feature files.
* ✅ **Cross-browser support** (Chrome, Firefox, Edge, Opera, etc.).
* ✅ **Page Object Model (POM)** – clean separation of UI elements & actions.
* ✅ **Hooks with Allure** – automatic **screenshot on failure**.
* ✅ **Multi-environment setup** via JSON configs.
* ✅ **Parallel execution** with TestNG.
* ✅ **Reusable test data management**.

---

## 📂 Project Structure

```
src
 └── test
     ├── java
     │   ├── features            # BDD Scenarios (Gherkin)
     │   ├── hooks               # Setup & Teardown
     │   ├── models              # Environment models
     │   ├── pages               # Page Objects (POM)
     │   ├── runners             # Cucumber TestNG Runner
     │   ├── stepdefinitions     # Step Definitions
     │   └── utils               # Config & Test Data
     └── resources
         ├── environment         # env.json (environment selector)
         ├── prod.json           # Production environment config
         ├── qa.json             # Example QA environment config
         └── settings.json       # Browser & driver configs
```

---

## 🚀 Quickstart

### 1️⃣ Prerequisites

* **Java 17+**
* **Maven 3+**
* **Allure Commandline** (for reports)
* Chrome/Firefox/Edge browsers installed

Verify installation:

```bash
java -version
mvn -v
allure --version
```

---

### 2️⃣ Clone & Install

```bash
git clone https://github.com/<your-username>/weather-automation.git
cd weather-automation
mvn clean install
```

---

### 3️⃣ Run Tests

Run all features:

```bash
mvn test
```

Run with specific tags (e.g., smoke):

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

---

### 4️⃣ View Reports

After execution, generate **Allure Report**:

```bash
allure serve target/allure-results
```

---

## 🌍 Configuration

### 🔹 Environment Selection

In `src/test/resources/environment/env.json`:

```json
{
  "env": "prod"
}
```

Available options:

* `prod.json` – Production
* `qa.json` – QA/Testing

### 🔹 Browser Settings

In `src/test/resources/settings.json`:

```json
{
  "browserName": "chrome",
  "isRemote": false,
  "remoteConnectionUrl": "http://localhost:4444/wd/hub"
}
```

To change browser → update `browserName` (`chrome`, `firefox`, `edge`, `opera`, `yandex`).

---

## 📊 Example Scenarios

* **Current Location**

    * Open search → select "Use your current location" → verify city weather.
* **Recent Locations**

    * Search "London" → go back → verify it appears under recent locations.
* **Search City**

    * Search "New York" → verify weather page header shows "New York".

---

## 🛠️ Tech Stack

* [Java 17](https://adoptopenjdk.net/)
* [Selenium](https://www.selenium.dev/) with [Aquality Framework](https://github.com/aquality-automation/aquality-selenium)
* [Cucumber](https://cucumber.io/) (BDD)
* [TestNG](https://testng.org/)
* [Allure Reports](https://docs.qameta.io/allure/)

---

## 📌 Future Improvements

* Add **negative test scenarios** (invalid city, empty search).
* Add **data-driven testing** (cities from JSON).
* Integrate with **CI/CD (GitHub Actions, Jenkins)**.

---

## 🤝 Contributing

1. Fork the repo.
2. Create a new branch (`feature/my-update`).
3. Commit changes.
4. Open a Pull Request.

---

## 👤 Author

**Raisur Rahman**


