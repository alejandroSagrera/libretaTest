package libretaElectronica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObject.FunctionalTests;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LibretaTests extends FunctionalTests {
	LoginPage logPage = new LoginPage(driver);
	MenuPrincipal menu = new MenuPrincipal(driver);
	
	@Test
	public void TestA() {
		driver.get("http://libretaelectronica.azurewebsites.net/");
		// init
		assertTrue(logPage.isInitialized());
		
		String mouseHoverCi = logPage.hover(driver);
		assertTrue(mouseHoverCi.contains("Ingrese documento sin punto ni guiónes"));
		
		logPage.enterCredentials("yyyyyyy", "xxxxxxx");
		ReceiptPage pantallaInicio = logPage.submit();
		assertTrue(pantallaInicio.isInitialized());
	}
	@Test
	public void TestB() {
		AlumnosInicio pantallaAlumnos = menu.alumnnosInicio();
		assertTrue(pantallaAlumnos.viendoMenuAlumnos());
	}
/*	@Test
	public void TestC() {
		menu.salir();
		assertTrue(logPage.isInitialized());
	}*/
}