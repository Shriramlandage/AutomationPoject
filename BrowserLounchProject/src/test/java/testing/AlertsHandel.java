package testing;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandel {

	public static void main(String[] args) throws InterruptedException {
		String text="Shriam";
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#name")).sendKeys(text);
	    Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
	    Thread.sleep(2000);
	    
	    System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("#name")).sendKeys(text);
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("#name")).sendKeys(text);
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.close();
		
		
		
		
		
		
		
	}
}
