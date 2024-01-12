package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testbase.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import utilities.DataProviders;

public class TC003_VerifyLoginDDT extends BaseClass
{
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void verifylogin(String email,String password, String exp)
	{
		logger.info("Startin TC003_VerifyLoginDDT");
		try {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		Loginpage lp = new Loginpage(driver);
		lp.setEmailId(email);
		lp.setPassword(password);
		lp.clicklogin();
		
		Myaccountpage myacc = new Myaccountpage(driver);
		boolean targetpage = myacc.textpresent();
		System.out.println(targetpage);
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				myacc.clicklogoff();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				myacc.clicklogoff();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
	}

}
