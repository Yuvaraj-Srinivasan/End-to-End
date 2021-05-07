package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing_page {
	
	public WebDriver driver;

	private By close = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By text =By.cssSelector("div.text-center h2");
	private By navigationBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	private By header=By.xpath("//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']//h3");
	
	public Landing_page( WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
	
	public WebElement no_thanks() {
		return driver.findElement(close);
	}
	public List<WebElement> get_thanks() {
		return driver.findElements(close);
	}
	
	public WebElement get_signin() {
	   return driver.findElement(signin);
	
	}
	
	public WebElement get_text() {
		return driver.findElement(text);
	}
	
	public WebElement get_navigarBar() {
		return driver.findElement(navigationBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
	

}
