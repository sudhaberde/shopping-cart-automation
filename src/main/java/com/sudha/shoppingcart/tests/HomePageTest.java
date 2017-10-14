package com.sudha.shoppingcart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.HomePage;
import com.sudha.shoppingcart.reports.ExtentReportManager;
import com.sudha.shoppingcart.setup.OpenBrowser;
import com.sudha.shoppingcart.utils.TestProperties;

public class HomePageTest {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;

	String firstWinHandle, secondWindowHandle, thirdWindowHandle;

	//Test for searching the given article
	@Test(priority = 5)
	public void searchArticle() {
		test = extent.startTest("Search article");
		test.log(LogStatus.INFO, "Searching online site for Article:" + TestProperties.getProperty("article.id"));

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		HomePage homepage = new HomePage(OpenBrowser.webDriver);

		if (homepage.searchButton.isDisplayed()) {
			test.log(LogStatus.INFO, "Search button displayed");
		} else {
			test.log(LogStatus.ERROR, "Search button not displayed");
		}
		
		test.log(LogStatus.INFO, "Searching for article " + TestProperties.getProperty("article.id"));
		homepage.searchButton.sendKeys(TestProperties.getProperty("article.id"));
		OpenBrowser.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage.searchButton.sendKeys(Keys.RETURN);
		test.log(LogStatus.INFO, "Searching for article completed");

		WebDriverWait wait = new WebDriverWait(OpenBrowser.webDriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(homepage.addToCart));

		if (homepage.addToCart.isDisplayed()) {
			test.log(LogStatus.INFO, "Searching for article completed. Ready to be added into the cart");

		} else  {
			test.log(LogStatus.ERROR, "Add to cart button cannot be found");
		}
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 6)
	public void addItemToCart() {
		test = extent.startTest("Add Article to cart");
		test.log(LogStatus.INFO, "Adding searched article to cart");

		secondWindowHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(secondWindowHandle);
		HomePage homepage = new HomePage(OpenBrowser.webDriver);
		homepage.addToCart.click();
		
		test.log(LogStatus.INFO, "Item successfully added to cart");
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 7)
	public void checkCart() {
		test = extent.startTest("Check cart");
		test.log(LogStatus.INFO, "Check in the cart");
		thirdWindowHandle = OpenBrowser.webDriver.getWindowHandle();

		OpenBrowser.webDriver.switchTo().window(thirdWindowHandle);
		HomePage homepage = new HomePage(OpenBrowser.webDriver);
		homepage.cart.click();

		test.log(LogStatus.INFO, "Cart page is opened");

		extent.endTest(test);
		extent.flush();
	}

}
