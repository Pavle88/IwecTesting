package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
import testObjectRepo.AccountObjects;
import testObjectRepo.HomePageObjects;
import testObjectRepo.LoginPageObjects;

public class accountTests extends Base {

	HomePageObjects hp;
	LoginPageObjects lp;
	TestData td;
	AccountObjects acnt;
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		lp = new LoginPageObjects();
		td = new TestData();
		acnt = new AccountObjects();
		
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void checkAccountReview() {
		acnt.accountReview();
		acnt.verifyAccountReview();
	}
	@Test
	public void checkPasswordChange() throws InterruptedException {
		acnt.changeAccountPassword();
		acnt.verifyPasswordChange();
	}
	@Test
	public void checkPasswordConfirmPass() throws InterruptedException {
		acnt.accountPasswordConfpassNotSame();
		acnt.verifyPasswordNotSame();
	}
}