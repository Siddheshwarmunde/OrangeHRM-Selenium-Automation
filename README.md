# OrangeHRM-Selenium-Automation
End-to-End Selenium Automation Framework for OrangeHRM using Java, Maven, TestNG, POM, Extent Reports, and automated Employee Management workflows.

# OrangeHRM Selenium Automation Framework

An **End-to-End Automation Testing Framework** developed using **Selenium WebDriver + Java + TestNG + Maven** for the OrangeHRM Web Application.

This project demonstrates an **industry-level automation framework** with Page Object Model, Extent Reporting, Screenshot capture, and complete regression suite execution.

---

## 📌 Project Objective

To automate critical HRMS functionalities such as:

- Login Validation  
- Employee Management (Add/Search/Delete)  
- Forgot Password Navigation  
- Logout Flow  

This framework is designed to simulate **real-time QA Automation practices** followed in companies.

---

## 🛠 Tech Stack & Tools

| Tool/Library | Purpose |
|-------------|---------|
| Java        | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG      | Test Framework & Assertions |
| Maven       | Build & Dependency Management |
| Page Object Model (POM) | Framework Design Pattern |
| Extent Reports | HTML Execution Reporting |
| Git + GitHub | Version Control |

---

## ✅ Automated Test Modules

### 🔹 Login Module
- Valid Login Test  
- Invalid Login Test  
- Empty Field Validation  

### 🔹 Forgot Password Module
- Forgot Password Page Navigation  

### 🔹 Employee Management Module
- Add New Employee  
- Search Employee  
- Delete Employee  
- Verify No Records Found  

### 🔹 Logout Module
- Successful Logout Test  

---

---

## 📸 Sample Extent Report Screenshot

Below is a sample Extent HTML Report generated after test execution:

![Extent Report](assets/extent-report1.png)

---


## ✅ Test Suite Execution

All tests are executed through the `testng.xml` suite:

```text
Right Click → testng.xml → Run As → TestNG Suite
