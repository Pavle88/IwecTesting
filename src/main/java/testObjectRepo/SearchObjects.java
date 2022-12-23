package testObjectRepo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestData.TestData;
import base.Base;

public class SearchObjects extends Base {
	
	TestData td = new TestData();
	CommonFunction cm = new CommonFunction();
	PDPobjects pd = new PDPobjects();
	
	@FindBy(xpath = "//input[@id=\"small-searchterms\"]")
	WebElement searchItem;
	
	@FindBy(xpath = "//button[@class=\"button-1 search-box-button\"]")
	WebElement Searchbtn;
	
	@FindBy(xpath = "//div[@class=\"warning\"]")
	WebElement error1;
	
	@FindBy(id = "advs")
	WebElement advancedCheck;
	
	@FindBy(xpath = "//div[@class=\"details\"]/h2/a")
	WebElement details;
	
	@FindBy(xpath = "//span[@id=\"sku-5\"]")
	WebElement pageSKU;
	
		
	public SearchObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchItem(String item) {
		searchItem.sendKeys(item);
		Searchbtn.click();
	}
	public void searchEmpty(String item2) {
		Searchbtn.click();
		
    }
	public void searchAdvance(String item) {
		searchItem.sendKeys(item);
		Searchbtn.click();
		advancedCheck.click();
		Searchbtn.click();
		
	}
	public void autoSuggestionKeybordKeys(String keyword) throws InterruptedException  {
		searchItem.sendKeys(keyword);
		cm.sleepIn();
		searchItem.sendKeys(Keys.DOWN);
		searchItem.sendKeys(Keys.ENTER);
		cm.sleepIn();
		String textSKU = pageSKU.getText();
		Assert.assertEquals(textSKU, td.productSKU);
		
	}
	public void verifySearchedItem() {
		Assert.assertEquals(driver.getCurrentUrl(), td.searchTitle);
	}
	public void verifyWrongSearch() {
		Assert.assertEquals(error1.getText(), td.searchError);
	}
	public void verifyEmptySearch() {
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), td.alert);
	}
	public void advancedSearch() {
		Assert.assertEquals(details.getText(), td.searchDetail);
	}
	
	}
