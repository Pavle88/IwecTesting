package testObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class explicitWaits extends Base {
	
	TestData td = new TestData();
	
	@FindBy(xpath = "//div[@id=\"start\"]/button")
	WebElement Startbtn;
	
	@FindBy(xpath = "//button[@id=\"ajaxButton\"]")
	WebElement Ajaxtbtn;
	
	@FindBy(xpath = "//div[@id=\"finish\"]/h4")
	WebElement  messageHello;
	
	@FindBy(xpath = "//p[@id=\"text\"]")
	WebElement messageDone;
	
	@FindBy(xpath = "//button[@id=\"button00\"]")
	WebElement button1;
	
	@FindBy(xpath = "//button[@id=\"button01\"]")
	WebElement button2;
	
	@FindBy(xpath = "//button[@id=\"button02\"]")
	WebElement button3;
	
	@FindBy(xpath = "//button[@id=\"button03\"]")
	WebElement button4;
	
	@FindBy(xpath = "//p[@id=\"buttonmessage\"]")
	WebElement messageSuccess;
	
	@FindBy(xpath = "//p[@class=\"bg-success\"]")
	WebElement successWait;
	
	
	public explicitWaits() {
	PageFactory.initElements(driver, this);
}
	public void waitsInBrowser() {
		Startbtn.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"finish\"]/h4")));
	}
	
	public void waitsInBrowser1() {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@id=\"text\"]"), "Done"));
		
	}
	public void waitsInBrowser2() {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(button1));
		button1.click();
		wait.until(ExpectedConditions.elementToBeClickable(button2));
		button2.click();
		wait.until(ExpectedConditions.elementToBeClickable(button3));
		button3.click();
		wait.until(ExpectedConditions.elementToBeClickable(button4));
		button4.click();
		WebDriverWait wait1 = new WebDriverWait(driver,50);
		wait1.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@id=\"buttonmessage\"]"), "All Buttons Clicked"));
		
	}
	public void waitsInBrowserButtonClick() {
		Ajaxtbtn.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"bg-success\"]")));
	}
	
	public void verifyMessageinBrowser() throws InterruptedException {
		Assert.assertEquals(messageHello.getText(), td.waitMessage);
		
}
	public void verifyMessageinBrowser1() throws InterruptedException {
		Assert.assertEquals(messageDone.getText(), td.waitingMessage2);
}
	public void verifyMessageinBrowser2() throws InterruptedException {
		Assert.assertEquals(messageSuccess.getText(), td.waitingMessage3);
}
	public void verifyMessageinBrowser3() throws InterruptedException {
		Assert.assertEquals(successWait.getText(), td.waitingMessage4);
}
	
}