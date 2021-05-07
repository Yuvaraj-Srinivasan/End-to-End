package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotpassword {
	public WebDriver driver;
	
	private By email = By.cssSelector("input#user_email");
	private By Sendmeinstructions = By.cssSelector("input[type='submit']");
	
public forgotpassword( WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
	
	public WebElement get_email() {
		return driver.findElement(email);
	}
	
	public WebElement Sendmeinstruction() {
		return driver.findElement(Sendmeinstructions);
	}
	
}
