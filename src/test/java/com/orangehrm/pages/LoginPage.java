package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	// ✅ Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// ✅ Locators
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");

	// ✅ Error Messages
	By invalidMsg = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

	By requiredMsg = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

	// ✅ Forgot Password Link
	By forgotPasswordLink =
	        By.cssSelector("p.orangehrm-login-forgot-header");



	// ✅ Login Action
	public void login(String user, String pass) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);

		driver.findElement(password).sendKeys(pass);

		driver.findElement(loginBtn).click();
	}

	// ✅ Invalid Login Message
	public String getInvalidLoginMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidMsg)).getText();
	}

	// ✅ Required Field Message
	public String getRequiredMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(requiredMsg)).getText();
	}

	// ✅ Click Forgot Password
	// ✅ Click Forgot Password Link
	public void clickForgotPassword() {

	    // Wait until element is visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));

	    WebElement element = driver.findElement(forgotPasswordLink);

	    // JS Click (Stable)
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}


}
