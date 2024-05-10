package testing;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Link_Count {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.iansanderson.co.uk/contactus.php?page=contactus");
		System.out.println(driver.findElements(By.tagName("a")).size()); 

//		WebElement footerdriver = driver.findElement(By.xpath("//footer[@class='sitemap']"));
//		System.out.println(footerdriver.findElements(By.tagName("a")).size());
//		WebElement coloumdriver = footerdriver.findElement(By.xpath("//div[@class='col-sm-6'][1]"));
//		System.out.println(coloumdriver.findElements(By.tagName("a")).size());

		for (int i = 0; i < driver.findElements(By.tagName("a")).size(); i++) {

			String clickonlinksTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinksTab);
			Thread.sleep(2000);
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

}

}
