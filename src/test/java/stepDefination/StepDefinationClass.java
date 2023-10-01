package stepDefination;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LogingPage;

public class StepDefinationClass {
	
	public WebDriver driver;
	
	public LogingPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Allocating memory to loging page
		lp = new LogingPage(driver);   
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailID, String passwordAdd) {
	    lp.enterEmail(emailID);
	    lp.enterPassword(passwordAdd);
	}

	@When("click on Login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		
		if(actualtitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // pass
		}
		else {
			Assert.assertTrue(false);// Fail
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
}