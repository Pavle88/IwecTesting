package testObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class addToCartObjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	PLPObjects po = new PLPObjects();
	PDPobjects pd = new PDPobjects();
	
	@FindBy(xpath = "//a[@href=\"/computers\"]")
	WebElement mainMenu;
	
	@FindBy(xpath = "//a[@href=\"/desktops\"]")
	WebElement subMenu;
	
	@FindBy(xpath = "//a[@href=\"/apparel\"]")
	WebElement mainMenu2;
	
	@FindBy(xpath = "//button[@class=\"button-2 add-to-wishlist-button\"]/following::button")
	WebElement addToCart;
	
	@FindBy(xpath = "//a[@href=\"/cart\"]")
	WebElement goToCart;
	
	@FindBy(xpath = "//input[@id=\"giftcardcouponcode\"]")
	WebElement giftCardcoupon;
	
	@FindBy(xpath="//button[@id=\"applygiftcardcouponcode\"]")
	WebElement addGiftCard;
	
	@FindBy(xpath = "//button[@id=\"applygiftcardcouponcode\"]/following::div")
	WebElement giftCardError;
	
	@FindBy(xpath = "//input[@id=\"discountcouponcode\"]")
	WebElement couponNum;
	
	@FindBy(xpath = "//button[@id=\"applydiscountcouponcode\"]")
	WebElement couponBtn;
	
	@FindBy(xpath = "//span[@class=\"applied-discount-code\"]")
	WebElement validCoupon;
	
	@FindBy(xpath = "//button[@id=\"add-to-cart-button-27\"]")
	WebElement addToCart2;
	
	@FindBy(xpath = "//a[@href=\"/cart\"]")
	WebElement cart;
	
	@FindBy(xpath = "//span[@class=\"sku-number\"]")
	WebElement shcartSKUcode;
	
	@FindBy(xpath = "//input[@id=\"itemquantity11228\"]")
	WebElement quantityCart;
	
	@FindBy(xpath = "//button[@id=\"updatecart\"]")
	WebElement updateBtnCart;
	
	@FindBy(xpath = "//span[@class=\"product-unit-price\"]")
	WebElement priceCart1;
	
	@FindBy(xpath = "//a[@href=\"/electronics\"]")
	WebElement MainMenu;
	
	@FindBy(xpath = "//a[@href=\"/software\"]")
	WebElement submenu;
	
	@FindBy(xpath = "//a[@href=\"/cell-phones\"]")
	WebElement subMenu2;
	
	@FindBy(xpath = "//button[@class=\"button-2 add-to-wishlist-button\"]/following::button")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//button[@class=\"button-2 product-box-add-to-cart-button\"]")
	WebElement addTocartBtn;
	
	@FindBy(xpath = "//button[@class=\"button-2 add-to-compare-list-button\"]/following::button[2]")
	WebElement addToCartBtn2;
	
	@FindBy(xpath = "//button[@class=\"button-2 add-to-compare-list-button\"]/following::button[5]")
	WebElement addToCartBtn3;
	
	@FindBy(xpath = "//button[@class=\"remove-btn\"]")
	WebElement removeBtn;
	
	@FindBy(xpath = "//input[@id=\"termsofservice\"]")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[@id=\"checkout\"]")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "//div[@class=\"no-data\"]")
	WebElement EmptyCartMsg;
	
	public addToCartObjects() {
	PageFactory.initElements(driver, this);
}  
	
	public void emptyCart() throws InterruptedException {
		cm.mouseOver(MainMenu, subMenu2);
		addToCartBtn.click();
		cm.sleepIn();
		addToCartBtn2.click();
		cm.sleepIn();;
		addToCartBtn3.click();
		cm.sleepIn();
		goToCart.click();
		removeBtn.click();
		removeBtn.click();
		Assert.assertEquals(EmptyCartMsg.getText(), td.emptyCartMsg);
	}
	
	//verify discount code
	public void addingToGiftCard() {
		cm.mouseOver(mainMenu,submenu);
		addToCart.click();
		cm.waitInPage();
		goToCart.click();
		giftCardcoupon.sendKeys("123");
		addGiftCard.click();
	}
	 //adding Valid coupon in cart
	public void validCouponInCart() {
		cm.mouseOver(mainMenu,submenu);
		addToCart.click();
		cm.waitInPage();
		goToCart.click();
		couponNum.sendKeys("123");
		couponBtn.click();
	}
	//Testing if SKU in PDP and Cart is the same
	 public  void testingSKU()  {
			cm.mouseOver(mainMenu2, po.subMenu3);
			po.picture.click();
			cm.waitInPage();
			String SKUtext = po.getSKUCodeplp();
			cm.selectInMenu();
		    po.quantity.clear();
		    po.quantity.sendKeys("4");
		    po.addToCart2.click();
		    cart.click();
		    String scSKUcode = shcartSKUcode.getText();
		    cm.waitInPage();
		    Assert.assertEquals(SKUtext, scSKUcode);
		    
	   }
	 	//Check if the price are changing after quantity change
	 public void checkPriceChangeAfterQuantityChange() {
		 	cm.mouseOver(mainMenu2,po.subMenu3);
			pd.picture2.click();
			pd.addToCartbtnPDP.click();
			cm.waitInPage();
			goToCart.click();
			quantityCart.clear();
			String str = quantityCart.getAttribute("value");
			quantityCart.sendKeys("3");
			updateBtnCart.click();
			String s = priceCart1.getText();
			String newPrice = s.replace("$", "");
			double newPrice1 = Double.parseDouble(newPrice);
			double price3more = 40.00;
			double price6more = 38.00;
			double price10more = 35.00;
			int quantity = Integer.parseInt(str);
			{
			if(quantity >=3 && quantity <5){
				Assert.assertEquals(newPrice1, price3more);
			}
			else if (quantity >=6 && quantity<=9) {
				Assert.assertEquals(newPrice1, price6more);
			}
			else if (quantity >=10) {
				Assert.assertEquals(newPrice1, price10more);
			}
			}
			
		}
	
	public void verifyAddGiftCard() throws InterruptedException {
		Assert.assertEquals(giftCardError.getText(), td.giftCoupError);
		
}
	public void verifyCouponInCart () {
		Assert.assertEquals(validCoupon.getText(), td.greenMessageCoupon);
		
	}

	public void verifyPriceChange() {
		Assert.assertEquals(validCoupon.getText(), td.greenMessageCoupon);
	}

}