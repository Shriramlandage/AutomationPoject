package ShriramAcademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ShriramAcademy.TestComponents.BaseTest;
import ShriramAcademy.pageobject.CartPage;
import ShriramAcademy.pageobject.CheckOutPage;
import ShriramAcademy.pageobject.ConfirmationPage;
import ShriramAcademy.pageobject.LandingPage;
import ShriramAcademy.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String productName = "IPHONE 13 PRO";
		 landingPage.loginApplication("webelement01@yopmail.com", "India@113");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
	}
}
