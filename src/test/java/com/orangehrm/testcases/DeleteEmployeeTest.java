package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;

public class DeleteEmployeeTest extends BaseClass {

    @Test
    public void verifyDeleteEmployeeTest() {

        // ✅ Step 1: Login
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");

        // ✅ Step 2: Add Employee
        AddEmployeePage addEmp = new AddEmployeePage(driver);

        String firstName = "DeleteUser";
        String middleName = "Test";
        String lastName = "Automation";

        addEmp.addEmployee(firstName, middleName, lastName);

        Assert.assertTrue(addEmp.isEmployeeAdded());
        System.out.println("✅ Employee Added Successfully!");

        // ✅ Step 3: Search Employee Before Delete
        EmployeeListPage empList = new EmployeeListPage(driver);

        empList.searchEmployee(firstName);

        Assert.assertTrue(empList.isEmployeeNamePresent(firstName));
        System.out.println("✅ Employee Found Successfully!");

        // ✅ Step 4: Delete Employee
        empList.deleteEmployee();
        System.out.println("✅ Employee Deleted Successfully!");

        // ✅ Step 5: Search Again After Delete
        empList.searchEmployeeWithoutSuggestion(firstName);

        // ✅ Step 6: Verify Employee Removed
        Assert.assertTrue(empList.isNoRecordFound());

        System.out.println("✅ No Records Found Verified!");
       
    }
}
