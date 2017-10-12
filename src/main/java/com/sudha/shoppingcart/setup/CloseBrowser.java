package com.sudha.shoppingcart.setup;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.setup.OpenBrowser;
import com.sudha.shoppingcart.reports.ExtentReportManager;


public class CloseBrowser {
	
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	
	@Test(priority=10)
	public void quitBrowser(){

		test = extent.startTest("closing Browser");
		test.log(LogStatus.INFO, "Closing the Mozilla Browser");
		System.out.print("Closing Browser");
		//OpenBrowser.webDriver.close();
		OpenBrowser.webDriver.quit();
		System.out.print("Browser is closed");
		extent.endTest(test);
        extent.flush();
        
	}

}
