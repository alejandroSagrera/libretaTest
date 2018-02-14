package libretaElectronica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import pageObject.PageObject;

public class CambiarPassword extends PageObject {

	@FindBy(id="passwActual")
	private WebElement actualPassw;
	
	@FindBy(id="newPassw")
	private WebElement newPassw;
	
	@FindBy(id="confirmPassw")
	private WebElement confirmPassw;
	
	@FindBy(xpath="/html/body/div[2]/form/div[2]/div[1]/input[1]")
	private WebElement submitButton;
	
	public CambiarPassword(WebDriver driver) {
		super(driver);
	}

	public boolean verForm() {
		LibretaTests.ExplicitWait(driver, 3,"Cambiar Contraseña");
		WebElement elemento2= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/ul/li/a"));
		if(elemento2!=null) {
			Actions acciones = new Actions(driver);
			acciones.moveToElement(elemento2).click().perform();		
			return isInitialized();
		}else {
			return isInitialized();
		}
		
	}
	public boolean isInitialized() {
		return actualPassw.isDisplayed();
	}
}
