package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.Myaccount_page;

public class TC002_Login_test extends Random_details {
	@Test(groups = {"regression","master"})
	public void verify_login() {

		Home_page hp = new Home_page(driver);
		hp.clickmyaccount();
		hp.clicklogin();

		Login_page lp = new Login_page(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clklogin();

		Myaccount_page Myactpage = new Myaccount_page(driver);
		boolean actpage = Myactpage.myaccount();
		Assert.assertEquals(actpage, true, "Login Failed");

		Myactpage.clklogout();
		Myactpage.clickcontinue();
	}
}
