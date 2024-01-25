package pacticeTestNg;

import org.testng.annotations.Test;

public class Day4 {
	
	
	//enabled=false = this method use to skipp perticular test case.
	@Test (enabled= false)
	public void WebloginHomeLoan() {
		System.out.println("WebloginHomeLoan");		
	}
	
	@Test	(groups= {"Smoke"})
	public void MobileloginHomeLoan()
	{
		System.out.println("MobileloginHomeLoan");
	}
	
	@Test (dependsOnMethods={"BikeLoan"})
	public void LoginAPIHomeloan()
	{
		System.out.println("LoginAPIHomeloan");
	}

	//(timeOut=----) mens before thwing the error massage.
	@Test (timeOut=4000)
	public void BikeLoan()
	{
		System.out.println("BikeLoan");
	}
	
}
