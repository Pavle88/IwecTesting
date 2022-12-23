package testCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.addToCartObjects;

public class CartTests extends Base {

	HomePageObjects hp;
	addToCartObjects co;
	TestData td;
	
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		co = new addToCartObjects();
		td = new TestData();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	//adding valid gift card
	@Test
	public void addCartCouponCode() throws InterruptedException {
		co.addingToGiftCard();
		co.verifyAddGiftCard();
	}
	//adding valid coupon in cart
	@Test
	public void checkValidCouponinCart() {
		co.validCouponInCart();
		co.verifyCouponInCart();
	}
	@Test
	public void compareSKUtag()  {
		co.testingSKU();
		
	}

	@Test
	public void priceChangeInCart()  {
		co.checkPriceChangeAfterQuantityChange();
		//co.verifyPriceChange();
	}
	@Test
	public void emptyCart() throws InterruptedException {
		co.emptyCart();
	}
}