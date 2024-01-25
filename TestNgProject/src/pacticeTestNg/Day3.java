package pacticeTestNg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Day3 {
	
	@Parameters({"URL"})
	@Test
	public void WeblogincarLoan(String urlname) {
		System.out.println("WeblogincarLoan");
		System.out.println(urlname);
	}
	
	@Test (groups= {"Smoke"})
	public void MobileloginCarLoan()
	{
		System.out.println("MobileloginCarLoan");
	}
	
	@BeforeMethod
	public void beforeevery () {
		System.out.println("I am a Before Method");
	}
	
	@BeforeSuite
	public void Bfsuite() {
		System.out.println("I am no 1 = like before suite");
	}
	
	@Test(dataProvider ="getdata")
	public void LoginAPICarloan(String username, String password)
	{
		System.out.println("LoginAPICarloan");
		System.out.println(username);
		System.out.println(password);
	}

	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[3][2];
		
		//1st set
		data[0][0]="First set Username";
		data[0][1]="First username passward";
		
		//2nd Set
		data[1][0]="Secound set Username";
		data[1][1]="Secound username passward";
		
		//3rd Set
		data[2][0]="Thirde set Username";
		data[2][1]="Thirde username passward";
		return  data;
	}
}
