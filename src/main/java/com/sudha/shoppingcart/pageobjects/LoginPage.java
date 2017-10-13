package com.sudha.shoppingcart.pageobjects;

import java.util.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.HomePage;
import com.sudha.shoppingcart.setup.*;
import com.sudha.shoppingcart.utils.TestProperties;
import com.sudha.shoppingcart.reports.*;

public class LoginPage {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle, secondWindowHandle;

	public LoginPage() {
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//input[@name='login.email']")
	public WebElement emailAddress;

	@FindBy(xpath = ".//input[@name='login.password']")
	public WebElement password;

	@FindBy(xpath = ".//button[@class='z-button z-coast-reef_login_button z-button--primary z-button--button']")
	public WebElement submit;

	@FindBy(xpath = ".//button[@class='z-button z-button--tertiary z-button--button']")
	public WebElement joinNow;

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

		//set the username created separately for that browser
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
