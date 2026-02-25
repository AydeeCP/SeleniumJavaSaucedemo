package pages;
import org.openqa.selenium.By;

import base.BasePage;

public class LoginPage extends BasePage {
	private By usernameInput = 	By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	
	public void enterUsername(String username) {
		enterText(usernameInput, username);
	}
	public void enterPasswor(String password) {
		enterText(passwordInput, password);
	}
	
	public void clickLoginButton() {
		clickElement(loginButton);
	}
	public void login (String username, String password) {
		enterUsername(username);
		enterPasswor(password);
		clickLoginButton();
	}
	
}
