package EndtoEndProject.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObject.Landing_page;

public class Validate_NavigationBarTest extends Base{
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializer() throws IOException {
		
		driver = initilalizedriver();
		driver.manage().window().maximize();
		Log.info("Driver is intialize");
		
	}
	@Test
	
	public void navigation_bar() throws InterruptedException, IOException {
		
		driver.get(pro.getProperty("url"));
		Log.info("Navigated to Homepage");
		Landing_page lp = new Landing_page(driver);
		Thread.sleep(2000);
		lp.no_thanks().click();
		Log.debug("Clicked Nothanks");
		System.out.println(lp.get_navigarBar().getText());
		Assert.assertTrue(lp.get_navigarBar().isDisplayed());
		Log.info("Navigation Bar displayed");
		
	}
	
	@AfterTest
	
	public void close() {
		
		driver.close();
	
		
	}

}
