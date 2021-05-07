package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_page {
	
	public WebDriver driver;

	private By email = By.cssSelector("input[type='email']");
	private By password = By.cssSelector("input[type='password']");
	private By login = By.cssSelector("input[type='submit']");
	private By forgotpassword = By.cssSelector("a.link-below-button");
	
	
	public Login_page( WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
	
	public WebElement send_email() {
		return driver.findElement(email);
	}
	
	public WebElement send_password() {
		return driver.findElement(password);
	}
	
	public WebElement click_login() {
		return driver.findElement(login);
	}
	
	public WebElement forgotPassword() {
		return driver.findElement(forgotpassword);
		
	}




	
}
