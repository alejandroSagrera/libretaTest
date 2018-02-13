package libretaElectronica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject.PageObject;

public class ReceiptPage extends PageObject {

	@FindBy(tagName = "img")
	private WebElement portada;
	
	@FindBy(tagName = "h4")
	private WebElement header;
	
	public ReceiptPage(WebDriver driver) {
		super(driver);
	}
	public boolean isInitialized() {
		return portada.isDisplayed();
	}
	

}
