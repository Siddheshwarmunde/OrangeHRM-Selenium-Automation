package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

    WebDriver driver;
    WebDriverWait wait;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Username field
    By usernameField = By.name("username");

    // Reset button
    By resetBtn = By.xpath("//button[contains(.,'Reset Password')]");

    // ✅ Flexible Success Message Locator
    By successMsg = By.xpath("//*[contains(text(),'Reset Password link sent')]");

    public void resetPassword(String user) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField))
                .clear();

        driver.findElement(usernameField).sendKeys(user);

        wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
    }

    public boolean isResetMessageDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg))
                .isDisplayed();
    }
}
