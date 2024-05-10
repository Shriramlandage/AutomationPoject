package ShriramAcademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shriramcademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement ConfirmationMessage;

	public String verifyConfirmationMessage() {
		return ConfirmationMessage.getText();
	}
 
	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equalsIgnoreCase(String string) {
		// TODO Auto-generated method stub
		return true;
	}


}