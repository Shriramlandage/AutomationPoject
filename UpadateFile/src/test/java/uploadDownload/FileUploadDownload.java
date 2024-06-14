package uploadDownload;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadDownload {

	public static void main(String[] args) {

		
		String fruitName = "Apple";
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		

		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		// Download FIle
		driver.findElement(By.cssSelector("#downloadButton")).click();

		// Upload File
		WebElement upload = driver.findElement(By.xpath("//input[@id='fileinput']"));
		upload.sendKeys("C:\\Users\\ShriramLandage\\Downloads\\download (25).xlsx");

		// wait for success message to sho up and wait for disapper
		By toastLocator = By.cssSelector("div[role='alert'] div:nth-child(2)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

		String toastText = driver.findElement(toastLocator).getText();
		System.out.println(toastText);
		Assert.assertEquals("Updated Excel Data Successfully.", toastText);
 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

		// Verifiy updated excel data showing in the web table

		String priceColumn= driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
		System.out.println(actualPrice);
		Assert.assertEquals("350", actualPrice); 
		//Assert.assertEquals("350", actualPrice);
	
		driver.close();

	}
}
