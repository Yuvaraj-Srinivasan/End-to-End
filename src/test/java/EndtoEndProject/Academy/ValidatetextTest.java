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

public class ValidatetextTest extends Base {

	Landing_page lp;
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializer() throws IOException {

		driver = initilalizedriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		Log.info("Navigated to Homepage");

	}

	@Test

	public void text() throws InterruptedException, IOException {

		
		lp = new Landing_page(driver);
		Thread.sleep(2000);
		lp.no_thanks().click();
		Log.debug("Clicked Nothanks");
		Assert.assertEquals(lp.get_text().getText(), "FEATURED COURSES");
		Log.info("Featured courses verified");

	}

	@Test

	public void validateHeader() throws IOException, InterruptedException {

		lp = new Landing_page(driver);
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	@AfterTest

	public void close() {

		driver.close();
	}
}
