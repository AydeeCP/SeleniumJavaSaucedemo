package tareas;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tareaLocalizadores {
	@Test
	public void  Tarea_localizador() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.get("https://www.demoblaze.com/index.html");

		
		WebElement signUp=driver.findElement(By.id("signin2"));
		signUp.click();
		Thread.sleep(4000);
		
		//completar el usuario y contraseña
		WebElement userNameInput = driver.findElement(By.id("sign-username"));
		userNameInput.sendKeys("miUsuario");	
				
		WebElement passwordInput = driver.findElement(By.id("sign-password"));
		passwordInput.sendKeys("miContraseña");
		
		//presionar boton
		WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
		signUpButton.click();
		
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println("Mensaje de alerta: "+alert.getText());
		alert.accept();
		
		Thread.sleep(1000);
		
		WebElement closeButton =  driver.findElement(By.xpath("//div[@id='signInModal']//button[@class='close']"));
		closeButton.click();

	}
}
