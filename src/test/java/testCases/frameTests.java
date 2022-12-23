package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.TestData;
import base.Base;
	

	public class frameTests extends Base {

		TestData td;
		
		@BeforeMethod
		public void start() {
			openBrowser();
			td = new TestData();
			driver.navigate().to("https://testpages.herokuapp.com/styled/frames/frames-test.html");
			
		}
		@AfterMethod 
		public void end() throws InterruptedException {
			Thread.sleep(2000);
			driver.quit();
		}
		@Test
		public void frameCheck() {
			driver.switchTo().frame(2);
			String frame = driver.findElement(By.xpath("//li[@id=\"middle4\"]")).getText();
			Assert.assertEquals(frame, td.frameText);
			
		}
		@Test
		public void frameCheck1() {
			driver.switchTo().frame("right");
			String frame = driver.findElement(By.id("right2")).getText();
			Assert.assertEquals(frame, td.frameText1);
			
		}
		@Test
		public void frameCheck2() {
			driver.switchTo().frame("right");
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			String textFrame = driver.findElement(By.xpath("//li[@id=\"left3\"]")).getText();
			Assert.assertEquals(textFrame, td.frameText2);
			
		}
	}