package com.sudha.shoppingcart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.CartPage;
import com.sudha.shoppingcart.reports.ExtentReportManager;
import com.sudha.shoppingcart.setup.OpenBrowser;
import com.sudha.shoppingcart.utils.TestUtils;

public class WishlistTest {
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;

	String firstWinHandle, secondWindowHandle;
    
	//Test for making sure that the item has been added to the Wishlist
	@Test(priority = 14)
	@Parameters({ "browser" })
	public void checkWishlist(String browser) {
		test = extent.startTest("Check in Wishlist");
		test.log(LogStatus.INFO, "Check in the Wishlist");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		CartPage cartpage = new CartPage(OpenBrowser.webDriver);
		
		test.log(LogStatus.INFO, "adding items to wishlist");

		WebDriverWait wait = new WebDriverWait(OpenBrowser.webDriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(cartpage.cart));

		if (cartpage.continueShopping.isDisplayed()) {
			test.log(LogStatus.INFO, "Item has been cleared out from the Cart and got added to the Wishlist");
		} else {
			test.log(LogStatus.ERROR, "Failed to add to wishlist. Continue shopping text is not displayed on the Wishlist");
		}

		if (browser.equalsIgnoreCase("Firefox")) {
			cartpage.cart.click();
			WebDriverWait wait2 = new WebDriverWait(OpenBrowser.webDriver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(cartpage.wishList));
			cartpage.wishList.click();
		} else {
			//add delay as login takes time
			TestUtils.addDelay(5000);
			OpenBrowser.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			OpenBrowser.webDriver.navigate().to("https://www.zalando.de/wishlist/");

		}
		test.log(LogStatus.INFO, "Opened the wishlist");

		if (cartpage.imageItem.isDisplayed()) {
			test.log(LogStatus.INFO, "Success:IMAGE of the item has been the one that got added from cart");
		} else {
			test.log(LogStatus.ERROR, "Verification of the item failed as the image is different");
		}
		TestUtils.addDelay(5000);
		
		extent.endTest(test);
		extent.flush();
	}
}