package StepDefinitions;

import Resources.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.Landing_page;
import pageObject.Login_page;
import pageObject.forgotpassword;

public class Stepdefinition extends Base {
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initilalizedriver();
		driver.manage().window().maximize();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get(arg1);
		Thread.sleep(2000);
		
	  
	}

	@Given("^Click on login link in home page to land on secure sign in page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		Landing_page lp = new Landing_page(driver);
		if(lp.get_thanks().size()>0) 
		{
		lp.no_thanks().click();
		}
		lp.get_signin().click();
		
	
		
	}


	
	 @When("^User enters (.+) and (.+) and login$")
	    public void user_enters_and_and_login(String username, String password) throws Throwable {
		 Login_page login = new Login_page(driver);
			login.send_email().sendKeys(username);
			login.send_password().sendKeys(password);
			login.click_login().click();
			login.forgotPassword().click();
		}
	    

	
	
	 @Then("^Verify that user not logged in$")
	    public void verify_that_user_not_logged_in() throws Throwable {
		    forgotpassword fp = new forgotpassword(driver);
			fp.get_email().sendKeys("yuvarajsrinivasan07");
			fp.Sendmeinstruction().click();   
	    }
	 
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {

		 driver.quit();
	    }


	
}