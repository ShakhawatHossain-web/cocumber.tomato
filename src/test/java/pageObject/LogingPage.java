package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Interview Question, what is page object models

public class LogingPage {
	WebDriver ldriver;
	
	public LogingPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loging;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutbutton;
	
	public void enterEmail(String emailID) {
		email.clear();
		email.sendKeys(emailID);
	}
	
	public void enterPassword(String passWord) {
		password.clear();
		password.sendKeys(passWord);
	}
	
	public void clickLogin() {
		loging.click();
	}
	public void clickLogOut() {
		logoutbutton.click();

	}
}
