package testCases;

import java.io.IOException;
import org.apache.logging.log4j.core.config.Loggers;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;


public class TC_002_VerifyLogin extends BaseClass
{
	public Loggers loggers;
	@Test(groups = {"master","Sanity"})
	public void verify_login() throws IOException
	{
		//logger.info("Test Execution Started");
		try {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("Landed on Login screen");		
		Loginpage lp = new Loginpage(driver);
		lp.setEmailId(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();
		
		Myaccountpage myacc = new Myaccountpage(driver);
		boolean pageenable = myacc.textpresent();
		Assert.assertEquals(pageenable, true, "Test case passed");
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	
}
