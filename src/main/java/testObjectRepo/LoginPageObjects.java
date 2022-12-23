package testObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class LoginPageObjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	
	@FindBy(id = "Email")
	WebElement emailInputField;
	
	@FindBy(xpath = "//input[@id=\"Password\"]")
	WebElement passwordInputField;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//div[@class=\"message-error validation-summary-errors\"]")
	WebElement errorpassword;
	
	@FindBy(xpath = "//span[@id=\"Email-error\"]")
	WebElement errormail;
	
	@FindBy(xpath = "//span[@class=\"forgot-password\"]")
	WebElement forgotpassBtn;
	
	@FindBy(xpath = "//input[@id=\"Email\"]")
	WebElement emailAdressField;
	
	@FindBy(xpath = "//button[@class=\"button-1 password-recovery-button\"]")
	WebElement recoverBtn;
	
	@FindBy(xpath = "//div[@class=\"bar-notification success\"]")
	WebElement recoverSuccess;
	
	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void LoginUser(String username,String password) {
		emailInputField.sendKeys(username);
		passwordInputField.sendKeys(password);
		Loginbtn.click();
	}
	public void ForgotPassword(String username,String email) throws InterruptedException {
		emailInputField.sendKeys(username);
		forgotpassBtn.click();
		emailAdressField.sendKeys(email);
		recoverBtn.click();
		cm.sleepIn();
	}
	public void verifythatUserlogin() {
		Assert.assertEquals(driver.getTitle(), td.homePageTitle);
	}
	public void verifyUnsuccessfulLogin() {
		Assert.assertEquals(errorpassword.getText(), td.errorPassword);
	}
	public void verifyUnsuccessfulLogin1() {
		Assert.assertEquals(errormail.getText(), td.errormail1);
	}
	public void verifyWrongMailformat() {
		Assert.assertEquals(errormail.getText(), td.errormail2);
	}
	public void verifyEmptyPassword () {
		Assert.assertEquals(errorpassword.getText(), td.emptyPasswordError);
	}
	public void verifyPasswordReset() {
		Assert.assertEquals(recoverSuccess.getText(),td.recoverMessage);
	}
}
