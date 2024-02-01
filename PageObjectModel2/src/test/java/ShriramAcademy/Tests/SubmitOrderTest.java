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

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String productName = "IPHONE 13 PRO";

		LandingPage landingPage = launchApplication();

		ProductCatalogue porduCatalogue = landingPage.loginApplication("webelement@yopmail.com", "India@123");

		List<WebElement> products = porduCatalogue.getProductList();
		porduCatalogue.addProductToCart(productName);
		CartPage cartPage = porduCatalogue.goTocartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		// Scroll Web Page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		Thread.sleep(2000);

		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.close();

	}
}
