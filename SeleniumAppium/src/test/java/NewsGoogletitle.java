import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
 
public class NewsGoogletitle  {
 
       public static void main(String[] args) {
       
 
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\toshiba\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
       
                     WebDriver driver = new ChromeDriver();
             
               driver.get("http://news.google.com/");
 
             
           
               System.out.println("Page title is: " + driver.getTitle());
 
               List<WebElement> headlines = driver.findElements(By.xpath("//div[@class='esc-lead-article-title-wrapper']"));
              
                            
              System.out.println("*************************************** HeadLines"+"(Count:"+headlines.size()+")"+"*************************************************");
             
              for (int i = 0;i < headlines.size();i++){
                 
                 WebElement headline = headlines.get(i);
                 System.out.println(headline.getText() );
              }
             
              System.out.println("******************************************************************************************************************");
             
               driver.quit();
             
       }
 
}