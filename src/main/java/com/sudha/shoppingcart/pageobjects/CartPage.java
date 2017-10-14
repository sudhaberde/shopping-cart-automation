package com.sudha.shoppingcart.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    //Hyperlink for navigating to  Cart on the top panel
	@FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/cart/']")
	public WebElement cart;

	//Drop down option for quantity beside the item
	@FindBy(xpath = ".//select[@class='z-coast-fjord_quantitySelect']")
	public WebElement quantity;
    
	//Hidden options in the dropdown
	@FindBy(xpath = ".//select[@class='z-coast-fjord_quantitySelect']//option")
	public List<WebElement> quantityAsked;
    
	//Link for  adding the item to Wishlist
	@FindBy(xpath = ".//span[@class='z-coast-fjord_interactable z-coast-fjord_wishlistText']")
	public WebElement addToWishlist;

    //Hyperlink for  navigating to Wishlist located on the top panel  
    @FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/wishlist/']")
	public WebElement wishList;

    //Hyperlink for the image of the item
	@FindBy(xpath = ".//div[@id='z-aladdin-cardList']//div[@class='z_wishlist_griddie__block_item___fbCnf ']")
	public WebElement imageItem;
    
	//Hyperlink for Continue Shopping link appears when the  cart is empty
	@FindBy(xpath = ".//a[@class='z-button z-button--primary z-button--link']")
	public WebElement continueShopping;
    
	
	
}
