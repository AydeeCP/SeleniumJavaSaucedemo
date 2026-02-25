package proyectoPruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSauceDemo {
	@Test
	public void  primerPruebaSelenium() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		WebElement userName=driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement buttonLogin = driver.findElement(By.id("login-button"));
		
		userName.sendKeys("standard_user");
		userName.clear();
		Thread.sleep(3000);
		userName.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		buttonLogin.click();		
		
		//Thread.sleep(3000);
		
		//driver.close();

	}
}