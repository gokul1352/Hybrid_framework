package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basepage.Basepage;

public class Login_page extends Basepage {

	public Login_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement lnkloginfield;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement lnkpasswordfield;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnlogin;

	public void setemail(String email) {
		lnkloginfield.sendKeys(email);
	}

	public void setpassword(String password) {
		lnkpasswordfield.sendKeys(password);
	}

	public void clklogin() {
		btnlogin.click();
	}
}
