package appium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

public class SampleSauceTest_ios_browserautomation {

	WebDriver driver = null;


@BeforeClass
public void setUp() throws Exception {
	 String sauceUserName = "Your SauceLabs User Name";
	    String sauceAccessKey = "Your SauceLabs Access Key";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS 6.0");
    capabilities.setCapability("device", "iPhone Simulator");
    capabilities.setCapability(CapabilityType.PLATFORM, "Mac 10.8");

    
    driver = new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)),
            capabilities);
}

@Test
public void example() throws Exception {
	driver.get("http://google.com");
	WebElement elem = driver.findElement(By.name("q"));
	
	elem.sendKeys("Big Data");
	elem.sendKeys(Keys.ENTER);
	
	
}

@AfterClass
public void closedriver(){
	driver.quit();
}
}