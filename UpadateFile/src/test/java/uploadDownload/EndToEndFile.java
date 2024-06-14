package uploadDownload;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

	public static void main(String[] args) throws IOException {

		String fruitName = "Apple";
		String updatedValue = "900";
		String fileName = "C:\\Users\\ShriramLandage\\Downloads\\download (3).xlsx";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		// Download FIle
		driver.findElement(By.cssSelector("#downloadButton")).click();

		// Edit ecel - getColumnNumber of Price -getRownumber of Apple -> update excel
		// with row, col
		int col = getColumnNumber(fileName, "price");
		int row = getRowNumber(fileName, "Apple");
		Assert.assertTrue(updateCell(fileName, row, col, updatedValue));
		// Upload File
		WebElement upload = driver.findElement(By.xpath("//input[@id='fileinput']"));
		upload.sendKeys("C:\\Users\\ShriramLandage\\Downloads\\download (3).xlsx");

		// wait for success message to sho up and wait for disapper
		By toastLocator = By.cssSelector("div[role='alert'] div:nth-child(2)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

		String toastText = driver.findElement(toastLocator).getText();
		System.out.println(toastText);
		Assert.assertEquals("Invalid Format Given", toastText);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

		// Verifiy updated excel data showing in the web table

		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='" + fruitName
				+ "']/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']")).getText();
		System.out.println(actualPrice);
		Assert.assertEquals(updatedValue, actualPrice);
		// Assert.assertEquals("350", actualPrice);

		driver.close();

	}

	private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		Row rowField = sheet.getRow(row - 1);
		Cell cellField = rowField.getCell(col);

		cellField.setCellValue(updatedValue);
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		workbook.close();
		fis.close();
		return true;

	}

	private static int getRowNumber(String fileName, String text) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// Identify Testcases coloum by scanning the entire 1st row

		Iterator<Row> rows = sheet.iterator(); // Sheet is collection of rows
		int rowIndex = -1;
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			int k = 1;
			

			while (cells.hasNext()) {
				Cell cell = cells.next();
				if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(text))
				{
					rowIndex=k;
				}
			
			}
			k++;
		}
		return rowIndex;

	}

	private static int getColumnNumber(String fileName, String colName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// Identify Testcases coloum by scanning the entire 1st row

		Iterator<Row> rows = sheet.iterator(); // Sheet is collection of rows
		Row firstrow = rows.next();
		Iterator<Cell> ce = firstrow.cellIterator();
		// row is collection of cells

		int k = 1;
		int coloumn = 0;
		while (ce.hasNext()) {
			Cell value = ce.next();

			if (value.getStringCellValue().equalsIgnoreCase(colName)) {
				coloumn = k;
			}
			k++;
		}
		System.out.println(coloumn);
		return coloumn;
		
		}
	
}
