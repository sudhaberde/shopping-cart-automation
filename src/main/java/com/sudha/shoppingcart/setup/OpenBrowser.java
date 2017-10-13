package com.sudha.shoppingcart.setup;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.sudha.shoppingcart.reports.ExtentReportManager;

@Test
public class OpenBrowser {

	public static WebDriver webDriver = null;
	private static final String ZALANDO_HOME_URL = "https://zalando.de";
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;

	@Test(priority = 1)
	@Parameters({ "browser" })
	public void startBrowser(String browser) {
		//set the driver based on browser
		if (browser.equalsIgnoreCase("Chrome")){
			test = extent.startTest("OpenBrowser");
			test.log(LogStatus.INFO, "Opening Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "webdriver/bin/chromedriver");
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}else {
			System.setProperty("webdriver.firefox.marionette", "webdriver/bin/geckodriver");
			test = extent.startTest("OpenBrowser");
			test.log(LogStatus.INFO, "Opening the Mozilla Firefox Browser");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference(FirefoxProfile.PORT_PREFERENCE, "localhost.localdomain");
			webDriver = new FirefoxDriver(profile);
			webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		}
		test.log(LogStatus.INFO, "Opening website : " + ZALANDO_HOME_URL);
		//open the website
		webDriver.get(ZALANDO_HOME_URL);
		webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Opened website : " + ZALANDO_HOME_URL);
		extent.endTest(test);
		extent.flush();
	}

}
