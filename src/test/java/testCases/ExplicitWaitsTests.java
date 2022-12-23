package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.explicitWaits;

public class ExplicitWaitsTests extends Base {

	HomePageObjects hp;
	explicitWaits ew;
	TestData td;
	
	
	@BeforeMethod
	public void start() {
		openBrowser();
		hp = new HomePageObjects();
		ew = new explicitWaits();
		td = new TestData();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	//Click on Start button and wait for text Hello World to be displayed
	@Test
	public void checkWaitsinBrowser() throws InterruptedException {
		ew.waitsInBrowser();
		ew.verifyMessageinBrowser();
	}
}
