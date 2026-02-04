package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPage {

	WebDriver driver;
	WebDriverWait wait;

	// ✅ Constructor
	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// ✅ Locators
	By pimMenu = By.xpath("//a[contains(@href,'pim')]");

	By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");

	By searchBtn = By.xpath("//button[normalize-space()='Search']");

	// ✅ Table Body
	By tableBody = By.className("oxd-table-body");

	// ✅ Trash Icon Delete Button
	By deleteBtn = By.xpath("//i[contains(@class,'bi-trash')]");

	// ✅ Confirm Delete Button
	By confirmDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");

	// ✅ No Records Found Message
	By noRecordsMsg = By.xpath("//*[normalize-space()='No Records Found']");

	// ✅ Search Employee WITH Suggestion (Before Delete)
	public void searchEmployee(String empName) {

		wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameField)).clear();

		driver.findElement(employeeNameField).sendKeys(empName);

		// ✅ Select Auto Suggestion
		By suggestion = By.xpath("//div[@role='listbox']//span[contains(text(),'" + empName + "')]");

		wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();

		// ✅ Click Search
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();

		// ✅ Wait for Results Table
		wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
	}

	// ✅ Search Employee WITHOUT Suggestion (After Delete)
	public void searchEmployeeWithoutSuggestion(String empName) {

		wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameField)).clear();

		driver.findElement(employeeNameField).sendKeys(empName);

		// ✅ Direct Search Click
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();

		// ✅ Wait for Table Reload
		wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
	}

	// ✅ Verify Employee Exists
	public boolean isEmployeeNamePresent(String empName) {

		By empResult = By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'" + empName + "')]");

		return wait.until(ExpectedConditions.visibilityOfElementLocated(empResult)).isDisplayed();
	}

	// ✅ Delete Employee
	public void deleteEmployee() {

		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
	}

	// ✅ Verify No Records Found (Employee Deleted)
	public boolean isNoRecordFound() {

		// ✅ Scroll Down to Result Section
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

		return wait.until(ExpectedConditions.visibilityOfElementLocated(noRecordsMsg)).isDisplayed();
	}

}
