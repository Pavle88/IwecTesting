package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.LoginPageObjects;
import testObjectRepo.PDPobjects;
import testObjectRepo.RegisterPageObjects;

public class PDPtests extends Base {

	HomePageObjects hp;
	PDPobjects pdo;
	TestData td;
	LoginPageObjects lp;
	RegisterPageObjects rp;
	
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		pdo = new PDPobjects();
		td = new TestData();
		lp = new LoginPageObjects();
		rp = new RegisterPageObjects();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void searchAddtoCart() {
		pdo.popUpDigitalSample();
	}
	
	@Test
	public void checkShareproductFunctionality() throws InterruptedException {
		hp.navigateToLoginPage();
		lp.LoginUser(td.validemail, td.validPassword);
		pdo.productShare();
		pdo.checkShareProduct();
	}
	//test if product can be rented and take screenshot
	@Test
	public void checkProductRent() throws InterruptedException, IOException {
		pdo.productRent();
		//pdo.verifyProductCanBeRented();
	}
	@Test
	public void checkAwesomeTagProduct() {
		pdo.checkAwesomeTag();
		pdo.verifyAwesometag();
	}
	
}