package detaDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestSample {

	public static void main(String[] args) throws IOException {
		
		
		DrivenData d=new DrivenData();
		ArrayList<String> data=d.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
		
		
		
		
		
		
		
		
	}

}
