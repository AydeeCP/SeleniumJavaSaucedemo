/*package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void loginSuccesTest() {	
		LoginPage loginPage = new LoginPage();
		ProductPage productPage = new ProductPage();
		loginPage.login("standard_user", "secret_sauce");
		Assert.assertEquals(productPage.getTitle(), "Products", "El titulo de la pagina producto no es el correcto se obtiene " + productPage.getTitle());
	}
	
	
}*/