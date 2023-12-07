package detaDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelDataDriven {

	// Identify Testcases coloum by scaning the entire 1st row
	// Pnce coloun is indentified then scan entire testcase coloum to identify
	// purchase testcase row
	// after you grab purchase testcase row=pull all the data of that row and feed
	

	public static void main(String[] args) throws IOException {

		// File Input Stream argument
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\ShriramLandage\\Downloads\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++)

		{
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
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
				System.out.println(coloumn);

				while (rows.hasNext()) 
				{
					Row r=rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Purchase")) 
					{
					//after you grab purchase testcase row = pull all the data of that row and feed into test
					java.util.Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext()) 
						{
						a.add(cv.next().getStringCellValue());
						}
					}
				}
			}
		}
	}
}
