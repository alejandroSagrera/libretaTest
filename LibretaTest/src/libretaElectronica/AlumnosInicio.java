package libretaElectronica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject.PageObject;

public class AlumnosInicio extends PageObject{

	@FindBy(tagName = "h4")
	private WebElement header;
	
	@FindBy(tagName = "a")
	private WebElement link;
	
	public AlumnosInicio(WebDriver driver) {
		super(driver);
	}
	public  AlumnosInicio alumnosInicio() {
		driver.findElement(By.linkText("Alumnos")).click();
		return this;
	}
	public boolean viendoMenuAlumnos() {
		return link.getText().contains("Alumno Inicio");
	}
	public boolean estoyEnAlumnos() {
		return header.getText().contains("Lista de Alumnos");
	}
}
