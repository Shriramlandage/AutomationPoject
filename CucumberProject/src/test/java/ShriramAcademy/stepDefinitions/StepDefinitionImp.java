package ShriramAcademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ShriramAcademy.TestComponents.BaseTest;
import ShriramAcademy.pageobject.CartPage;
import ShriramAcademy.pageobject.CheckOutPage;
import ShriramAcademy.pageobject.ConfirmationPage;
import ShriramAcademy.pageobject.LandingPage;
import ShriramAcademy.pageobject.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImp extends BaseTest {

	public LandingPage landingPage ;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.loginApplication(username, password);
	}
	
	@When ("^I add product(.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$ ")
	public void checkout_submit_order(String productName) throws InterruptedException 
	{
		CartPage cartPage = productCatalogue.goTocartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		Thread.sleep(2000);

		// Scroll Web Page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);

		confirmationPage = checkoutPage.submitOrder();
	}

	@Then ("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationPage.equalsIgnoreCase(string));
	}
		@Then ("^\"([^\"]*)\" message is displayed$")
		public void something_message_is_displayed(String strArg1) throws Throwable
		{
			Assert.assertEquals(strArg1, landingPage.getErrorMessage());
			driver.close();
		}
	
}
