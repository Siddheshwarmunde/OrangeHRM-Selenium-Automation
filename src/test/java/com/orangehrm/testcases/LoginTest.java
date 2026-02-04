package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void verifyLoginTest() {

        LoginPage lp = new LoginPage(driver);

        lp.login("Admin", "admin123");

        String title = driver.getTitle();

        System.out.println("Page Title is: " + title);

        Assert.assertTrue(title.contains("OrangeHRM"));

        System.out.println("✅ Login Test Passed!");
    }
}
