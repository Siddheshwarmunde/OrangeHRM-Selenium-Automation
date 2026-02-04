package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;

public class InvalidLoginTest extends BaseClass {

    @Test
    public void verifyInvalidLoginTest() {

        LoginPage lp = new LoginPage(driver);

        lp.login("Admin", "wrongpass");

        String msg = lp.getInvalidLoginMessage();

        System.out.println("Invalid Login Message: " + msg);

        Assert.assertEquals(msg, "Invalid credentials");

        System.out.println("✅ Invalid Login Test Passed!");
    }
}
