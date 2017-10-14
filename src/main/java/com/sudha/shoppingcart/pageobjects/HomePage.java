package com.sudha.shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sudha.shoppingcart.reports.ExtentReportManager;

public class HomePage {
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	
  
    //Search box on the www.Zalando.de page
	@FindBy(xpath = "//*[@id='searchContent']")
	public WebElement searchButton;
	
    // Button for adding the item to cart
	@FindBy(xpath = ".//button[@id='z-pdp-topSection-addToCartButton']")
	public WebElement addToCart;

	// Link for navigating to cart page on top navigation panel
	@FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/cart/']")
	public WebElement cart;
    
	//Link for navigating to Wishlist page on top navigation panel
	@FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/wishlist/']")
	public WebElement wishList;
}