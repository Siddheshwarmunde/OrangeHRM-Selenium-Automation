package com.orangehrm.testcases;

import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;

public class LogoutTest extends BaseClass {

    @Test
    public void verifyLogoutTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");

        DashboardPage dp = new DashboardPage(driver);
        dp.logout();

        System.out.println("✅ Logout Test Passed!");
    }
}
