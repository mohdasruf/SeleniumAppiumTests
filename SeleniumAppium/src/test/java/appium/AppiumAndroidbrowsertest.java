package appium;
import java.net.MalformedURLException;  
import java.net.URL;  
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
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
  
/** 
 A test to demonstrate the automation on Safari browser using Appium [the open source tool] 
*/  
public class AppiumAndroidbrowsertest {  
 WebDriver wd;  
  
 @BeforeTest  
 public void beforeTest() throws MalformedURLException { //set capabilities required  
  DesiredCapabilities cap = new DesiredCapabilities();  
  cap.setCapability("deviceName", "Nexus 7");  
  cap.setCapability("platformName", "Android");  
  cap.setCapability("platformVersion", "4.4.2");  
  cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");  
  wd = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);//instantiate driver  
  wd.manage().timeouts().implicitlyWait( 30,TimeUnit.SECONDS);  
 }  
  
 @Test  
 public void testSearchPage() throws InterruptedException {  
  wd.get("https://www.google.co.in");  
  WebElement element = wd.findElement(By.name("q"));  
  element.sendKeys("Big Data");  
  element.sendKeys(Keys.ENTER); 
  //comment
    
 }  
  
 @AfterTest  
 public void afterTest() {  
  wd.close();  
 }  
}  