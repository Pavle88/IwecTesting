package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.explicitWaits;

public class explicitWaitsTest2 extends Base {

	HomePageObjects hp;
	explicitWaits ew;
	TestData td;
	
	
	@BeforeMethod
	public void start() {
		openSite();
		//hp = new HomePageObjects();
		ew = new explicitWaits();
		td = new TestData();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	//After all pictures load the text DONE! is displayed
	@Test
	public void checkWaitsInSite() throws InterruptedException {
		ew.waitsInBrowser1();
		ew.verifyMessageinBrowser1();
	}
}
