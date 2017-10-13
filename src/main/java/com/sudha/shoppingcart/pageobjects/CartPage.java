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

	@FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/cart/']")
	public WebElement cart;

	@FindBy(xpath = ".//select[@class='z-coast-fjord_quantitySelect']")
	public WebElement quantity;

	@FindBy(xpath = ".//select[@class='z-coast-fjord_quantitySelect']")
	public WebElement quantityBox;

	@FindBy(xpath = ".//select[@class='z-coast-fjord_quantitySelect']//option")
	public List<WebElement> quantityAsked;

	@FindBy(xpath = ".//span[@class='z-coast-fjord_interactable z-coast-fjord_wishlistText']")
	public WebElement addToWishlist;

	@FindBy(xpath = ".//span[@class='z-text z-text-detail-text-regular z-text-black']")
	public WebElement verifyText;

	@FindBy(xpath = ".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/wishlist/']")
	public WebElement wishList;

	@FindBy(xpath = ".//div[@id='z-aladdin-cardList']//div[@class='z_wishlist_griddie__block_item___fbCnf ']")
	public WebElement imageItem;

	@FindBy(xpath = ".//a[@class='z-button z-button--primary z-button--link']")
	public WebElement continueShopping;

	@FindBy(xpath = ".//div[@class='z_wishlist_ArticleCard__icon_close___ynls0 z_wishlist_icon__icon_remove___1YAnw z_wishlist_icon__icon___1PeMX z_wishlist_icon__icon-close___M326s']")
	public WebElement removeIcon;
}
