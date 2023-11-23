package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) throws Exception {
		
		 System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
	        
	       driver.manage().window().maximize();
	       driver.get("https://www.airindia.com/");
	       System.out.println(driver.getTitle());
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//label[@for='mat-radio-2-input']//span[@class='mat-radio-outer-circle']")).click();
 
	       Thread.sleep(2000);
	       
	       driver.close();
	}

}
