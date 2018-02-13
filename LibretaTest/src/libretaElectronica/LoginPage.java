package libretaElectronica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import pageObject.PageObject;

public class LoginPage extends PageObject {

	@FindBy(id="Ci")
	private WebElement usr;
	
	@FindBy(id="Contrase_a")
	private WebElement passw;
	
	@FindBy(id="Acceder")
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return usr.isDisplayed();
	}
	
	public void enterCredentials(String usr, String passw){
		this.usr.clear();
		this.usr.sendKeys(usr);

		this.passw.clear();
		this.passw.sendKeys(passw);
	}
	public String hover(WebDriver driver) {
		Actions accion = new Actions(driver);
		accion.moveToElement(usr).perform();
		return usr.getAttribute("title");
	}
	public ReceiptPage submit(){
		submitButton.click();
		return new ReceiptPage(driver);
	}
}