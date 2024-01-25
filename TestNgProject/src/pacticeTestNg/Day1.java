package pacticeTestNg;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

	@AfterTest
	public void lastexecution() {
		System.out.println("I will execute last");
	}
	
	
	@Test (groups= {"Smoke"})
	public void Demo() {
		System.out.println("Hello TestNg");
	}

	@AfterSuite
	public void afSuite() {
		System.out.println("I am no 1 from last = After Suite");
	}
	@Test 
	public void SecondDemo() {

		System.out.println("lets a create");
	}
}
