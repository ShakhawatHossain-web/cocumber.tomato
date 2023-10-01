package pageObject;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByEmail {
	WebDriver ldriver;
	
	public SearchCustomerByEmail(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}	
	
	//find elements on the target website
	@FindBy(xpath = "//input[@id='searchemail']")
	WebElement emailTextBox1;
	
	@FindBy(xpath = "//input[@id='searchemail']")
	WebElement searchButton;
	
	@FindBy(xpath = "//input[@id='searchemail']")
	WebElement searchResult;
	
	@FindBy(xpath = "//input[@id='searchemail']")
	List<WebElement> tableRow;
	
	@FindBy(xpath = "//input[@id='searchemail']")
	List <WebElement> tableColumn;
	
	public void enterEmail() {
		emailTextBox1.sendKeys("EmailID");
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
			
	public void searchCustomerByEmail() throws InterruptedException {
		boolean found = false;
		int rows = tableRow.size();
		int columns = tableColumn.size();
		
		for(int i=0; i<=rows; i++) {
			JavaScriptUtil.scrollIntoView(emailTextBox1, ldriver);
			Thread.sleep(2000);
		}	
	}
}