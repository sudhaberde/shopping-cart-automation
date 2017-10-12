package com.sudha.shoppingcart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.setup.OpenBrowser;
import com.sudha.shoppingcart.reports.ExtentReportManager;
import com.sudha.shoppingcart.pageobjects.*;
import com.sudha.shoppingcart.reports.*;

public class HomePageTest {
	
	private ExtentReports extent = ExtentReportManager.getInstance();
    private ExtentTest test;
		
	String  firstWinHandle,secondWindowHandle,thirdWindowHandle;
		

	    @Test(priority=5)
		public void searchArticle(){
	    	 test = extent.startTest("Search Article");
	    	 test.log(LogStatus.INFO, "Searching online site for Article");
	    	 
	    	 firstWinHandle = OpenBrowser.webDriver.getWindowHandle();

	 		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
	 		
	    	 HomePage homepage= new HomePage(OpenBrowser.webDriver);
	 		
	    	 if(homepage.searchButton.isDisplayed()){
	    		 System.out.println("button displayed");
	    		 
	    	 }
	    	 else
	    		 System.out.println("button not displayed");
	    	 homepage.searchButton.sendKeys("DK151H09R-Q11");
	    	 homepage.searchButton.sendKeys(Keys.RETURN);
	    	 
	    	 
	    	 WebDriverWait wait = new WebDriverWait(OpenBrowser.webDriver,20);
	    	 wait.until(ExpectedConditions.elementToBeClickable(homepage.addToCart));
	    	 
	    	 if(homepage.addToCart.isDisplayed()){
	    		 System.out.println("button displayed");
	    		 
	    	 }
	    	 else
	    		 System.out.println("button not displayed");
	    	 test.log(LogStatus.INFO, "Article for searching has been loaded");
	    	 
	    	 extent.endTest(test);
	         extent.flush();
	    }
	    
	    @Test(priority=6)
	    public void addItemToCart(){
	    	test = extent.startTest("Add Article to cart");
	    	test.log(LogStatus.INFO, "Adding searched article to cart");
	    	 
	    	 secondWindowHandle = OpenBrowser.webDriver.getWindowHandle();

	 		OpenBrowser.webDriver.switchTo().window(secondWindowHandle);
	 		
	    	 HomePage homepage= new HomePage(OpenBrowser.webDriver);
	    	 
	    	 homepage.addToCart.click();
	    	 extent.endTest(test);
	         extent.flush();
	    }
	    
	    @Test(priority=7)
	    public void checkCart(){
	    	test = extent.startTest("Check Cart");
	    	test.log(LogStatus.INFO, "Check in the cart");
	    	thirdWindowHandle= OpenBrowser.webDriver.getWindowHandle();
	    	
	    	OpenBrowser.webDriver.switchTo().window(thirdWindowHandle);
	    	HomePage homepage = new HomePage(OpenBrowser.webDriver);
	    	homepage.cart.click();
	    	test.log(LogStatus.INFO, "Cart page is opened");
	    	
	    	extent.endTest(test);
	        extent.flush();
	    }

}
