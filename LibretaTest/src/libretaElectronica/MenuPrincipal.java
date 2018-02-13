package libretaElectronica;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;

public class MenuPrincipal extends PageObject {

	AlumnosInicio alumnos = new AlumnosInicio(driver);
	public MenuPrincipal(WebDriver driver) {
		super(driver);
	}
	
	public AlumnosInicio alumnnosInicio() {
		return alumnos.alumnosInicio();
	}
	public ReceiptPage listadoAlumnos() {
	    driver.findElement(By.linkText("Alumno Inicio")).click();
	    return new ReceiptPage(driver);
	}
	public void salir() {
	    driver.findElement(By.linkText("Salir")).click();
	}

}
