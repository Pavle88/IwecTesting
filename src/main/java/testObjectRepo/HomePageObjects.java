package testObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Base;

public class HomePageObjects extends Base{
	
    @FindBy(xpath = "//a[@class=\"ico-login\"]")
    WebElement loginTopMenuLink;
    
    @FindBy(xpath = "//a[@class=\"ico-register\"]")
    WebElement registerTopMenuLink;
    
    @FindBy(xpath = "//a[@class=\"ico-logout\"]")
    WebElement logoutBtn;
    
    public HomePageObjects() {
    	PageFactory.initElements(driver, this);
    }
  
    public void navigateToLoginPage() {
    	loginTopMenuLink.click();
    }
    public void navigateToRegisterPage() {
    	registerTopMenuLink.click();
    }
    
    public void logoutUser() {
    	logoutBtn.click();
    }
}
