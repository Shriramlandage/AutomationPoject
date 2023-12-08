package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class dataDriven {

	 private WebDriver driver;
	    private Workbook workbook;
	    private Sheet sheet;
	    private int rowNum = 0;

	    @BeforeTest
	    public void setUp() {
	        // Set the path to the chromedriver executable
	    	System.setProperty("webdriver.chrome.driver",
					"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	        // Initialize ChromeDriver
	     WebDriver   driver = new ChromeDriver();

	        // Initialize Excel workbook and sheet
	        workbook = new XSSFWorkbook();
	        sheet = workbook.createSheet("TestResults");
	    }

	    @Test
	    public void verifyTitle() {
	        // Navigate to the web page

	    	driver.get("https://www.saucedemo.com/v1/");
	        // Get the actual title
	        String actualTitle = driver.getTitle();

	        // Define the expected title
	        String expectedTitle = "https://www.saucedemo.com/v1/";

	        // Compare actual and expected titles
	        boolean testResult = actualTitle.equals(expectedTitle);

	        // Write test results to Excel
	        writeTestResultToExcel("verifyTitle", testResult);
	    }

	    @AfterTest
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();

	            // Save Excel file
	            try (FileOutputStream fileOut = new FileOutputStream(new String("C:\\Users\\ShriramLandage\\Downloads\\Testing.xlsx")))
	            {
	                workbook.write(fileOut);
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void writeTestResultToExcel(String testName, boolean testResult) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(testName);
	        row.createCell(1).setCellValue(testResult ? "Pass" : "Fail");
	    }
	}