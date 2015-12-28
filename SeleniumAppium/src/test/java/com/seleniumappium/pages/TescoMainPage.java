package com.seleniumappium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.seleniumappium.testcases.*;
import com.seleniumappium.util.Constants;


public class TescoMainPage extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(xpath=Constants.gotofullsite)
	public WebElement gotofullsite;
	
	@FindBy(xpath=Constants.buttonok)
	public WebElement buttonok;
	
	@FindBy(xpath=Constants.multisearch)
	public WebElement multisearch;
	
	@FindBy(xpath=Constants.Notepad)
	public WebElement Notepad;
	
	@FindBy(xpath=Constants.findtheseitems)
	public WebElement findtheseitems;
	
	@FindBy(xpath=Constants.addbutton)
	public WebElement addbutton;
	
	@FindBy(xpath=Constants.addbuttonframe)
	public WebElement addbuttonframe;
		
	@FindBy(partialLinkText=Constants.backtopreviousscreen)
	public WebElement btps;
	
	@FindBy(partialLinkText=Constants.select1)
	public WebElement select1;
	
	@FindBy(partialLinkText=Constants.select2)
	public WebElement select2;
	
	@FindBy(partialLinkText=Constants.select3)
	public WebElement select3;
	
	@FindBy(partialLinkText=Constants.select4)
	public WebElement select4;
	
	@FindBy(partialLinkText=Constants.EmptyBasket)
	public WebElement EmptyBasket;
	
	@FindBy(xpath=Constants.EBOK)
	public WebElement EBOK;
	
		
	public TescoMainPage(WebDriver dr){
		driver=dr;
	}

	
	
	public void Searchitems(String Itemstosearch) throws InterruptedException{
		
		try{
			System.out.println("Title" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Constants.titleHomePage);
		}catch(Throwable e){
			System.out.println("error---");
		
		}
		
		if(CONFIG.getProperty("browser").equals("Android")){
		gotofullsite.click();
		Thread.sleep(15000);
		Actions act = new Actions(driver);
		act.click(buttonok).build().perform();
		System.out.println("clicked button");}
		//buttonok.click();
		multisearch.click();
		Notepad.clear();
		Notepad.sendKeys(Itemstosearch);
		Thread.sleep(3000);
		findtheseitems.click();
	
		
		
	}
	


public void SelectItems(String Item) throws InterruptedException {
	// TODO Auto-generated method stub
	driver.findElement(By.partialLinkText(Item)).click();
	Thread.sleep(3000);
	List<WebElement> buttons= driver.findElements(By.xpath(Constants.addbutton));
	System.out.println("number of buttons:" + buttons.size());
	addbutton.click();
	btps.click();
	

}


public void itemselect(String Element)
{
	driver.findElement(By.partialLinkText(Element)).click();;
}


public void emptybasket(){
	EmptyBasket.click();
	EBOK.click();
}
}
