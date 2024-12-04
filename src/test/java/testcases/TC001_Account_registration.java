package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Register_page;

public class TC001_Account_registration extends Random_details {

	@Test(groups = { "sanity", "master" })
	public void Verify_Account_registration() {
		// Homepage Class under PageObject package
		Home_page hp = new Home_page(driver);
		hp.clickmyaccount();
		hp.clickregister();

		// Registration Page under Pageobject Package
		Register_page reg_page = new Register_page(driver);

		// Random Alphabets and Number under Testcase package
		reg_page.sendfirstname(randomstring());
		reg_page.sendlastname(randomstring());
		reg_page.sendemail(randomstring() + "@gmail.com");
		reg_page.sendtelephone(randomnumber());
		String pwd = randomalphanumberic();
		reg_page.sendpwd(pwd);
		reg_page.sendconfirmpwd(pwd);
		reg_page.clickconfirm();
		reg_page.clickcontinue();
		String confmsg = reg_page.getconfirmationmsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		reg_page.clickconfirmcontinue();

	}
}
