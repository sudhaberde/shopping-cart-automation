package com.sudha.shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public CartPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/cart/']")
	public WebElement cart;
	
	@FindBy(xpath=".//select[@class='z-coast-fjord_quantitySelect']")
	public WebElement quantity;
	
	@FindBy(xpath=".//select[@class='z-coast-fjord_quantitySelect']//")
	public WebElement quantityAsked;
	
	@FindBy(xpath=".//span[@class='z-coast-fjord_interactable z-coast-fjord_wishlistText']")
	public WebElement addToWishlist;
}
