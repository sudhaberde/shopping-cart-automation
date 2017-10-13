package com.sudha.shoppingcart.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.CartPage;
import com.sudha.shoppingcart.pageobjects.HomePage;
import com.sudha.shoppingcart.pageobjects.WishList;
import com.sudha.shoppingcart.reports.ExtentReportManager;
import com.sudha.shoppingcart.setup.OpenBrowser;

public class WishlistTest {
	private ExtentReports extent = ExtentReportManager.getInstance();
    private ExtentTest test;
		
	String  firstWinHandle,secondWindowHandle;
	
	@Test(priority=14)
	public void checkWishlist(){
	test = extent.startTest("Check in Wishlist");
	test.log(LogStatus.INFO, "Check in the Wishlist");
	firstWinHandle = OpenBrowser.webDriver.getWindowHandle();

		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		CartPage cartpage= new CartPage(OpenBrowser.webDriver);
		WishList wishpage= new WishList(OpenBrowser.webDriver);
		//HomePage homepage = new HomePage(OpenBrowser.webDriver);
		System.out.println("adding to wishlist 2");
		
		//cartpage.addToWishlist.click();
		
		//cartpage.wishList.click();
		
		/*if(cartpage.imageItem.isDisplayed()){
			System.out.println("Item added to wishlist");
		}
		
		else
			System.out.println("Text is  not displayed:On the Wishlist");
		
		WebDriverWait wait = new WebDriverWait(OpenBrowser.webDriver,20);
   	  wait.until(ExpectedConditions.elementToBeClickable(cartpage.cart));
		*/
		
		WebDriverWait wait = new WebDriverWait(OpenBrowser.webDriver,20);
	   	  wait.until(ExpectedConditions.elementToBeClickable(cartpage.cart));
		cartpage.cart.click();
		
		if(cartpage.continueShopping.isDisplayed()){
			test.log(LogStatus.INFO, "Item has been cleared out from the Cart and got added to the Wishlist");
			
		}
			
		else
			test.log(LogStatus.ERROR,"Text is  not displayed:On the Wishlist");
		System.out.println("opening wishlist");
		
		cartpage.wishList.click();
		
		System.out.println("opened wishlist");
		WebDriverWait wait1 = new WebDriverWait(OpenBrowser.webDriver,20);
	   	  wait1.until(ExpectedConditions.elementToBeClickable(cartpage.imageItem));
	   	  
		
		if(cartpage.imageItem.isDisplayed()){
			test.log(LogStatus.INFO, "Success:IMAGE of the item has been the one that got added from cart");
		}
		else
			test.log(LogStatus.ERROR,"Verification of the item failed as the image is different");
		
		
	
	 
	extent.endTest(test);
   extent.flush();
 }
}