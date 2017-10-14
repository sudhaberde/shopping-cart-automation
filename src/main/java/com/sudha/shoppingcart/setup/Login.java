package com.sudha.shoppingcart.setup;

import java.util.Base64;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.HomePage;
import com.sudha.shoppingcart.pageobjects.LoginPage;
import com.sudha.shoppingcart.reports.ExtentReportManager;
import com.sudha.shoppingcart.utils.TestProperties;

public class Login {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle, secondWindowHandle;
	
	@Test(priority = 12)
	@Parameters({ "browser" })
	public void userLogin(String browser) {
		test = extent.startTest("LoginTest");
		test.log(LogStatus.INFO, "Logging in");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		LoginPage login = new LoginPage(OpenBrowser.webDriver);
		HomePage homePage = new HomePage(OpenBrowser.webDriver);
		
		test.log(LogStatus.INFO, "Setting the username and pwd");
		
		secondWindowHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(secondWindowHandle);

		//set the username created separately for the respective browser
		if (browser.equalsIgnoreCase("Chrome")) {
			login.emailAddress.sendKeys(TestProperties.getProperty("login.id.ch"));
			login.password.sendKeys(new String(Base64.getDecoder().decode(TestProperties.getProperty("pwd"))));
		} else {
			login.emailAddress.sendKeys(TestProperties.getProperty("login.id.ff"));
			login.password.sendKeys(new String(Base64.getDecoder().decode(TestProperties.getProperty("pwd"))));
		}
		test.log(LogStatus.INFO, "Username and pwd set");
		
		login.submit.click();
		
		WebDriverWait wait = new WebDriverWait(OpenBrowser.webDriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.cart));
		
		test.log(LogStatus.INFO, "Login Successful");
		extent.endTest(test);
		extent.flush();
	}
}
