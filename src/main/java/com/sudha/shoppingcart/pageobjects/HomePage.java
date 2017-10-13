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

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;

	@FindBy(xpath = ".//a[@id='modalLoginLinkAccountAccountBox']")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='searchContent']")
	public WebElement searchButton;

	@FindBy(xpath = ".//button[@id='z-pdp-topSection-addToCartButton']")
	public WebElement addToCart;

	@FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/cart/']")
	public WebElement cart;

	@FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/wishlist/']")
	public WebElement wishList;
}