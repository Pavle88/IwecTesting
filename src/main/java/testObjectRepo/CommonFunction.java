package testObjectRepo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestData.TestData;
import base.Base;

	public class CommonFunction extends Base {

	TestData td = new TestData();

	
	 public CommonFunction()  {
	    	PageFactory.initElements(driver, this);
	    }
	 	@FindBy(xpath = "//a[@href=\"/computers\"]")
		WebElement mainMenu;
	    
	    @FindBy(xpath = "//a[@href=\"/apparel\"]")
		WebElement mainMenu2;
	    
	    @FindBy(xpath = "//a[@href=\"/jewelry\"]")
	    WebElement MainMenu3;
	    
	    @FindBy(xpath =  "//select[@id=\"BillingNewAddress_CountryId\"]")
	    WebElement selectMenu1;
	    
	    @FindBy(xpath = "//select[@id=\"product_attribute_11\"]")
	    WebElement selectMenu;
	    
	    @FindBy(id = "CreditCardType")
	    WebElement selectMenu2;
	    
	    @FindBy(id="billing-address-select")
	    WebElement selectNewAddress;
	    
	    @FindBy(id="shipping-address-select")
	    WebElement selectNewAddressShip;
	    
	    @FindBy(xpath = "//select[@id=\"ExpireMonth\"]")
	    WebElement cardExpireMonth;
	      
	    @FindBy(id = "ExpireYear")
	    WebElement cardExpireYear;
	    
	    @FindBy(id = "ShippingNewAddress_CountryId")
	    WebElement shipNewCountry;
	    
	    @FindBy(xpath = "//select[@id=\"ShippingNewAddress_CountryId\"]")
	    WebElement selectNewShipCountry;
	   
	  public void mouseOver(WebElement elementToHoverOver, WebElement clickAfterHover) {
	    	Actions mouseHover = new Actions(driver);
			mouseHover.moveToElement(elementToHoverOver).perform();
			clickAfterHover.click();
	    }
	  public void MenuClicking(WebElement clickMenu) {
		  clickMenu.click();
	  }
	  
	    public void pageDown() {
	    Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	    }
	    public void waitInPage() {
	    	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	    }
	    public void waitFor(By element) {
	    	WebDriverWait wait = new WebDriverWait(driver,30);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	    }
	    public void selectInMenu() {
	    	Select select = new Select(selectMenu);
	    	select.selectByVisibleText("3X");
	    }
	    public void selectInMenuBilling() {
	    	Select select = new Select(selectMenu1);
	    	select.selectByVisibleText("Macedonia");
	    }
	    public void sleepIn() throws InterruptedException {
	    	Thread.sleep(4000);
	    }
	    public void selectInCreditCard() {
	    	Select select = new Select(selectMenu2);
	    	select.selectByVisibleText("Visa");
	    }
	    public void selectExpireDate() {
	    	Select select = new Select(cardExpireMonth);
	    	select.selectByVisibleText("05");
	    	
	    	Select select1 = new Select(cardExpireYear);
	    	select1.selectByVisibleText("2023");
	    }
	    public void selectShippingCountry() {
	    	Select select = new Select (shipNewCountry);
	    	select.selectByVisibleText("Macedonia");
	    }
	    public void selectNewAddress() {
	    	Select select = new Select(selectNewAddress);
	    	select.selectByVisibleText("New Address");
	    }
	    public void SelectNewAdressShip() 
	          {
	 	    	Select select = new Select(selectNewAddressShip);
	 	    	select.selectByVisibleText("New Address");
	 	    }
	    public void SelectNewShipCountry() {
	    	Select select = new Select(selectNewShipCountry);
	    	select.selectByVisibleText("Macedonia");
	    }
	    }

