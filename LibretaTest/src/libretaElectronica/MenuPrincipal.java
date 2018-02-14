package libretaElectronica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		return cambiarContrasenia.verForm();
		/*
	    driver.findElement(By.linkText("Mis Datos")).click();
		String cambiarContra = driver.findElement(By.linkText("Cambiar Contraseña")).getText();
		return (!cambiarContra.isEmpty())?true:false;*/
	}
	public boolean verCambiarContrasenia() {
		cambiarContrasenia.verForm();
		return cambiarContrasenia.isInitialized();
	}
	public void salir() {
	    driver.findElement(By.linkText("Salir")).click();
	}

}
