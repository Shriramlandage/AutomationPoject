package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");

		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("pune");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//text[normalize-space()='Pune']")).click();
		driver.findElement(By.id("dest")).sendKeys("Bhoom");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='sc-iwsKbI jTMXri cursorPointing']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sc-kAzzGY llxTcS']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("search_button")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);

		driver.close();
	}

}
