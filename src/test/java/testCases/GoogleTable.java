package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Base;
	

	public class GoogleTable extends Base {

		
		
		@BeforeMethod
		public void start() {
			openBrowser();
			driver.navigate().to("http://uitestingplayground.com/dynamictable");
			
		}
		@AfterMethod 
		public void end() throws InterruptedException {
			Thread.sleep(2000);
			driver.quit();
		}
		//check if google cpu in the table with text under the table are same
	@Test
	public void checkGoogleCPU() {
		String google = driver.findElement(By.xpath("//span[contains(text(),'Chrome')]/following::span[contains(text(),'%')]")).getText();
		String google2 = driver.findElement(By.xpath("//p[@class=\"bg-warning\"]")).getText();
		String newText = google2.replaceAll("[Chrome CPU: ]*", "");
		Assert.assertEquals(google, newText);
		
	}
}
