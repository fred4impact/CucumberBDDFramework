package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;


public class loginSteps {
	
	
	public WebDriver driver;
	LoginPage login;
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
	    // Write selenium steps to launch the chrome browser
	   // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
        login = new LoginPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get(url);
	   driver.manage().window().maximize();
	   
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	    // user set email & password
	   login.setUsername(email);
	   login.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
	    // user clicks on the login button
		login.clickLogin();
	  
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
	    // Write code here that turns the phrase above into concrete actions
	   
		 //String pageSource = driver.getPageSource();
		
		 if(driver.getPageSource().contains("Login was unsuccesful ")) {
		   driver.close(); // closes the application 
	       Assert.assertTrue(false);
		   
		 }else {
			 // this verify the page title is correct
		   Assert.assertEquals(title, driver.getTitle());
		 }
		
	}

	@When("User click on log out Link")
	public void user_click_on_log_out_Link() throws InterruptedException {
		Thread.sleep(5000);
		login.clickLogout();
	  
	}


	@Then("close browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}		
	

}
