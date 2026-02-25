package proyectoPruebas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Laboratorio1 {
	@Test
	public void lab_E2() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		/*WebDriver driver2 = new FirefoxDriver();*/
		driver.manage().window().maximize();
		
		driver.close();
		
	}
}
