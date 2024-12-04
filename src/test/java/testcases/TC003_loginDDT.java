package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.Myaccount_page;

public class TC003_loginDDT extends Random_details {
	@Test(dataProvider = "LoginData", dataProviderClass = utilities.Dataproviders.class, groups = { "datadriven",
			"master" })
	// Getting dataprovider from different class,if dataprovider in same class
	// (dataproviderclass) is not required
	public void verifylogin_DDT(String email, String pwd, String exp) {

		Home_page hp = new Home_page(driver);
		hp.clickmyaccount();
		hp.clicklogin();

		Login_page lp = new Login_page(driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clklogin();

		Myaccount_page Myactpage = new Myaccount_page(driver);
		boolean actpage = Myactpage.myaccount();

		if (exp.equalsIgnoreCase("Valid")) {
			if (actpage == true) {
				Assert.assertTrue(true);
				Myactpage.clklogout();
				Myactpage.clickcontinue();

			} else {
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("Invalid")) {
			if (actpage == true) {

				Myactpage.clklogout();
				Myactpage.clickcontinue();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	}
}
