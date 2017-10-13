package com.sudha.shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishList {

	
	public WishList(WebDriver driver) {
	      
        PageFactory.initElements(driver, this);
        
    }
	
	@FindBy(xpath=".//span[contains(@class,'SwitchPanel__iconList')]")
	public WebElement switchPanel;
	
	@FindBy(xpath=".//div[contains(@class,'iconClose z_wishlist_ArticleDetail')]")
	public WebElement removeIcon;
	
	@FindBy(xpath=".//div[@class='z-navicat-header_userAccNaviItem']//a[@href='/wishlist/']")
	public WebElement wishList;
}
