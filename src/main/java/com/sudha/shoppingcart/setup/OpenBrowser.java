package com.sudha.shoppingcart.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.sudha.shoppingcart.reports.ExtentReportManager;


public class OpenBrowser {
	
	
    //@Test(priority=1)
	/*public void startBrowser(){
    	//TODO add this info to readme
		 //System.setProperty("webdriver.chrome.driver", "/Users/sudha/Downloads/geckodriver.exe");
    	System.setProperty("webdriver.gecko.driver", "/Users/sudha/Downloads/geckodriver");
        test = extent.startTest("OpenBrowser");
        test.log(LogStatus.INFO, "Opening the Mozilla Browser");
       /* FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference(FirefoxProfile.PORT_PREFERENCE, "localhost.localdomain");
        FirefoxOptions FFOptions = new FirefoxOptions().setProfile(profile);
        webDriver = new FirefoxDriver(FFOptions);*/
        
        
       /* DesiredCapabilities capabilities = DesiredCapabilities.firefox();
     
        capabilities.setBrowserName("firefox");
        //capabilities.setVersion("");

        capabilities.setCapability("marionette", true);
        webDriver = new FirefoxDriver(capabilities);
        
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        test.log(LogStatus.INFO, "Opening the site");
        webDriver.navigate().to("https://www.zalando.de");
        webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        extent.endTest(test);
        extent.flush();
		
   }  */
  public static WebDriver webDriver =null;
	
	private ExtentReports extent = ExtentReportManager.getInstance();
    private ExtentTest test;
	
    @Test(priority=1)
	public void startBrowser(){
    	//TODO add this info to readme
		System.setProperty("webdriver.firefox.marionette", "/Users/sudha/Downloads/geckodriver");
        test = extent.startTest("OpenBrowser");
        test.log(LogStatus.INFO, "Opening the Mozilla Browser");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference(FirefoxProfile.PORT_PREFERENCE, "localhost.localdomain");
        webDriver = new FirefoxDriver(profile);
        webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
     System.out.println("Opening Zalando. For logging in as an admin");
        //TODO: read from prop file
        webDriver.get("http://zalando.de");
        webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        
       
        extent.endTest(test);
        extent.flush();
		
   }
    
    
    
}
