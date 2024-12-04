package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basepage.Basepage;

public class Home_page extends Basepage {

	//Constructor
	public Home_page(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement lnkmyaccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement lnkregister;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement lnklogin;
	//Actions
	
	public void clickmyaccount() {
		lnkmyaccount.click();
	}
	public void clickregister() {
		lnkregister.click();
	}
	public void clicklogin() {
		lnklogin.click();
	}
}
