package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By profileIcon = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By logoutBtn = By.xpath("//a[text()='Logout']");

    public void logout() {

        // ✅ Click Profile Dropdown
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();

        // ✅ Click Logout Button
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
}
