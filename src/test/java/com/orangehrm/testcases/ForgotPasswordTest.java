package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;

public class ForgotPasswordTest extends BaseClass {

    @Test
    public void verifyForgotPasswordNavigationTest() {

        LoginPage lp = new LoginPage(driver);

        // ✅ Click Forgot Password
        lp.clickForgotPassword();

        // ✅ Wait until reset page opens
        wait.until(ExpectedConditions.urlContains("requestPasswordResetCode"));

        Assert.assertTrue(driver.getCurrentUrl()
                .contains("requestPasswordResetCode"));

        System.out.println("✅ Forgot Password Navigation Test Passed!");
    }
}

