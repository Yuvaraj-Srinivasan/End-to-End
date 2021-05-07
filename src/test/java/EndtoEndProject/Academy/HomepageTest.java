package EndtoEndProject.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObject.Landing_page;
import pageObject.Login_page;
import pageObject.forgotpassword;

public class HomepageTest extends Base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initializer() throws IOException {
		
		driver = initilalizedriver();
		driver.manage().window().maximize();
		Log.info("Driver is intialize");
		
		
		
		
	}
	@Test(dataProvider="getdata")

	public void basepage(String email,String password) throws  InterruptedException, IOException {

		driver.get(pro.getProperty("url"));
		Log.info("Navigated to Homepage");
		Landing_page lp = new Landing_page(driver);
		Thread.sleep(2000);
		lp.no_thanks().click();
		Log.debug("Clicked Nothanks");
		lp.get_signin().click();
		Log.debug("Clicked Signin");
		Login_page login = new Login_page(driver);
		login.send_email().sendKeys(email);
		login.send_password().sendKeys(password);
		login.click_login().click();
		Log.info("Successfully entered mail and password");
		login.forgotPassword();
		forgotpassword fp = new forgotpassword(driver);
		fp.get_email().sendKeys("yuvarajsrinivasan07");
		fp.Sendmeinstruction().click();
	

	}
	

	
	@DataProvider(name="getdata")
	public Object[][] getdata(){
		
		Object[][] ob = new Object[2][2];		
		ob[0][0] = "yuvarajsrinivasan07@gmail.com";
		ob[0][1] = "Yuvi@1907";
		ob[1][0] = "yuvaraj@gmail.com";
		ob[1][1] = "Yuvi@1907";
		return ob;
		
		
	}
	
@AfterMethod
	
	public void close() {
		
		driver.close();
		
	}
}
