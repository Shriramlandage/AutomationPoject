package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.thread.ThreadTimeoutException;

public class StaticDropeDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
		
	       driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	       //Site UEL URL
	       driver.get("https://corporate.spicejet.com/");
	      	       
	  //     driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
	       //Click On From Box
	       driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	       Thread.sleep(3000);
	       
	       //Select Frome city
	       driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[contains(text(),'Pune (PNQ)')]")).click();
	  //     driver.findElement(By.xpath("//a[contains(text(),'Pune (PNQ)')]")).click();
	       
	       //select To city Box
	       driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
	       Thread.sleep(3000);
	       
	       // Select To city option
	       driver.findElement(By.xpath("//div [@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text='Thiruvananthapuram (TRV)']")).click();
	      
	       
	       // Select Depart Date
	       
	       driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
	       
	         
	       // Click on Pasanger Dropdown
	       driver.findElement(By.id("divpaxinfo")).click();
	       
	     WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));
	     
	     Select dropdown = new Select(dropdownElement);
	     dropdown.selectByIndex(7);
	     
			/*  
			 * Below Code is updated new site Code.
			 * int i=1; 
			  while(i<2) {
			  driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click(); i++; }
			 System.out.println(driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).getText());
			  
		     for(int s=1;s<5;s++) {						  
						  driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();
						  System.out.println(driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).getText());		  
					  }
					  driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
					  */
      WebElement CurrencyDropdown= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
	     
	     Select Dropdown=new Select(CurrencyDropdown);
	Dropdown.selectByIndex(7);
	
	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
	
	
	System.out.println(driver.getTitle());
					  Thread.sleep(2000);
					  
				
					  
	       driver.close();
	       
	       
		 
	}
}
