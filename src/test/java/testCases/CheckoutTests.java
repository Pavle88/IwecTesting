package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.LoginPageObjects;
import testObjectRepo.RegisterPageObjects;
import testObjectRepo.checkoutObjects;

public class CheckoutTests extends Base {

	HomePageObjects hp;
	LoginPageObjects lp;
	RegisterPageObjects rp;
	TestData td;
	checkoutObjects ch;
	
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		rp = new RegisterPageObjects();
		td = new TestData();
		lp = new LoginPageObjects();
		ch = new checkoutObjects();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	//complete checkout and assert the final message
	@Test
	public void checkoutProcess() throws InterruptedException {
		ch.completeCheckoutProcess();
		ch.verifyCompleteCheckoutProcess();
	}
	//go to checkout billing page and assert the empty mail error
	@Test
	public void checkoutBillingEmptyMail() throws InterruptedException {
		ch.checkoutBillingEmptyEmail();
		ch.verifyBillingProcessEmptyMail();
	}
	//go to checkout credit card page and assert the wrong credit card code
	@Test
	public void checkoutDiffrentCreditCard() throws InterruptedException {
		ch.checkoutCreditCard();
		ch.verifyWrongCreditCardCode();
	}
}