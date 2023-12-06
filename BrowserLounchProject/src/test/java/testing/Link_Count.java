package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Link_Count {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://theccat.ca/");
		System.out.println(driver.findElements(By.tagName("a")).size());
	}

}
