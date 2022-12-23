package testObjectRepo;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestData.TestData;
import base.Base;

public class addToWishListObjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	
	@FindBy(xpath = "//a[@href=\"/apparel\"]")
	WebElement mainMenu;
	
	@FindBy(xpath = "//a[@href=\"/clothing\"]")
	WebElement submenu;
	
	@FindBy(xpath = "//button[@class=\"button-2 add-to-compare-list-button\"]/following::button[4]")
	WebElement wishListbtn;
	
	@FindBy(xpath = "//a[@href=\"/wishlist\"]")
	WebElement wishList;
	
	@FindBy(xpath = "//span[@id=\"sku-38\"]")
	WebElement productSKUnum;
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement checkBoxWish;
	
	@FindBy(xpath = "//button[@class=\"button-2 wishlist-add-to-cart-button\"]")
	WebElement addToCart;
	
	@FindBy(xpath = "//span[@class=\"cart-label\"]")
	WebElement goToCart;
	
	@FindBy(xpath = "//a[@class=\"product-name\"]")
	WebElement productName;
	
	@FindBy(xpath = "//span[@class=\"product-subtotal\"]")
	WebElement wlistPrice;
	
	@FindBy(xpath = "//a[@href=\"/books\"]")
	WebElement mainMenu2;
	
	@FindBy(xpath = "//button[@class=\"remove-btn\"]")
	WebElement removeBtn;
	
	@FindBy(xpath = "//input[@class=\"qty-input\"]")
	WebElement quantityWish;
	
	@FindBy(xpath = "//button[@id=\"updatecart\"]")
	WebElement updateCart;
	
	@FindBy(xpath = "//a[@class=\"product-name\"]")
	WebElement wishListProduct;
	
	@FindBy(xpath = "//div[@class=\"no-data\"]")
	WebElement emptyWishList;
	
	@FindBy(xpath = "//span[@class=\"product-subtotal\"]")
	WebElement updatePrice;
	
	public addToWishListObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void wishListProductDetails() {
		mainMenu2.click();
		wishListbtn.click();
		wishList.click();
		wishListProduct.click();
		String SKUtext = productSKUnum.getText();
		Assert.assertEquals(SKUtext,td.productSKUtext);
	}
	
	//TC_WISHLIST_003
	public void addToWishListCart() throws InterruptedException {
		cm.mouseOver(mainMenu, submenu);
		cm.pageDown();
		wishListbtn.click();
		cm.waitInPage();
		wishList.click();
		cm.waitInPage();
		checkBoxWish.click();
		addToCart.click();
		goToCart.click();
		assertEquals(productName.getText(), td.productName);
	}

	//TC_WISHLIST_007
	public void verifyWishListPrice() throws InterruptedException {
		
		cm.MenuClicking(mainMenu2);
		wishListbtn.click();
		wishList.click();
		checkBoxWish.click();
		quantityWish.clear();
		cm.waitInPage();
		quantityWish.sendKeys("5");
		updateCart.click();
		String updatePrice1 = updatePrice.getText();
		String newPrice = updatePrice1.replaceAll("$", "");
		Assert.assertEquals(newPrice, updatePrice1);
		
	}
	//TC_WISHLIST_002
	public void EmptyWishList() {
		cm.MenuClicking(mainMenu2);
		wishListbtn.click();
		wishList.click();
		removeBtn.click();
		
	}
	
	
	public void verifyEmptyWishList() {
		Assert.assertEquals(emptyWishList.getText(), td.wishListMsg);
	}
}