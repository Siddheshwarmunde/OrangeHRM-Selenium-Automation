package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

    WebDriver driver;
    WebDriverWait wait;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ PIM Menu
    By pimMenu = By.xpath("//span[text()='PIM']");

    // ✅ Correct Add Button
    By addBtn = By.xpath("//button[normalize-space()='Add']");

    // ✅ Employee Fields
    By firstName = By.name("firstName");
    By middleName = By.name("middleName");
    By lastName = By.name("lastName");

    // ✅ Save Button
    By saveBtn = By.xpath("//button[@type='submit' and normalize-space()='Save']");

    // ✅ Verification
    By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");
    
    By loader = By.xpath("//div[contains(@class,'oxd-form-loader')]");


    public void addEmployee(String fname, String mname, String lname) {

        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(fname);

        driver.findElement(middleName).sendKeys(mname);
        driver.findElement(lastName).sendKeys(lname);

        // ✅ Save
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();

        // ✅ Wait loader disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }


    public boolean isEmployeeAdded() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(personalDetailsHeader))
                .isDisplayed();
    }

}
