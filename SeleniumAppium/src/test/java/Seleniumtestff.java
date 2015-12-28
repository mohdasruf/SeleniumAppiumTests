import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Seleniumtestff {
	
	public static WebDriver driver = null;
	public static String profileff = "/Users/mohamedasruf/Library/Application Support/Firefox/Profiles/lwutr29o.QAAutomation";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File profileDirectory = new File(profileff);
		
		FirefoxProfile profile = new FirefoxProfile(profileDirectory);
		
		driver = new FirefoxDriver(profile);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		        //Launch the Online Store Website

		        driver.get("http://www.store.demoqa.com");

		        // Find the element that's ID attribute is 'account'(My Account) 

		        driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		        // Find the element that's ID attribute is 'log' (Username)

		        // Enter Username on the element found by above desc.

		        driver.findElement(By.id("log")).sendKeys("testuser_1"); 

		        // Find the element that's ID attribute is 'pwd' (Password)

		        // Enter Password on the element found by the above desc.

		        driver.findElement(By.id("pwd")).sendKeys("Test@123");

		        // Now submit the form. WebDriver will find the form for us from the element 

		        driver.findElement(By.id("login")).click();

		        // Print a Log In message to the screen

		        System.out.println("Login Successfully");

		        // Find the element that's ID attribute is 'account_logout' (Log Out)

		        driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();

		        // Print a Log In message to the screen

		        System.out.println("LogOut Successfully");

		        // Close the driver

		        driver.quit();

			}
	}
	