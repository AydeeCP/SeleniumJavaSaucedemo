package proyectoPruebas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class PruebaSelenium {
	@Test
	public void  primerPruebaSelenium() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		/*WebDriver driver2 = new FirefoxDriver();*/
		driver.manage().window().maximize();
		
		driver.navigate().refresh();	
		
		driver.manage().window().minimize();
		
		driver.manage().window().maximize();
		
		driver.close();
		
	}
}
