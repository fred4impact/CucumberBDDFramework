package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
  public WebDriver driver;
  
  
	  public LoginPage(WebDriver driver) {
		  
		  PageFactory.initElements(driver, this);
	  }
	  
	  // objects of login page 
	  
		@FindBy(xpath="//*[@id=\"Email\"]")
		@CacheLookup
		WebElement txtEmail;
		
		@FindBy(xpath="//*[@id=\"Password\"]")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@value='Log in']")
		@CacheLookup
		WebElement btnLogin;
	
		@FindBy(xpath="//a[contains(text(),'Logout')]")
		WebElement lnkLogout;
		
		
		// user actions on login page as method here 
		
		public void setUsername(String email) {
			txtEmail.clear();
			txtEmail.sendKeys(email);
		}
		
		public void setPassword(String password) {
			txtPassword.clear();
			txtPassword.sendKeys(password);
		}
		
		public void clickLogin() {
			btnLogin.submit();
		}
		
		public void clickLogout() {
		  lnkLogout.click();
		}

		

}
