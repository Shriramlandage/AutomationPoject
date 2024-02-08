package ShriramAcademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ShriramAcademy.TestComponents.BaseTest;
import ShriramAcademy.pageobject.CartPage;
import ShriramAcademy.pageobject.CheckOutPage;
import ShriramAcademy.pageobject.ConfirmationPage;
import ShriramAcademy.pageobject.LandingPage;
import ShriramAcademy.pageobject.OrderPage;
import ShriramAcademy.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

	String productName = "IPHONE 13 PRO";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goTocartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		
		// Scroll Web Page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		Thread.sleep(2000);

		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() 
	{
		ProductCatalogue produCatalogue = landingPage.loginApplication("webelement@yopmail.com", "India@123");
		OrderPage ordersPage = produCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}

	// Using test multipule user
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dirf") + "src\\test\\java\\ShriramAcademy\\data\\PurchaseOrder.json\\");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

//		HashMap<String,String> map =new HashMap<String,String>();
//		map.put("email", "webelement@yopmail.com");
//		map.put("password", "India@123");
//		map.put("product", "IPHONE 13 PRO");
//		
//		HashMap<String,String> map1 =new HashMap<String,String>();
//		map1.put("email", "webdriver@yopmail.com");
//		map1.put("password", "Admin@123");
//		map1.put("product", "ZARA COAT 3");
		
	}

}
