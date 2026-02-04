package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;

public class SearchEmployeeTest extends BaseClass {

	@Test
	public void verifySearchEmployeeTest() {

		// ✅ Step 1: Login
		LoginPage lp = new LoginPage(driver);
		lp.login("Admin", "admin123");

		// ✅ Step 2: Add Employee First (Test Data Setup)
		AddEmployeePage addEmp = new AddEmployeePage(driver);

		String firstName = "Siddheshwar";
		String middleName = "Automation";
		String lastName = "Munde";

		addEmp.addEmployee(firstName, middleName, lastName);

		Assert.assertTrue(addEmp.isEmployeeAdded());

		System.out.println("✅ Employee Added Successfully!");

		// ✅ Step 3: Search Employee Now
		EmployeeListPage empList = new EmployeeListPage(driver);

		empList.searchEmployee(firstName);

		Assert.assertTrue(empList.isEmployeeNamePresent("Siddheshwar"));

		System.out.println("✅ Search Employee Test Passed!");


	}
}
