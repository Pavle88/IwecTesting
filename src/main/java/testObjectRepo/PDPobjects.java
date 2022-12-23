package testObjectRepo;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class PDPobjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	
	@FindBy(id = "Email")
	WebElement emailInputField;
	
	@FindBy(xpath = "//input[@id=\"Password\"]")
	WebElement passwordInputField;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//a[@href=\"/digital-downloads\"]")
	WebElement mainMenu;
	
	@FindBy(xpath = "//a[@href=\"/computers\"]")
	WebElement mainMenu4;
	
	@FindBy(xpath = "//a[@href=\"/software\"]")
	WebElement submenu;
	
	@FindBy(xpath = "//img[@alt=\"Picture of Night Visions\"]")
	WebElement picture;
	
	@FindBy(xpath = "//a[@class=\"button-2 download-sample-button\"]")
	WebElement downloadBtn;
	
	@FindBy(xpath = "//a[@href=\"/books\"]")
	WebElement mainMenu2;
	
	@FindBy(xpath = "//a[@href=\"/jewelry\"]")
    WebElement MainMenu3;
	
	@FindBy(xpath = "//img[@alt=\"Picture of Pride and Prejudice\"]")
	WebElement picture1;
	
	@FindBy(xpath = "//img[@alt=\"Picture of Levi's 511 Jeans\"]")
	WebElement picture2;
	
	@FindBy(xpath = "//img[@alt=\"Picture of Elegant Gemstone Necklace (rental)\"]")
	WebElement picture3;
	
	@FindBy(id = "rental_start_date_40")
	WebElement startDate;
	
	@FindBy(id ="rental_end_date_40")
	WebElement endDate;
	
	@FindBy(id ="add-to-cart-button-40")
	WebElement rentBtn;
	
	@FindBy(xpath = "//span[@id=\"sku-40\"]")
	WebElement SKU1;
	
	@FindBy(xpath = "//span[@class=\"sku-number\"]")
	WebElement SKU2;
	
	@FindBy(xpath = "//a[@href=\"/cart\"]")
	WebElement goToCart;
	
	@FindBy(xpath = "//button[@class=\"button-2 email-a-friend-button\"]")
	WebElement emailToFriend;
	
	@FindBy(id = "FriendEmail")
	WebElement friendEmail;
	
	@FindBy(xpath = "//button[@id=\"add-to-cart-button-30\"]")
	WebElement addToCartbtnPDP;
	
	@FindBy(xpath = "//input[@id=\"YourEmailAddress\"]")
	WebElement yourEmail;
	
	@FindBy(id = "PersonalMessage")
	WebElement emailMsg;
	
	@FindBy(xpath = "//button[@class=\"button-1 send-email-a-friend-button\"]")
	WebElement sendEmail;
	
	@FindBy(xpath = "//div[@class=\"result\"]")
	WebElement msgSent;
	
	@FindBy(xpath = "//a[@href=\"/adobe-photoshop-cs4\"]")
	WebElement picture4;
	
	@FindBy(xpath = "//a[@class=\"producttag\"]")
	WebElement awesomeTag;
	
	@FindBy(xpath = "//a[@href=\"/lenovo-thinkpad-x1-carbon-laptop\"][1]/following::a[2]")
	String pictureWithTag;
	
	public PDPobjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void productRent() throws InterruptedException, IOException {
		cm.MenuClicking(MainMenu3);
		picture3.click();
		startDate.click();
		cm.sleepIn();
		startDate.sendKeys("12/15/2022");
		endDate.click();
		endDate.sendKeys("12/31/2022");
		rentBtn.click();
		takeSnapshot();
		String SKUCODEPDP = SKU1.getText();
		cm.sleepIn();
		goToCart.click();
		cm.sleepIn();
		String SKUcodeCart = SKU2.getText();
		Assert.assertEquals(SKUCODEPDP,SKUcodeCart);	
	}
	public void productShare() throws InterruptedException {
		cm.MenuClicking(mainMenu2);
		picture1.click();
		Thread.sleep(3000);
		cm.pageDown();
		emailToFriend.click();
		cm.waitInPage();
		friendEmail.sendKeys(td.friendEmail);
		yourEmail.clear();
		yourEmail.sendKeys(td.validEmail1);
		emailMsg.sendKeys(td.emailToFmsg);
		sendEmail.click();
	}
	
	//TC_DETAILS_013
	public void popUpDigitalSample() {
		cm.MenuClicking(mainMenu);
		picture.click();
		downloadBtn.click();
		File fileLocation = new File("C:\\Users\\Pavle\\Downloads");
		File[] totalFiles = fileLocation.listFiles();
		boolean found = false;
		File f = null;
		     for (File listOfFile : totalFiles) {
		         if (listOfFile.isFile()) {
		              String fileName = listOfFile.getName();
		               if (fileName.matches(fileName)) {
		                   f = new File(fileName);
		                   found = true;
		                }
		            }
		        }
		Assert.assertTrue(found, "Downloaded document is not found");
		f.deleteOnExit();
	}
	
	public void checkAwesomeTag() {
		cm.mouseOver(mainMenu4, submenu);
		picture4.click();
		awesomeTag.click();
	}

	//TC_DETAILS_005
	public void checkShareProduct() throws InterruptedException {
		
		Assert.assertEquals(msgSent.getText(), td.messageSent);
		
	}
	public void verifyAwesometag() {
		Assert.assertEquals(driver.getCurrentUrl(), td.awesomeTagpage);
		Assert.assertTrue(true, pictureWithTag);
	}


	


	
}