package testObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class checkoutObjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	RegisterPageObjects rp = new RegisterPageObjects();
	addToCartObjects aco = new addToCartObjects();
	LoginPageObjects lp = new LoginPageObjects();
	
	@FindBy(xpath = "//a[@href=\"/computers\"]")
	WebElement mainMenu;
	
	@FindBy(xpath = "//a[@href=\"/software\"]")
	WebElement submenu;
	
	@FindBy(xpath = "//button[@class=\"button-2 add-to-wishlist-button\"]/following::button")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[@href=\"/cart\"]")
	WebElement goToCart;
	
	@FindBy(xpath = "//input[@id=\"termsofservice\"]")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[@id=\"checkout\"]")
	WebElement checkoutBtn;
	
	@FindBy(id="ShipToSameAddress")
	WebElement shipToSameAddressCheckbox;
	
	@FindBy(xpath = "//button[@class=\"button-1 new-address-next-step-button\"]")
	WebElement billingContinueBtn;
	
	@FindBy(xpath = "//input[@id=\"shippingoption_0\"]")
	WebElement radioBtnCheck;
	
	@FindBy(xpath = "//button[@class=\"button-1 shipping-method-next-step-button\"]")
	WebElement shipMethodContinueBtn;
	
	@FindBy(xpath = "//div[@id=\"shipping-buttons-container\"]/button")
	WebElement shipContinueBtn;
	
	@FindBy(id = "paymentmethod_1")
	WebElement creditCardCheckbox;
	
	@FindBy(xpath = "//button[@class=\"button-1 payment-method-next-step-button\"]")
	WebElement creditCardContinueBtn;
	
	@FindBy(xpath = "//button[@class=\"button-1 payment-info-next-step-button\"]")
	WebElement creditCardConfirmButton;
	
	@FindBy(xpath = "//button[@class=\"button-1 confirm-order-next-step-button\"]")
	WebElement checkoutConfirmBtn;
	
	@FindBy(xpath = "//button[@class=\"button-1 order-completed-continue-button\"]")
	WebElement checkoutCompeteOrderbtn;
	
	@FindBy(xpath = "//div[@class=\"title\"]/strong")
	WebElement completeCheckoutMessage;
	
	@FindBy(xpath = "//span[contains(text(),'Email')]")
	WebElement billingEmailError;
	
	@FindBy(xpath = "//div[@class=\"message-error validation-summary-errors\"]")
	WebElement creditCardError;
	
	
	public checkoutObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkoutProcess() throws InterruptedException {
		cm.mouseOver(mainMenu,submenu);
		addToCartBtn.click();
		cm.sleepIn();
		goToCart.click();
		checkBox.click();
		checkoutBtn.click();
	}
	
	
    public void completeCheckoutProcess() throws InterruptedException {
    	
    	checkoutProcess();
    	lp.LoginUser(td.validemail, td.validPassword);
    	checkBox.click();
    	checkoutBtn.click();
    	rp.checkoutProcess();
    	cm.sleepIn();
    	checkoutConfirmBtn.click();
    	cm.sleepIn();
    }	
    public void checkoutBillingEmptyEmail() throws InterruptedException {
    	checkoutProcess();
    	lp.LoginUser(td.validemail, td.validPassword);
    	checkBox.click();
    	checkoutBtn.click();
    	rp.checkoutWithEmptyEmailprocess();
    	cm.sleepIn();
    }
    public void checkoutCreditCard() throws InterruptedException {
    	checkoutProcess();
    	lp.LoginUser(td.validemail, td.validPassword);
    	checkBox.click();
    	checkoutBtn.click();
    	rp.checkoutForCreditCardprocess();
    	cm.sleepIn();

    }
    
		
    public void verifyCompleteCheckoutProcess() {
    	
    	Assert.assertEquals(completeCheckoutMessage.getText(), td.checkoutMessage);
    }

	public void verifyBillingProcessEmptyMail() {
		Assert.assertEquals(billingEmailError.getText(), td.billingEmailErrorMsg);
	}
	
	public void verifyWrongCreditCardCode() {
		Assert.assertEquals(creditCardError.getText(), td.creditCardErrorMsg);
	}
	}
	
	
