package stepDefination;

	import org.testng.AssertJUnit;
	import javax.security.auth.login.LoginContext;

import org.junit.Assert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.cucumber.java.en.*;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import pageObject.AddNewCustomerPage;
	import pageObject.LogingPage;
	import pageObject.SearchCustomerByEmail;

	public class StepDefinationAnother {
		public WebDriver driver;
		public LogingPage lp;
		
		public AddNewCustomerPage scbe = new AddNewCustomerPage(driver);
		
		@Given("User Launch Chrome browser")
		public void user_launch_chrome_browser() {
		    
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    
		    lp = new LogingPage(driver);      
		}

		@When("User opens URL {string}")
		public void user_opens_url(String url) {
		    driver.get(url);
		}

		@When("User enters Email as {string} and Password as {string}")
		public void user_enters_email_as_and_password_as(String emailAdd, String passwordAdd) {
			lp.enterEmail(emailAdd);
			lp.enterPassword(passwordAdd);
		}

		@When("click on Login")
		public void click_on_login() {
		    lp.clickLogin();
		}
		
		@Then("Page Title should be {string}")
		public void page_title_should_be(String expectedTitle) {
		 String actualTitle = driver.getTitle();
		 System.out.println(actualTitle);
		 
		 if (actualTitle.equals(expectedTitle)) {
			 Assert.assertTrue(true); //pass
		 }
		 else {
			 Assert.assertTrue(false); //fail
		 	}
		    
		}
		@When("User click on Log out link")
		public void user_click_on_log_out_link() {
		    lp.clickLogOut();
		}
		
		@Then("close browser")
		public void close_browser() {
		    driver.close();
		    driver.quit();
		}
		/////// Add New Customer ///////
		
		@Then("User can view Dashboard")
		public void user_can_view_dashboard() {
		    
			String ActualTitle = scbe.GetTitle();
			String ExpectedTitle = "Dashboard / nopCommerce administration";
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		}

		@When("User click on customers menu")
		public void user_click_on_customers_menu() {
		    
			scbe.ClickOnCustomerMenu(null);
		    
		}

		@When("click on customers Menu Item")
		public void click_on_customers_menu_item() {
		    
			scbe.ClickOnCustomerMenu(null);;
		}

		@When("click on Add new button")
		public void click_on_add_new_button() {
		    
			scbe.ClickOnAddNew();
		    
		}

		@Then("User can view and Add new customer page")
		public void user_can_view_and_add_new_customer_page() {
		    // this is the verification/checkpoint, verify the NEW page title
			
			String ExpectedTitle = "Add a new customer / nopCommerce administration";
		    String ActualTitle = scbe.GetTitle();
		    
		    Assert.assertEquals(ActualTitle, ExpectedTitle);
		    
		}

		@When("User enetr customer info")
		public void user_enetr_customer_info() throws InterruptedException {
		    
			Thread.sleep(1000);
			
			scbe.EnterEmail("shaku@gmail.com");
			//ancp.EnterEmail(generateEmailId() + "@gmail.com");
			Thread.sleep(1000);
			scbe.EnterPassword("Test1234");
			Thread.sleep(1000);
			scbe.EnterFirstName("Shaku");
			Thread.sleep(1000);
			scbe.EnterLastName("Hossain");
			Thread.sleep(1000);
			scbe.EnterDOB("6/12/1949");
			Thread.sleep(1000);
			scbe.CompanyName("PnT");
			Thread.sleep(1000);
			scbe.EnterGender("Male");
			Thread.sleep(1000);
		}

		@When("click on Save button")
		public void click_on_save_button() {
		    
			scbe.addButton();
		}

		@Then("User can view confirmation message {string}")
		public void user_can_view_confirmation_message(String ExpectedConfirmMessage) {
		    
			String text = driver.findElement(By.tagName("Body")).getText();
			
			if (text.contains(ExpectedConfirmMessage)) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		/////// Search customer by email ////
		
		@When("Enter customer Email")
		public void enter_customer_email() {
			scbe.EnterEmail("CVAUM@gmail.com");
		    
		}

		@When("click on search button")
		public void click_on_search_button() {
			scbe.ClickOnSearchButton();
		    
		}

		@Then("User should found Email in the search table")
		public void user_should_found_email_in_the_search_table() throws InterruptedException {
		   String ExpectedEmail = "CVAUM@gmail.com";
		   Assert.assertTrue(scbe.SearchCustomerByEmail(ExpectedEmail));   
		}
	}