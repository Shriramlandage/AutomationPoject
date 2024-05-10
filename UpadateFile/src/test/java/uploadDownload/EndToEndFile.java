package uploadDownload;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndFile {

	public static void main(String[] args) {

		
		String fruitName = "Banana";
		String fileName = "C:\\Users\\ShriramLandage\\Downloads\\download.xlsx";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		

		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		// Download FIle
		driver.findElement(By.cssSelector("#downloadButton")).click();

		//Edit ecel - getColumnNumber of Price -getRownumber of  Apple -> update excel with row, col
		int col =getColumnNumber(fileName,"price");
		int row =getRowNumber(fileName,"Apple");
		updateCell(fileName,row,col,"599");
		
		// Upload File
		WebElement upload = driver.findElement(By.xpath("//input[@id='fileinput']"));
		upload.sendKeys("C:\\Users\\ShriramLandage\\Downloads\\download.xlsx");

		// wait for success message to sho up and wait for disapper
		By toastLocator = By.cssSelector("div[role='alert'] div:nth-child(2)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

		String toastText = driver.findElement(toastLocator).getText();
		System.out.println(toastText);
		Assert.assertEquals("Updated Excel Data Successfully.", toastText);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

		// Verifiy updated excel data showing in the web table

		String priceColumn= driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
		System.out.println(actualPrice);
		Assert.assertEquals("345", actualPrice);
		//Assert.assertEquals("350", actualPrice);
	
		driver.close();

	}

	private static void updateCell(String fileName, int row, int col, String string) {
		// TODO Auto-generated method stub
		
	}

	private static int getRowNumber(String fileName, String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int getColumnNumber(String fileName, String string) {
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

				XSSFSheet sheet = workbook.getSheet("Sheet1");
				// Identify Testcases coloum by scanning the entire 1st row

				java.util.Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				java.util.Iterator<Cell> ce = firstrow.cellIterator();

				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("testdata")) {
						coloumn = k;
					}
					k++;
				}
				System.out.println(coloumn);		return 0;
	}
}
