package com.orangehrm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("./reports/OrangeHRMReport.html");

            reporter.config().setReportName("OrangeHRM Automation Report");
            reporter.config().setDocumentTitle("Extent Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }
}
