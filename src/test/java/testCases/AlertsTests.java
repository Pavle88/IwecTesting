package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
	

	public class AlertsTests extends Base {

		TestData td;
		
		@BeforeMethod
		public void start() {
			openBrowser();
			td = new TestData();
			driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
			
		}
		@AfterMethod 
		public void end() throws InterruptedException {
			Thread.sleep(2000);
			driver.quit();
		}
		//Click on alert
	@Test
	public void clickOnAlert() {
		WebElement btn = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
		btn.click();
		driver.switchTo().alert().accept();
		String text = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertEquals(text,td.alertMessage1);
	}
	@Test
	public void dismisAlert() {
		WebElement btn2 = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
		btn2.click();
		driver.switchTo().alert().dismiss();
		String cancel = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertEquals(cancel,td.alertMessageCancel);
	}
	@Test
	public void acceptTheAlert() {
		WebElement btn2 = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
		btn2.click();
		driver.switchTo().alert().accept();
		String accept = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertEquals(accept,td.alertMessageAccept);
	}
	@Test
	public void enterInAlert() {
		WebElement btn3 = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
		btn3.click();
		driver.switchTo().alert().sendKeys("Success");
		driver.switchTo().alert().accept();
		String enter = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertEquals(enter,td.alertMessageEnter);
	}
	@Test
	public void dismisEnterInAlert() {
		WebElement btn3 = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
		btn3.click();
		driver.switchTo().alert().dismiss();
		String dismiss = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertEquals(dismiss,td.alertMessageSkipEnter);
	}
	}