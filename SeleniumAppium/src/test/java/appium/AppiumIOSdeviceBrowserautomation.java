package appium;

import java.net.MalformedURLException;  
import java.net.URL;  
import java.util.concurrent.TimeUnit;  
import io.appium.java_client.ios.IOSDriver;  
import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.remote.CapabilityType;  
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.testng.annotations.Test;  
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.AfterTest;  
  
public class AppiumIOSdeviceBrowserautomation {  
 WebDriver wd;  
  
 @BeforeTest  
 public void beforeTest() throws MalformedURLException {   
  DesiredCapabilities capabilities = new DesiredCapabilities();  
  capabilities.setCapability("deviceName", "iPhone 6s");  
  capabilities.setCapability("platformName", "iOS");  
  capabilities.setCapability("platformVersion", "9.0");  
  capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");  
  wd = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);//instantiate driver  
  wd.manage().timeouts().implicitlyWait( 30,TimeUnit.SECONDS);  
 }  
  
 @Test  
 public void testSearchPage() throws InterruptedException {  
  wd.get("https://www.google.co.uk");  
 WebElement element = wd.findElement(By.name("q"));  
 element.sendKeys("Big data");  
  element.sendKeys(Keys.ENTER);  
  Thread.sleep(10000);
  System.out.println(wd.getCurrentUrl());  
 }  
  
 @AfterTest  
 public void afterTest() {  
	 wd.close();  
 }  
}  