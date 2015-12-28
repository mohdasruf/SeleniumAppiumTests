package appium;


import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppiumiOSDeviceAppautomation {
	
	public static IOSDriver driver;
	
	public static void main (String[] args) throws MalformedURLException, InterruptedException {
		
	    File appDir = new File("/Users/XXX/Library/Developer/Xcode/DerivedData/UIKitCatalog-defcjfmdlbujldfimcsiqxatxxqb/Build/Products/Debug-iphonesimulator/");
	    File app = new File(appDir, "UIKitCatalog.app");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "9.0"); //Replace this with your iOS version
		caps.setCapability("deviceName", "iPhone 6s"); //Replace this with your simulator/device version
		caps.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
		
		System.out.println("Success");

		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		driver.findElement(By.name("Back")).click();
	
	

		driver.quit();
	
	
}
}
