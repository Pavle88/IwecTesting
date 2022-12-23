package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.RegisterPageObjects;

public class RegisterPageTestCases extends Base {

	HomePageObjects hp;
	RegisterPageObjects rp;
	TestData td;
	
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		rp = new RegisterPageObjects();
		td = new TestData();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void registerWithValidCredentials() {
		hp.navigateToRegisterPage();
		rp.RegisterUser(td.firstName, td.lastName, td.validemail, td.validPassword, td.confirmPassword);
		rp.verifyUserRegistered();
	}
	
	@Test
	public void registerWithEmptyEmail() {
		hp.navigateToRegisterPage();
		rp.RegisterUser(td.firstName, td.lastName, td.EmptyMail, td.validPassword, td.confirmPassword);
		rp.verifyRegistryEmptyMail();
	}
	
	@Test
	public void registerWithWrongPassword() {
		hp.navigateToRegisterPage();
		rp.RegisterUser(td.firstName, td.lastName, td.validemail, td.invalidPassword2, td.invalidconfirmPass);
		rp.verifyRegistrywithinvalidPass();
	}
	
    @Test
	public void regigsterWithwrongConfPass() {
		hp.navigateToRegisterPage();
		rp.RegisterUser(td.firstName, td.lastName, td.validemail, td.validPassword, td.invalidconfirmPass);
		rp.verifyPasswordandConfirmPass();
	}
    @Test
	public void registerWithEmptyLastName() {
		hp.navigateToRegisterPage();
		rp.RegisterUser(td.firstName, td.emptyLastName, td.validemail, td.validPassword, td.confirmPassword);
		rp.verifyEmptyLastName();
	
}
    @Test
	public void registerWithExistingEmail() {
		hp.navigateToRegisterPage();
		rp.RegisterUser(td.firstName, td.lastName, td.validemail, td.validPassword, td.confirmPassword);
		rp.verifyExistingEmail();
}
}