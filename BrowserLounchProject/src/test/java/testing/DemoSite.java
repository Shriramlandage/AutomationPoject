package testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSite {
	 @Test
	    public void verifyTitle() {
	        // Set the path to the chromedriver executable
		 System.setProperty("webdriver.chrome.driver",
					"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();


	        // Navigate to the web page
	        driver.get("https://www.selenium.dev/");

	        // Get the actual title
	        String actualTitle = driver.getTitle();
	        System.out.println(driver.getTitle());

	        // Define the expected title
	        String expectedTitle = "Selenium";

	        // Compare actual and expected titles
	       // Assert.assertEquals(actualTitle, expectedTitle, "Title_missmatch");

	        Assert.assertEquals(expectedTitle, actualTitle);
	        // Close the browser
	        driver.quit();
	    }
	}

