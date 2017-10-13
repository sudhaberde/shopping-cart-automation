package com.sudha.shoppingcart.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	public static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {
			extent = new ExtentReports("./test_report.html");
			extent.config().documentTitle("test Report").reportHeadline("Selenium Execution");

		}
		return extent;

	}
}
