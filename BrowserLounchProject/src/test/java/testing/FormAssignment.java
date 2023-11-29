package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormAssignment {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Got To URL
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Enter the Name
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Shriram Landage");
		//Enter the Email
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Shriamlandage15@gmail.com");
		//Enter the Password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Shriram Assignment");
		//Click on Check Box
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		//click on Gender Dropdown
		driver.findElement(By.cssSelector("#exampleFormControlSelect1")).click();
		driver.findElement(By.xpath("//option[normalize-space()='Male']")).click();
		System.out.println(driver.findElement(By.xpath("//option[normalize-space()='Male']")).isSelected());
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

		Select abc = new Select(dropdown);

		abc.selectByVisibleText("Female");
		Thread.sleep(2000);
		
		//Click on Student Radio Button
		driver.findElement(By.xpath("//label[normalize-space()='Student']")).click();
		// Date of Birth Dropdown
		driver.findElement(By.name("bday")).sendKeys("02/02/1992");


		
		Thread.sleep(2000);
		
		//Click on SbmidButton
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		// Confirmation massage
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		
		driver.close();
	}

}
