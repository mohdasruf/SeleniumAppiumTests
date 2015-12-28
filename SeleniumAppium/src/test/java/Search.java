import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
 
 
public class Search  {
 
       public static void main(String[] args) {
       
 
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
       
    	             WebDriver driver = new ChromeDriver();
             
               driver.get("http://www.google.com");
               driver.findElement(By.xpath("//*[@id='coupon']/ul/li[8]/a")).click();
  
             
           
               System.out.println("Page title is: " + driver.getTitle());
 
               List<WebElement> headlines = driver.findElements(By.xpath("//*[@id='bettinghomenews']/table/tbody/tr/td[1]/a"));
              
                            
              System.out.println("*************************************** HeadLines"+"(Count:"+headlines.size()+")"+"*************************************************");
             
              for (int i = 0;i < headlines.size();i++){
                 
                 WebElement headline = headlines.get(i);
                 System.out.println(headline.getText() );
              }
             
              System.out.println("******************************************************************************************************************");
             
               driver.quit();
             
       }
 
}