package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basepage.Basepage;

public class Register_page extends Basepage {

//Constructor
	public Register_page(WebDriver driver) {
		super(driver);
	}

//Locators
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txtfirstname;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txtlastname;

	@FindBy(xpath = "//input[@name='email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement txttelephone;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txtpwd;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement txtconfirmpwd;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkbtn;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgconfirmation;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnconfirmcontinue;
//Actions
	public void sendfirstname(String firstname) {
		txtfirstname.sendKeys(firstname);
	}

	public void sendlastname(String lastname) {
		txtlastname.sendKeys(lastname);
	}

	public void sendemail(String email) {
		txtemail.sendKeys(email);
	}

	public void sendtelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}

	public void sendpwd(String pwd) {
		txtpwd.sendKeys(pwd);
	}

	public void sendconfirmpwd(String pwd) {
		txtconfirmpwd.sendKeys(pwd);
	}

	public void clickconfirm() {
		chkbtn.click();
	}

	public void clickcontinue() {
		btncontinue.click();
	}

	public String getconfirmationmsg() {
		try {
			return (msgconfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clickconfirmcontinue() {
		btnconfirmcontinue.click();
	}

}
