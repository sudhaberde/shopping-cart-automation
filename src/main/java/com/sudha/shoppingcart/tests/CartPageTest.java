package com.sudha.shoppingcart.tests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.CartPage;
import com.sudha.shoppingcart.reports.ExtentReportManager;
import com.sudha.shoppingcart.setup.OpenBrowser;

public class CartPageTest {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;

	String firstWinHandle, secondWindowHandle;

	//Test for changing the quantity on the cart 
	@Test(priority = 8)
	public void changeQuantity() {
		test = extent.startTest("Change quantity");
		test.log(LogStatus.INFO, "Change quantity in the cart");
		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();

		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		CartPage cartpage = new CartPage(OpenBrowser.webDriver);
		cartpage.quantity.click();

		cartpage.quantityAsked.get(1).click();

		test.log(LogStatus.INFO, "Changed quantity in the cart to 2");
		extent.endTest(test);
		extent.flush();
	}

	//Test for adding it to the Wishlist
	@Test(priority = 9)
	public void addtoWishList() {
		test = extent.startTest("Add to Wishlist");
		test.log(LogStatus.INFO, "Add cart items to wishlist");
		
		secondWindowHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(secondWindowHandle);
		CartPage cartpage = new CartPage(OpenBrowser.webDriver);
		cartpage.addToWishlist.click();
		OpenBrowser.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Added cart items to wishlist");
		extent.endTest(test);
		extent.flush();

	}

}
