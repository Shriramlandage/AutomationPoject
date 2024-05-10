package detaDriven;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DetaProviderTestNG {
	
	@Test(dataProvider="driverTest")
	public void testCaseData(String greeting,String communication, int id)
	{
		System.out.println(greeting+communication+id);
	}

	@DataProvider(name="driverTest")
	public Object[][] getData()
	{
	 Object[][] data= {{"hello", "text", 32}, {"testing","providngdata",342},{"solo","call",4342}};
	return data;
	
	}
}
