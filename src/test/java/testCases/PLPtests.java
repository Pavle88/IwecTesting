package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.PLPObjects;

public class PLPtests extends Base {

	HomePageObjects hp;
	PLPObjects po;
	TestData td;
	
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		po = new PLPObjects();
		td = new TestData();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void searchAddtoCart() throws InterruptedException {
		po.addingItemtoCart();
		po.verifyAddtoCart();
		
	}
	
	@Test
	public void clearCompareList() throws InterruptedException {
		po.clearCompareListofItems();
		po.verifyclearCompareList();
	}
	//TC_PRODUCT_014
	@Test
	public void checkColorOnMenu() throws InterruptedException {
		po.CheckColorOnVerticalMenu();
	}
	
}