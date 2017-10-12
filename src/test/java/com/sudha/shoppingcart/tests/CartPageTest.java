package com.sudha.shoppingcart.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.CartPage;
import com.sudha.shoppingcart.reports.ExtentReportManager;
import com.sudha.shoppingcart.setup.OpenBrowser;


public class CartPageTest {

	private ExtentReports extent = ExtentReportManager.getInstance();
    private ExtentTest test;
		
	String  firstWinHandle,secondWindowHandle,thirdWindowHandle ;
	@Test(priority=8)
	public void changeQuantity(){
		
		test = extent.startTest("Change quantity");
    	test.log(LogStatus.INFO, "Change quantity in the cart");
    	firstWinHandle = OpenBrowser.webDriver.getWindowHandle();

 		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
 		CartPage cartpage= new CartPage(OpenBrowser.webDriver);
    	
    	if(cartpage.quantity.isDisplayed()){
   		 System.out.println("button displayed");
   		 
   	 }
   	 else
   		 System.out.println("button not displayed");
    	
    	((JavascriptExecutor)OpenBrowser.webDriver).executeScript("arguments[1].click()",cartpage.quantity);
    	test.log(LogStatus.INFO, "Changed quantity in the cart to 2");
    	extent.endTest(test);
        extent.flush();
		
	}
	
	@Test(priority=9)
	public void addtoWishList(){
		test = extent.startTest("Add to Wishlist");
    	test.log(LogStatus.INFO, "Add it to wishlist");
    	secondWindowHandle = OpenBrowser.webDriver.getWindowHandle();
    	OpenBrowser.webDriver.switchTo().window(secondWindowHandle);
 		CartPage cartpage= new CartPage(OpenBrowser.webDriver);
 		
 		cartpage.addToWishlist.click();
 		extent.endTest(test);
        extent.flush();
    	
	}
	
		
}
