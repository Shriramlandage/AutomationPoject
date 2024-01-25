package testing;

import java.util.Properties;

import org.openqa.selenium.support.ui.Select;

public class CheckSeleniumVersion {

	
	
	 public static void main(String[] args) {
	        Properties properties = System.getProperties();
	        String version = properties.getProperty("selenium.version");
	        System.out.println("The current Selenium version is: " + version);
	}

}
