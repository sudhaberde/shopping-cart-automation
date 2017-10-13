package com.sudha.shoppingcart.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.shoppingcart.pageobjects.HomePage;
import com.sudha.shoppingcart.setup.*;
import com.sudha.shoppingcart.reports.*;

public class LoginPage {

	public static Properties OR = new Properties();
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle, secondWindowHandle;

	public LoginPage() {
		loadProperties();
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		loadProperties();
	}

	@FindBy(xpath = ".//input[@name='login.email']")
	public WebElement emailAddress;

	@FindBy(xpath = ".//input[@name='login.password']")
	public WebElement password;

	@FindBy(xpath = ".//button[@class='z-button z-coast-reef_login_button z-button--primary z-button--button']")
	public WebElement submit;

	@Test(priority = 12)
	public void userLogin() {
		test = extent.startTest("LoginTest");
		test.log(LogStatus.INFO, "Logging in");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();

		OpenBrowser.webDriver.switchTo().window(firstWinHandle);

		LoginPage login = new LoginPage(OpenBrowser.webDriver);

		HomePage homePage = new HomePage(OpenBrowser.webDriver);
		// homePage.loginButton.click();
		
		test.log(LogStatus.INFO, "Setting the username");

		secondWindowHandle = OpenBrowser.webDriver.getWindowHandle();

		OpenBrowser.webDriver.switchTo().window(secondWindowHandle);

		login.emailAddress.sendKeys(OR.getProperty("loginID"));
		login.password.sendKeys(new String (Base64.getDecoder().decode(OR.getProperty("pwd"))));
		test.log(LogStatus.INFO, "login pwd set");

		login.submit.click();
		test.log(LogStatus.INFO, "Login Form Submitted");

		WebDriverWait wait = new WebDriverWait(OpenBrowser.webDriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.cart));
		test.log(LogStatus.INFO, "Login Successful");
		extent.endTest(test);
		extent.flush();
	}
	
	public void loadProperties(){
		String propFilePath = null;
		try {
			OR = new Properties();
			URL is = getClass().getClassLoader().getResource("OR.properties");
			File file = new File(is.toURI());
			propFilePath = file.getAbsolutePath();
			if (!file.exists()) {
				propFilePath = new File(getClass().getClassLoader()
						.getResource("src/main/resources/OR.properties")
						.toURI()).getAbsolutePath();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			OR.load(new FileInputStream(propFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
