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

	

	public LoginPage() {
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    //Input box for Email address 
	@FindBy(xpath = ".//input[@name='login.email']")
	public WebElement emailAddress;

	//Input box for Passowrd
	@FindBy(xpath = ".//input[@name='login.password']")
	public WebElement password;

	//Submit button on the login page
	@FindBy(xpath = ".//button[@class='z-button z-coast-reef_login_button z-button--primary z-button--button']")
	public WebElement submit;


	
}
