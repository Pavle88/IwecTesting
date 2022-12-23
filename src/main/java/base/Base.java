package base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public String HomeUrl = "https://demo.nopcommerce.com/";
	public String homeUrl2 = "https://the-internet.herokuapp.com/dynamic_loading/1";
	public String homeUrl3 = "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html";
	public String homeUrl4 = "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html";
	public String homeUrl5 = "http://uitestingplayground.com/ajax";
	public static WebDriver driver;

	public void openAplication() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(HomeUrl);
		driver.manage().window().maximize();
		
	}
	public void openBrowser() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(homeUrl2);
			driver.manage().window().maximize();
			
		}
	
	public void takeSnapshot() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:/Users/Pavle/Desktop/Screenshots/screenshot01.png"));
	}
	
	public void openSite () {
	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(homeUrl3);
			driver.manage().window().maximize();
			
		}
	public void openTestSite () {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(homeUrl4);
		driver.manage().window().maximize();
		
	}
	public void openTestSite1 () {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(homeUrl5);
		driver.manage().window().maximize();
		
	}
	}
	

