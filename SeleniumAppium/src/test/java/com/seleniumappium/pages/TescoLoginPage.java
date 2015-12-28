package com.seleniumappium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumappium.util.Constants;


public class TescoLoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath=Constants.tusername)
	public WebElement tusername;
	@FindBy(xpath=Constants.tpassword)
	public WebElement tpassword;
	
	
	public TescoLoginPage(WebDriver dr){
		driver=dr;
	}

	
	
	public TescoMainPage doLogin(String uName, String pWord){
		
		tusername.clear();
		tusername.sendKeys(uName);
		tpassword.sendKeys(pWord);
		tpassword.sendKeys(Keys.ENTER);
	
		TescoMainPage MainPage = PageFactory.initElements(driver, TescoMainPage.class);
		return MainPage;
				
	}

}
