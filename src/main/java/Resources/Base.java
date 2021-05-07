package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
    public WebDriver driver;
    public Properties pro;
	public  WebDriver initilalizedriver () throws IOException {

		pro = new Properties();
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Drivers.properties");
		pro.load(fin);
		//String Browsername = System.getProperty("Browser");
		String Browsername = pro.getProperty("Browser");
		System.out.println(Browsername);
		if (Browsername.contains("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(Browsername.contains("headless")) {
				
				options.addArguments("headless");
				
			}
		    driver = new ChromeDriver(options);
		}

		else if (Browsername .equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yuvaraj Srinivasan\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (Browsername .equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Yuvaraj Srinivasan\\Desktop\\IEDriverserver.exe");
			driver = new InternetExplorerDriver();

		}
		

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;

	}

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
}
