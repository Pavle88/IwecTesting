package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.LoginPageObjects;
import testObjectRepo.RegisterPageObjects;

public class LoginPageTestCases extends Base {

	HomePageObjects hp;
	LoginPageObjects lp;
	TestData td;
	RegisterPageObjects rp;
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		lp = new LoginPageObjects();
		td = new TestData();
		rp = new RegisterPageObjects();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	
	public void loginWithValidCredentials() {
		hp.navigateToLoginPage();
		lp.LoginUser(td.validemail, td.validPassword);
		lp.verifythatUserlogin();
	}
	
	@Test
	public void loginWithWrongEmail() {
		hp.navigateToLoginPage();
		lp.LoginUser(td.inValidemail, td.validPassword);
		lp.verifyWrongMailformat();
	}
	
	@Test
	public void loginWithWrongPassword() {
		hp.navigateToLoginPage();
		lp.LoginUser(td.validemail, td.inValidPassword);
		lp.verifyUnsuccessfulLogin();
	}
	
    @Test	
	public void loginWithEmptyMailandPassword() {
		hp.navigateToLoginPage();
		lp.LoginUser(td.EmptyMail, td.emptyPassword);
		lp.verifyUnsuccessfulLogin1();
	}
	@Test
	public void loginWithValidEmailemptyPassword() {
		hp.navigateToLoginPage();
		lp.LoginUser(td.validemail, td.emptyPassword);
		lp.verifyEmptyPassword();
	}
	@Test
	public void ForgotPasswordCheck() throws InterruptedException {
		hp.navigateToRegisterPage();
		rp.RegisterUser(td.firstName, td.lastName, td.validemail, td.validPassword, td.confirmPassword);
		hp.logoutUser();
		hp.navigateToLoginPage();
		lp.ForgotPassword(td.validemail, td.validemail);
		lp.verifyPasswordReset();
	}
}
