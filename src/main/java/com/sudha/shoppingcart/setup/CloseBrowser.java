package com.sudha.shoppingcart.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.setup.OpenBrowser;
import com.sudha.shoppingcart.utils.TestUtils;
import com.sudha.shoppingcart.pageobjects.WishList;
import com.sudha.shoppingcart.reports.ExtentReportManager;

public class CloseBrowser {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	String firstWinHandle;
  
	//Test for Clearing the items from wishlist
	@Test(priority = 18)
	public void cleanUp() {
		test = extent.startTest("Cleanup activity");
		test.log(LogStatus.INFO, "Cleanup activity initiated");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		WishList wishlist = new WishList(OpenBrowser.webDriver);

		wishlist.switchPanel.click();
		TestUtils.addDelay(5000);
		wishlist.removeIcon.click();
		OpenBrowser.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		TestUtils.addDelay(5000);
		test.log(LogStatus.INFO, "Cleanup activity completed");
		extent.endTest(test);
		extent.flush();
	}

	//Test for Logging out
	@Test(priority = 19)
	@Parameters({ "browser" })
	public void LogOut(String browser) {
		if (browser.equalsIgnoreCase("Firefox")) {
			test = extent.startTest("Logging out");
			test.log(LogStatus.INFO, "Logging out from Zalando");
			WishList wishList = new WishList(OpenBrowser.webDriver);

			Actions action = new Actions(OpenBrowser.webDriver);
			action.moveToElement(wishList.myaccount).build().perform();
			//wishList.logout.get(5).click();
			 wishList.logout.click();
			TestUtils.addDelay(5000);
			test.log(LogStatus.INFO, "Logged out from Zalando");
			extent.endTest(test);
			extent.flush();
		}
		
	}

	//Close browser 
	@Test(priority = 20)
	public void quitBrowser() {
		test = extent.startTest("closing Browser");
		test.log(LogStatus.INFO, "Closing the Browser");
		OpenBrowser.webDriver.close();
		OpenBrowser.webDriver.quit();
		extent.endTest(test);
		extent.flush();

	}

}
