package testObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class AccountObjects extends Base {

	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	RegisterPageObjects rp = new RegisterPageObjects();
	addToCartObjects aco = new addToCartObjects();
	LoginPageObjects lp = new LoginPageObjects();
	HomePageObjects hp = new HomePageObjects();
	
	@FindBy(xpath = "//a[@class=\"ico-account\"]")
	WebElement accountBtn;
	
	@FindBy(xpath = "//a[@href=\"/customer/productreviews\"]")
	WebElement productReviewBtn;
	
	@FindBy(xpath = "//div[@class=\"no-data\"]")
	WebElement noReview;
	
	@FindBy(xpath = "//a[@href=\"/customer/changepassword\"]")
	WebElement changePassword;
	
	@FindBy(xpath = "//span[@class=\"field-validation-error\"]")
	WebElement passwordError;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordField;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordField;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordField;
	
	@FindBy(xpath = "//button[@class=\"button-1 change-password-button\"]")
	WebElement changePasswordBtn;
	
	@FindBy(xpath ="//span[@id=\"NewPassword-error\"]")
	WebElement changePasswordError;
	
	@FindBy(id="ConfirmNewPassword-error")
	WebElement passConfPassError;
	
	@FindBy(xpath = "//div[@class=\"form-fields\"]")
	WebElement formField;
	
	public AccountObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void accountReview() {
		hp.navigateToLoginPage();
		lp.LoginUser(td.validemail, td.validPassword);
		accountBtn.click();
		productReviewBtn.click();
	}
	public void changeAccountPassword() throws InterruptedException {
		hp.navigateToLoginPage();
		lp.LoginUser(td.validemail, td.validPassword);
		accountBtn.click();
		changePassword.click();
		oldPasswordField.sendKeys(td.validPassword);
		newPasswordField.sendKeys(td.newPasswordField);
		confirmPasswordField.click();
	}
	public void	accountPasswordConfpassNotSame() throws InterruptedException {
		hp.navigateToLoginPage();
		lp.LoginUser(td.validemail, td.validPassword);
		accountBtn.click();
		changePassword.click();
		oldPasswordField.sendKeys(td.validPassword);
		newPasswordField.sendKeys(td.newPasswordField);
		confirmPasswordField.sendKeys(td.confirmPasswordField);
		formField.click();
	}
	
	public void verifyAccountReview() {
		Assert.assertEquals(noReview.getText(), td.emptyReviewMsg);
	}
	public void verifyPasswordChange() {
		Assert.assertEquals(changePasswordError.getText(), td.changePassErrorMsg);
	}
	public void verifyPasswordNotSame() {
		Assert.assertEquals(passConfPassError.getText(), td.passConfPassErrorMsg);
	}
	
}
