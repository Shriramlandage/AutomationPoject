package testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide {
	
	@Test(dataProvider = "driveTest")
	public void testData(String greeting, String communication, String id)
	{
		System.out.println(greeting+communication+id);
	}
	@DataProvider(name="driveTest")
	public Object[][] getData()
	{
	 Object[][] data= {{"hello", "text", 123}, {"testing","providngdata",987},{"solo","call",7362}};
	return data;
	
	}
}
