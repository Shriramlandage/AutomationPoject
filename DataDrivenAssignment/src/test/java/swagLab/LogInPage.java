package swagLab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Credionsiol d = new Credionsiol();
		ArrayList<String> data = d.getData("Loginpage");

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys(data.get(1));
		driver.findElement(By.id("password")).sendKeys(data.get(2));
		driver.findElement(By.id("login-button")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.cssSelector("#checkout")).click();

		Credionsiol add= new Credionsiol();
		ArrayList<String> addres = d.getData("Address");
		driver.findElement(By.id("first-name")).sendKeys(addres.get(1));
		driver.findElement(By.id("last-name")).sendKeys(addres.get(2));
		driver.findElement(By.id("postal-code")).sendKeys(addres.get(3));
		
		driver.findElement(By.id("continue")).click();

		driver.findElement(By.xpath("//button[@id='finish']")).click();
		System.out.println(driver.getTitle());

	

	if (driver.getTitle().equals("Swag Labs")) {
		System.out.println("Successfully completed the process.");
		
	} else {
		System.out.println("Unexpected redirection. Exiting the program.");
	}

}

}
		
		
		//driver.findElement(By.xpath("//button[text()= 'ADD TO CART']")).click();
		//driver.close();

	

	
	
