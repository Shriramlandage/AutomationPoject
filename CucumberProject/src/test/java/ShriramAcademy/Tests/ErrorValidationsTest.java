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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ShriramAcademy.TestComponents.BaseTest;
import ShriramAcademy.TestComponents.Retry;
import ShriramAcademy.pageobject.CartPage;
import ShriramAcademy.pageobject.CheckOutPage;
import ShriramAcademy.pageobject.ConfirmationPage;
import ShriramAcademy.pageobject.LandingPage;
import ShriramAcademy.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		String productName = "IPHONE 13 PRO";
		landingPage.loginApplication("webelement01@yopmail.com", "India@113");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String productName = "IPHONE 13 PRO";
		ProductCatalogue porduCatalogue = landingPage.loginApplication("webelement@yopmail.com", "India@123");
		List<WebElement> products = porduCatalogue.getProductList();
		porduCatalogue.addProductToCart(productName);
		CartPage cartPage = porduCatalogue.goTocartPage();

		Boolean match = cartPage.VerifyProductDisplay("IPHONE 13 PRO");
		Assert.assertTrue(match);
	}
}
