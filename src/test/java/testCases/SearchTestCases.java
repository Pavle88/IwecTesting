package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestData.TestData;
import base.Base;
import testObjectRepo.HomePageObjects;
import testObjectRepo.SearchObjects;

public class SearchTestCases extends Base {

	HomePageObjects hp;
	SearchObjects so;
	TestData td;
	
	
	@BeforeMethod
	public void start() {
		openAplication();
		hp = new HomePageObjects();
		so = new SearchObjects();
		td = new TestData();
	}
	
	@AfterMethod 
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void searchItembyName() {
		so.SearchItem(td.searchItem);
		so.verifySearchedItem();
	}
	
	@Test
	public void searchWrongKeyword() {
		so.SearchItem(td.searchedItem2);
		so.verifyWrongSearch();
	
}
	//click on Search and assert the Alert
	@Test
	public void searchAlert() {
		so.searchEmpty(td.emptySearchedItem3);
		so.verifyEmptySearch();
		    
	}
	@Test
	public void advanceSearch() {        
		so.SearchItem(td.searchItem3);
		so.advancedSearch();
	}
	//search using keys down and enter
	@Test
	public void autoSuggestionKeys() throws InterruptedException {
		so.autoSuggestionKeybordKeys(td.keyword);
	}
	
}