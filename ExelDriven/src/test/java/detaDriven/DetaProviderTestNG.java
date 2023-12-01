package detaDriven;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class DetaProviderTestNG {
	
	@Test(dataProvider="driverTest")
	public void testcaseData(String greeting,String communication, int id)
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
