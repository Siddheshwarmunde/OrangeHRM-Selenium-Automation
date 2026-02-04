package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.LoginPage;

public class AddEmployeeTest extends BaseClass {

	@Test
	public void verifyAddEmployeeTest() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login("Admin", "admin123");

	    AddEmployeePage emp = new AddEmployeePage(driver);

	    emp.addEmployee("Siddheshwar", "Automation", "Munde");

	    Assert.assertTrue(emp.isEmployeeAdded());

	    System.out.println("✅ Add Employee Test Passed!");
	}
}