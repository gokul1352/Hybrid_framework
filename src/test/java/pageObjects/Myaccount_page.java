package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basepage.Basepage;

public class Myaccount_page extends Basepage {

	public Myaccount_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myacco;

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continuelogout;

	public boolean myaccount() {

		try {
			return (myacco.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}

	public void clklogout() {
		logout.click();
	}

	public void clickcontinue() {
		continuelogout.click();
	}

}
