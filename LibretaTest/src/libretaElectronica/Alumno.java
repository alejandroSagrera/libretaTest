package libretaElectronica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject.PageObject;

public class Alumno extends PageObject{

	@FindBy(tagName = "h4")
	private WebElement header;
	
	@FindBy(tagName = "a")
	private WebElement link;
	
	public Alumno(WebDriver driver) {
		super(driver);
	}
	public  void alumnosInicio() {
		driver.findElement(By.linkText("Alumnos")).click();
	}
	public boolean viendoMenuAlumnos() {
		String menuAlum = driver.findElement(By.linkText("Alumno Inicio")).getText();
		return (!menuAlum.isEmpty())?true:false;
	}
	public boolean estoyEnAlumnos() {
		return header.getText().contains("Lista de Alumnos");
	}
}
