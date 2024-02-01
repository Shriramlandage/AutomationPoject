package ShriramAcademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ShriramAcademy.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		// properties Class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\ShriramAcademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// edge prope
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Edge
			System.setProperty("webdriver.chrome.driver", "Edge.exe");
			 driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
}
