package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;

public class EmptyLoginTest extends BaseClass {

    @Test
    public void verifyEmptyLoginTest() {

        LoginPage lp = new LoginPage(driver);

        lp.login("", "");

        String msg = lp.getRequiredMessage();

        System.out.println("Required Message: " + msg);

        Assert.assertEquals(msg, "Required");

        System.out.println("✅ Empty Login Test Passed!");
    }
}
