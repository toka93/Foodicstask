# 📦 Java Test Automation Project

This project contains a complete test automation framework for UI and API testing using Java, Selenium, TestNG, RestAssured, and reporting tools like ExtentReports and Allure.

---

## 🔧 Tech Stack

| Layer        | Technology                       |
|--------------|----------------------------------|
| Language     | Java 8+                          |
| Test Runner  | TestNG                           |
| UI Testing   | Selenium WebDriver               |
| API Testing  | RestAssured                      |
| Reporting    | ExtentReports                    |
| Build Tool   | Maven                            |
| Page Design  | Page Object Model (POM), Factory |
| Faker        | JavaFaker                        |

---

## 🚀 Getting Started

### 1. Clone the repo and Build
```bash

git clone https://github.com/your-username/your-repo.git
cd your-repo
mvn clean install

```
## Project Structure
src/
└── main/java/
└── ui/pages/        # Page Object Model classes
└── utils/           # Config, reporting

└── test/java/
└── ui/tests/        # UI test cases
└── api/tests/       # API test cases
└── api/clients/     # API client classes
└── api/models/      # POJOs for API payloads

## Configuration 

src/test/resources/config.properties

Please make sure before running add valid user mobile and password for Amazon

## Reporting 

HTML Report is generated in this path
ExtentReport/yyyy-MM-dd/ExtentReportHH-mm.html


## Improvements 
1. Add screenshots for UI tests in case of failures.
2. Add logs.