package Maven_ShriramAcademy;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobile_Emulatore {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();

		devTools.send(org.openqa.selenium.devtools.v123.emulation.Emulation.setDeviceMetricsOverride(360, 740, 75, true, null, null, null, null, null, null, null,
				null, null, null));
		
		driver.get("https://www.w3schools.com/");
		driver.findElement(By.cssSelector("a[title='Menu'][aria-label='Menu']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Spaces']")).click();
	}
}
