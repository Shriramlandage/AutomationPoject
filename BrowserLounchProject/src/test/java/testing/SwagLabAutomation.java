package testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabAutomation {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String excelFilePath = "C:\\Users\\ShriramLandage\\Downloads\\Testing.xlsx";
		FileInputStream fileInputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();

			driver.get("https://www.saucedemo.com/v1/");
			WebElement usernameElement = driver.findElement(By.id("user-name"));
			WebElement passwordElement = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.id("login-button"));

			usernameElement.sendKeys(username);
			passwordElement.sendKeys(password);

			loginButton.click();

			String[] itemsNeeded = { "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", };
			List<WebElement> products = driver.findElements(By.xpath("//div[@class= 'inventory_item_name']"));

			for (int s = 0; s < products.size(); s++) {
				String name = products.get(s).getText();

				// Convert array into array list for easy search
				// check whether name you extrcted is present in arraylist or ot

				List itemsNeededList = Arrays.asList(itemsNeeded);

				if (itemsNeededList.contains(name)) {
					// click on Add to cart
					driver.findElements(
							By.xpath("(//button[@class='btn_primary btn_inventory'][normalize-space()='ADD TO CART'])"))
							.get(i).click();
					// driver.findElement(By.xpath("//button[text()= 'ADD TO CART']")).get

				}
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']")).click();
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a[normalize-space()='CHECKOUT']")).click();
			FileInputStream fileInputStream1 = new FileInputStream(excelFilePath);
			Workbook workbook1 = new XSSFWorkbook(fileInputStream1);
			Sheet sheet1 = workbook1.getSheetAt(0);

			// Check if row1 and the relevant cells are not null
			if (row != null && row.getCell(2) != null && row.getCell(3) != null && row.getCell(4) != null) {

				String firstname = row.getCell(2).getStringCellValue();
				String lastname = row.getCell(3).getStringCellValue();
				String zipcode = row.getCell(4).getStringCellValue();

				// Add a method to convert cell value to string
				WebElement firstnametext = driver.findElement(By.id("first-name"));
				WebElement lastnametext = driver.findElement(By.id("last-name"));
				WebElement zipcodetext = driver.findElement(By.id("postal-code"));

				// Clear text fields before entering new values
				firstnametext.clear();
				lastnametext.clear();
				zipcodetext.clear();

				// Send keys to the correct text fields
				firstnametext.sendKeys(firstname);
				lastnametext.sendKeys(lastname);
				zipcodetext.sendKeys(zipcode);

				driver.findElement(By.cssSelector("input[value='CONTINUE']")).click();

				driver.findElement(By.xpath("//a[normalize-space()='FINISH']")).click();
				System.out.println(driver.getTitle());
			}
			if (driver.getTitle().equals("Swag Labs")) {
				System.out.println("Successfully completed the process.");
				break;
			} else {
				System.out.println("Unexpected redirection. Exiting the program.");
			}

		} // driver.close();
	}
}
