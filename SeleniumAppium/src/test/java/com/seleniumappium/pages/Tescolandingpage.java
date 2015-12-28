package com.seleniumappium.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.seleniumappium.util.Constants;


public class Tescolandingpage {
	
	public WebDriver driver;
	
	@FindBy(xpath=Constants.signin)
	public WebElement signin;
	@FindBy(xpath=Constants.grocerysignin)
	public WebElement grocerysignin;
	
	@FindBy(xpath=Constants.tusername)
	public WebElement tusername;
	@FindBy(xpath=Constants.tpassword)
	public WebElement tpassword;
	
	
	public Tescolandingpage(WebDriver dr){
		driver=dr;
	}

	
	
	public TescoLoginPage gotoLoginPage() throws InterruptedException{
		driver.get("http://Tesco.com"); // config.prop
		// verify title
		try{
			System.out.println("Title" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Constants.titleHomePage);
		}catch(Throwable e){
			System.out.println("error---");
		
		}
		Actions act = new Actions(driver);
		act.moveToElement(signin).build().perform();
		System.out.println("clicked signin before sleep");
		Thread.sleep(6000);
		System.out.println("clicked signin");
		//if (grocerysignin.isDisplayed()== true) {
		
		grocerysignin.click();
		//}
		System.out.println("clicked grocerysignin");
		
		Thread.sleep(5000);
	
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		 System.out.println("tab no's " + tabs2.size());
			driver.getTitle();
		 if (tabs2.size() == 2){
		 driver.switchTo().window(tabs2.get(1));
		 driver.close();
		 driver.switchTo().window(tabs2.get(0));}
		TescoLoginPage TLP = PageFactory.initElements(driver, TescoLoginPage.class);
		return TLP;
	//	}
		
	}

}
