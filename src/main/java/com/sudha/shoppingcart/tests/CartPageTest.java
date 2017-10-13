package com.sudha.shoppingcart.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    	
    	/*if(cartpage.quantity.selectByValue("2")){
   		 System.out.println("Quantity button displayed");
   		 
   	 }
   	 else
   		 System.out.println("button not displayed");*/
    	/*
    	
    	WebDriverWait waitForOptions = new WebDriverWait(OpenBrowser.webDriver, 3);
    	waitForOptions.until(ExpectedConditions.visibilityOfElementLocated((By) cartpage.quantityAsked));
    	cartpage.quantityAsked.click();
    	if(cartpage.quantityAsked.isSelected())
    	{
    		System.out.println("Quaantity changed");
    	}
    	else
    		System.out.println("Quaantity not changed");*/
 		cartpage.quantity.click();
 		
 		
    	cartpage.quantityAsked.get(1).click();
    	
    	
    	//((JavascriptExecutor)OpenBrowser.webDriver).executeScript("cartpage.quantityAsked.get(2).click()",cartpage.quantity);
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
 		 System.out.println("adding to wishlist");
 		extent.endTest(test);
        extent.flush();
    	
	}
	
		
}
