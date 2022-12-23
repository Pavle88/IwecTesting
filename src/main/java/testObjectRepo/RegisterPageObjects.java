package testObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class RegisterPageObjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	
	@FindBy(id = "FirstName")
	WebElement firstNameField;
	
	@FindBy(name = "LastName")
	WebElement lastNameField;
	
	@FindBy(id= "Email")
	WebElement emailField;
	
	@FindBy(id ="BillingNewAddress_FirstName")
	WebElement billingFirstName;
	
	@FindBy(id ="BillingNewAddress_LastName")
	WebElement billingLastName;
	
	@FindBy(id ="BillingNewAddress_Email")
	WebElement billingEmail;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement billingCity;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement billingAddress;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement billingZipcode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement billingPhoneNum;
	
	@FindBy(xpath = "//input[@name=\"Password\"]")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@id=\"ConfirmPassword\"]")
	WebElement confirmPasswordField;
			
	@FindBy(xpath = "//button[@id=\"register-button\"]")
	WebElement Registerbtn;
	
	@FindBy(xpath = "//div[@class=\"result\"]")
	WebElement registryComplete;
	
	@FindBy(id = "Email-error")
	WebElement emailerror;
	
	@FindBy(xpath = "//span[@id=\"Password-error\"]")
	WebElement passworderror;
	
	@FindBy(id = "ConfirmPassword-error")
	WebElement passconfpasserror;
	
	@FindBy(xpath = "//span[@id=\"LastName-error\"]")
	WebElement lastNameerorr;
	
	@FindBy(xpath = "//input[@id=\"CardholderName\"]")
	WebElement creditCardHolder;
	
	@FindBy(id = "CardNumber")
	WebElement creditCardNmb;
	
	@FindBy(id = "CardCode")
	WebElement creditCardCode;
	
	@FindBy(id="ShippingNewAddress_City")
	WebElement shippingNewAdressCity;
	
	@FindBy(id="ShippingNewAddress_Address1")
	WebElement shippingNewAddress;
	
	@FindBy(id="ShippingNewAddress_ZipPostalCode")
	WebElement shippingNewZipCode;
	
	@FindBy(id="ShippingNewAddress_PhoneNumber")
	WebElement shippingNewPhnNum;
	
	@FindBy(xpath = "//div[@class=\"message-error validation-summary-errors\"]")
	WebElement registryError;
	
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
	
	//generate random string
	/* org.apache.commons.lang3.RandomStringUtils;

	  public String randomestring()
	  {
	    String generatedstring=RandomStringUtils.randomAlphabetic(8);
	    return(generatedstring);
	   }


	  //Usage
	   String email=randomestring()+"@gmail.com";

	 //For Random Number generation 
	////randomeNum() will return string of 4 digits

	   public static String randomeNum() {
	        String generatedString2 = RandomStringUtils.randomNumeric(4);
	        return (generatedString2);
	     }*/

	
	public RegisterPageObjects() {
		PageFactory.initElements(driver, this);
	}
	public void checkoutBillingAdress(String city, String address1, String zipcode, String phonenumber ) {
		billingCity.sendKeys(city);
		billingAddress.sendKeys(address1);
		billingZipcode.sendKeys(zipcode);
		billingPhoneNum.sendKeys(phonenumber);
	}
	public void checkoutBillingAdressEmptyEmail(String firstName, String lastName, String city, String address1, String zipcode, String phonenumber ) {
		billingFirstName.sendKeys(firstName);
		billingLastName.sendKeys(lastName);
		billingCity.sendKeys(city);
		billingAddress.sendKeys(address1);
		billingZipcode.sendKeys(zipcode);
		billingPhoneNum.sendKeys(phonenumber);
	}
	public void checkoutShippingAdress(String shipCity, String shipAddress, String shipZipCode, String shipPhonenumber ) {
		cm.selectShippingCountry();
		shippingNewAdressCity.sendKeys(shipCity);
		shippingNewAddress.sendKeys(shipAddress);
		shippingNewZipCode.sendKeys(shipZipCode);
		shippingNewPhnNum.sendKeys(shipPhonenumber);
	}
	
	public void creditCardSetup(String creditCHolder, String creditCNmb, String creditCCode) {
		creditCardHolder.sendKeys(creditCHolder);
		creditCardNmb.sendKeys(creditCNmb);
		cm.selectInCreditCard();
		creditCardCode.sendKeys(creditCCode);
	}
	public void checkoutWithEmptyEmailprocess() {
		shipToSameAddressCheckbox.click();
    	cm.selectNewAddress();
    	cm.selectInMenuBilling();
    	checkoutBillingAdressEmptyEmail(td.billingFirstName, td.billingLastName, td.billingCity, td.billingAdress,td.billingZipCode,td.billingPhnNumb);
    	billingContinueBtn.click();
	}
	public void checkoutForCreditCardprocess() throws InterruptedException{
		shipToSameAddressCheckbox.click();
    	billingContinueBtn.click();
    	cm.sleepIn();
    	shipContinueBtn.click();
    	cm.sleepIn();
    	shipMethodContinueBtn.click();
    	cm.sleepIn();
    	creditCardCheckbox.click();
    	creditCardContinueBtn.click();
    	cm.sleepIn();
    	cm.selectExpireDate();
    	creditCardSetup(td.creditCardHolder, td.creditCardNumber, td.invalidCreditCardCode);
    	creditCardConfirmButton.click();
	}
	public void RegisterUser(String firstName,String LastName,String email,String password, String confirmPassword) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(LastName);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		Registerbtn.click();
	}
	public void checkoutProcess() throws InterruptedException {
		shipToSameAddressCheckbox.click();
    	cm.selectInMenuBilling();
    	checkoutBillingAdress(td.billingCity, td.billingAdress, td.billingZipCode, td.billingPhnNumb);
    	billingContinueBtn.click();
    	cm.sleepIn();
    	shipContinueBtn.click();
    	cm.sleepIn();
    	radioBtnCheck.click();
    	shipMethodContinueBtn.click();
    	cm.sleepIn();
    	creditCardCheckbox.click();
    	creditCardContinueBtn.click();
    	cm.sleepIn();
    	cm.selectExpireDate();
    	creditCardSetup(td.creditCardHolder, td.creditCardNumber, td.creditCardCode);
    	creditCardConfirmButton.click();
	}
	public void checkoutBillingNewAddress(String firstName, String lastName, String email, String city, String address1, String zipcode, String phonenumber ) {
		billingFirstName.sendKeys(firstName);
		billingLastName.sendKeys(lastName);
		billingCity.sendKeys(city);
		billingEmail.sendKeys(email);
		billingAddress.sendKeys(address1);
		billingZipcode.sendKeys(zipcode);
		billingPhoneNum.sendKeys(phonenumber);
	}
	public void checkoutShippingNewAddress(String city, String address1, String zipcode, String phonenumber ) {
		shippingNewAdressCity.sendKeys(city);
		shippingNewAddress.sendKeys(address1);
		shippingNewZipCode.sendKeys(zipcode);
		shippingNewPhnNum.sendKeys(phonenumber);
	}
	
	public void verifyUserRegistered() {
		Assert.assertEquals(registryComplete.getText(), td.userRegistered);
	}
	public void verifyRegistryEmptyMail() {
		Assert.assertEquals(emailerror.getText(), td.registryerror);
	}
	public void verifyRegistrywithinvalidPass() {
		Assert.assertEquals(passworderror.getText(), td.registrypaserror);
	}
	public void verifyPasswordandConfirmPass() {
		Assert.assertEquals(passconfpasserror.getText(), td.reginvalidconfpass);
	}
	public void verifyEmptyLastName () {
		Assert.assertEquals(lastNameerorr.getText(), td.reginvalidLastName);
	}
	public void verifyExistingEmail () {
		Assert.assertEquals(registryError.getText(), td.registrySameMailerror);
	}
}
