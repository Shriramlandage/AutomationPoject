package testing;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterStream {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParanteID = it.next();
		String ChildID = it.next();
		driver.switchTo().window(ChildID);
		
		driver.findElement(By.id("search-field")).sendKeys("Tomato");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		//1 results
		List<WebElement> filteredList=veggies.stream().filter(veggie->veggie.getText().contains("Tomato"))
				.collect(Collectors.toList());

		Assert.assertEquals(veggies.size(), filteredList.size());
		
		System.out.println(filteredList);
		
		
		
		
	}
}
