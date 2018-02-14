package libretaElectronica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObject.PageObject;

public class MenuPrincipal extends PageObject {

	Alumno alumnos = new Alumno(driver);
	CambiarPassword cambiarContrasenia = new CambiarPassword(driver);
	
	public MenuPrincipal(WebDriver driver) {
		super(driver);
	}
	
	public void alumnnosInicio() {
		alumnos.alumnosInicio();
	}
	public boolean viendoMenuAlumnos() {
		return alumnos.viendoMenuAlumnos();
	}
	public ReceiptPage listadoAlumnos() {
	    driver.findElement(By.linkText("Alumno Inicio")).click();
	    return new ReceiptPage(driver);
	}
	public boolean misDatos() {
		WebElement elemento= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/a"));
		if(elemento!=null) {
			Actions acciones = new Actions(driver);
			acciones.moveToElement(elemento).click().perform();
			return cambiarContrasenia.verForm();
		}else {
			return false;
		}
	}
	public boolean verCambiarContrasenia() {
		cambiarContrasenia.verForm();
		return cambiarContrasenia.isInitialized();
	}
	public void salir() {
	    driver.findElement(By.linkText("Salir")).click();
	}

}
