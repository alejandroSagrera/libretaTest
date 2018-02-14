package libretaElectronica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.FunctionalTests;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LibretaTests extends FunctionalTests {
	LoginPage logPage = new LoginPage(driver);
	MenuPrincipal menu = new MenuPrincipal(driver);

	@Test
	public void TestA() {
		// inicio app
		driver.get("http://libretaelectronica.azurewebsites.net/");
		assertTrue(logPage.isInitialized());

		// tooltip CI
		String mouseHoverCi = logPage.hover(driver);
		assertTrue(mouseHoverCi.contains("Ingrese documento sin punto ni guiónes"));

		// login
		logPage.enterCredentials("40246159", "Ale_1988");
		ReceiptPage pantallaInicio = logPage.submit();
		assertTrue(pantallaInicio.isInitialized());
	}

	@Test
	public void TestB() {
		menu.alumnnosInicio();
		assertTrue(menu.viendoMenuAlumnos());
	}

	@Test
	public void TestC() {
		assertTrue(menu.misDatos());
	}

	@Test
	public void TestD() {
		menu.salir();
		assertTrue(logPage.isInitialized());
	}

	public static void ExplicitWait(WebDriver driver, String text) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.linkText(text)));
	}

	public static void ImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void GrabScreenShot(WebDriver driver) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("D:\\screenShotsTest\\prueba.jpg"));
	}
}