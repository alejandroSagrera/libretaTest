import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.TakesScreenshot;


public class Test {

	public static void main(String[] args) throws IOException {
		// firefox Test
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		/*driver.navigate().to("http://libretaelectronica.azurewebsites.net/");
		driver.findElement(By.id("Ci")).sendKeys("40246159");
		driver.findElement(By.id("Contrase_a")).sendKeys("Ale_1988");
		driver.findElement(By.id("Acceder")).click();*/
		
		driver.navigate().to("http://executeautomation.com/demosite/Dragging.html");
		WebElement origen = driver.findElement(By.id("item1"));
		WebElement destino = driver.findElement(By.id("item4"));
		dragAndDrop(driver,destino,origen);
		
		/*ImplicitWait(driver);
		
		GrabScreenShot(driver);
		
		
		// chrome Test
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.facebook.com");
		
		// Edge Test
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\USER\\Downloads\\EdgeWebDriver\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.navigate().to("http://www.facebook.com");*/
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement elemSource, WebElement elemDestination) {
		Actions acciones = new Actions(driver);
		acciones.dragAndDrop(elemSource, elemDestination).perform();
	}
	
	public static boolean exist(WebElement exi) {
		try {
			return exi.isDisplayed();
		}catch(NoSuchElementException x) {
			return false;
		}
	}
	public static void ExplicitWait(WebDriver driver, String text) {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.linkText(text)));
	}
	public static void ImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void GrabScreenShot(WebDriver driver) throws IOException {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("D:\\screenShotsTest\\prueba.jpg"));
	}

}
