package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll Web Page
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		//.left-align th:nth-child(3)

		// Use to scroll table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		Thread.sleep(2000);

		
		//Find Perticular low usin with Absoulate expath
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		for (int i=0;i<values.size();i++)
		{
		System.out.println(sum = sum +Integer.parseInt(values.get(i).getText()))	;			
		}
		
		driver.findElement(By.cssSelector(".totalAmount")).getText();

		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		
		driver.close();
		
	}
}
