package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.addToWishListObjects;

public class AddtoWishListTests extends Base {

	HomePageObjects hp;
	addToWishListObjects wlo;
	TestData td;
	
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		wlo = new addToWishListObjects();
		td = new TestData();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void addtoWishList() throws InterruptedException {
		wlo.addToWishListCart();
	}
	
	@Test
	public void checkWishListPrice() throws InterruptedException {
		wlo.verifyWishListPrice();
	}
	@Test
	public void checkDetailsWishList() {
		wlo.wishListProductDetails();
	}
	@Test
	public void checkEmptyWishList() {
		wlo.EmptyWishList();
		wlo.verifyEmptyWishList();
	}
}