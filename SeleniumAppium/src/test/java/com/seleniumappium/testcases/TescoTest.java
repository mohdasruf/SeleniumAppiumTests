
package com.seleniumappium.testcases;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.util.Hashtable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumappium.pages.TescoLoginPage;
import com.seleniumappium.pages.TescoMainPage;
import com.seleniumappium.pages.Tescolandingpage;
import com.seleniumappium.util.Constants;
import com.seleniumappium.util.Testutil;

@SuppressWarnings("unused")
public class TescoTest extends TestBase{
	TescoLoginPage TLP=null;
	TescoMainPage mp = null;
	
	WebDriver driver=null;
	
	 
	 
	
	@Test(dataProvider="getLoginData")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException, MalformedURLException{
		if(!Testutil.isExecutable("TescoLoginTest", xls) || data.get("Runmode").equals("N"))
		throw new SkipException("Skipping the test");
		
		System.out.println("************************************************");

			
		initConfigurations();
		driver = initDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Tescolandingpage TLP = PageFactory.initElements(driver, Tescolandingpage.class);
		TescoLoginPage LP = TLP.gotoLoginPage();
		
		mp = LP.doLogin(data.get("Username"),data.get("Password"));
		
	
		mp.Searchitems(data.get("ItemstoSearch"));
		
		
		for (int i=1;i<=5;i++)
			
		{
			String Item = "Item" + i;
			mp.SelectItems(data.get(Item));
					
			String Select = "Select" + i;
			mp.itemselect(data.get(Select));
		}
		
		mp.emptybasket();
		quitDriver();
		
			}

	
	@DataProvider
	public Object[][] getLoginData(){
		return Testutil.getData("TescoLoginTest", xls);
	}
	
		
	@AfterTest
	public void finish(){
			 System.out.println("Have a nice day");
	}
	
	
}
