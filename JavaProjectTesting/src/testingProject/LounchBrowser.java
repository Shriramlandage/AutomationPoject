package testingProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LounchBrowser {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.edge.driver", "C:\\Automation\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.w3schools.com");
		
	
	
	
	
	}

}
