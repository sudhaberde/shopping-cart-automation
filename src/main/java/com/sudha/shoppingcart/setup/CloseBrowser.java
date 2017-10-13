package com.sudha.shoppingcart.setup;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.setup.OpenBrowser;
import com.sudha.shoppingcart.pageobjects.WishList;
import com.sudha.shoppingcart.reports.ExtentReportManager;

public class CloseBrowser {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	String firstWinHandle;

	@Test(priority = 18)
	public void cleanUp() {
		test = extent.startTest("Cleanup activity");
		test.log(LogStatus.INFO, "Cleanup activity initiated");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();

		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		WishList wishlist = new WishList(OpenBrowser.webDriver);

		// Actions action= new Actions(OpenBrowser.webDriver);

		// action.doubleClick(wishlist.removeIcon);

		wishlist.switchPanel.click();

		wishlist.removeIcon.click();
		test.log(LogStatus.INFO, "Cleanup activity completed");

		OpenBrowser.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("Cleared up");

		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 20)
	public void quitBrowser() {

		test = extent.startTest("closing Browser");
		test.log(LogStatus.INFO, "Closing the Mozilla Browser");
		System.out.print("Closing Browser");
		// OpenBrowser.webDriver.close();
		OpenBrowser.webDriver.quit();
		System.out.print("Browser is closed");
		extent.endTest(test);
		extent.flush();

	}

}
