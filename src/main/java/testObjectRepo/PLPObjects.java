package testObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class PLPObjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	
	@FindBy(xpath = "//*[contains(text(),'Electronics')]")
	WebElement mainMenu;
	
	@FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/li/a[contains(text(),'Jewelry')]")
	WebElement mainMenu3;
	
	@FindBy(xpath = "//a[@href=\"/camera-photo\"][1]")
	WebElement subMenu;
	
	@FindBy(xpath = "//a[@href=\"/cell-phones\"]")
	WebElement subMenu2;
	
	@FindBy(xpath = "//button[@class=\"button-2 add-to-compare-list-button\"]")
	WebElement compareButton1;
	
	@FindBy(xpath = "//button[contains(text(),'Add to compare list')]/following::button[3]")
	WebElement compareButton2;
	
	@FindBy(xpath = "//a[@href=\"/compareproducts\"]")
	WebElement productCompare;
	
	@FindBy(xpath = "//a[@class=\"clear-list\"]")
	WebElement clearList;
	
	@FindBy(xpath = "//div[@class=\"no-data\"]")
	WebElement noItems;
	
	@FindBy(xpath = "//button[contains(text(),'Add to compare list')]/preceding-sibling::button[1]")
	WebElement addToCart;
	
	@FindBy(id = "add-to-cart-button-14")
	WebElement addToCart1;
	
	@FindBy(xpath = "//div[@class=\"bar-notification success\"]")
	WebElement cartMessage;
	
	@FindBy(xpath = "//a[@href=\"/apparel\"]")
	WebElement mainMenu2;
	
	@FindBy(xpath = "//a[@href=\"/clothing\"]")
	WebElement subMenu3;
	
	@FindBy(xpath = "//img[@alt=\"Picture of Nike Tailwind Loose Short-Sleeve Running Shirt\"]")
	WebElement picture;
	
	@FindBy(xpath = "//span[@id=\"sku-27\"]")
	WebElement SKU1;
	
	@FindBy(xpath = "//select[@id=\"product_attribute_11\"]")
	WebElement selectMenu;
	
	@FindBy(xpath = "//input[@id=\"product_enteredQuantity_27\"]")
	WebElement quantity;
		
	@FindBy(xpath = "//button[@id=\"add-to-cart-button-27\"]")
	WebElement addToCart2;
	
	@FindBy(xpath = "//a[@href=\"/cart\"]")
	WebElement cart;
	
	@FindBy(xpath = "//li[@class=\"active last\"]/a")
	WebElement jewelryElement;
	
	
	public PLPObjects() {
		PageFactory.initElements(driver, this);
	}
	
    public void addingItemtoCart() {
    	cm.mouseOver(mainMenu, subMenu);
		addToCart.click();
		cm.waitInPage();
		cm.pageDown();
		addToCart1.click();
		cm.waitInPage();
    }
    
    public void CheckColorOnVerticalMenu() throws InterruptedException {
    	cm.mouseOver(mainMenu, subMenu);
    	cm.sleepIn();
    	mainMenu3.click();
    	String rgb = jewelryElement.getCssValue("color");
        String hexColor = Color.fromString(rgb).asHex();
        Assert.assertEquals("#4ab2f1", hexColor);
    	
    }
    
    public void clearCompareListofItems() throws InterruptedException {
    	cm.mouseOver(mainMenu, subMenu2);
		compareButton1.click();
		cm.sleepIn();
		compareButton2.click();
		cm.sleepIn();
		productCompare.click();
		clearList.click();
		cm.sleepIn();
		
    }
    public String getSKUCodeplp() {
    	return SKU1.getText();
    }
   
	//TC_PRODUCT_005
	public void verifyAddtoCart() throws InterruptedException {
		Assert.assertEquals(cartMessage.getText(), td.greenMessage);
	}
	//TC_PRODUCT_011
	public void verifyclearCompareList() throws InterruptedException {
		Assert.assertEquals(noItems.getText(), td.compareEmptymsg);
	}
	
	
		
	
}