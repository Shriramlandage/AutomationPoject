package testing;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Link_Count {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://threegates.ie/");
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
