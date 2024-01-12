package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;

public class TC001_AccountRegistrationTest extends BaseClass {
		
	@Test(groups = {"master","regression"})
	public void verify_AccountRegistration() 
	{
		logger.debug("Test Execution started");
		try {
			
	logger.info("Test Execution Started..");
	Homepage hp = new Homepage(driver);
	logger.info("Click on Myaccount link");
	hp.clickMyAccount();
	logger.info("Click on Register link");
	hp.clickRegister();
	
	logger.info("Enter details on Register Screen");
	AccountRegistrationPage reg = new AccountRegistrationPage(driver);
	reg.setFirstname(randomString().toUpperCase());
	reg.setLastname(randomString().toUpperCase());
	reg.setEmail(randomString()+"@gmail.com");
	String password = randomString();
	reg.setPhonenumber(randomnumber());
	reg.setPassword(password);
	reg.setConfirmPassword(password);
	reg.clickcheckbox();
	reg.clickSubmit();
		
	logger.info("Conformation Message");
	String confmsg=reg.getConfirmationMsg();
	if(confmsg.equals("Your Account Has Been Created!!"))
	{
		logger.info("Test case Passed");
		Assert.assertTrue(true);
	}
	}
		catch(Exception e)
		{
			Assert.assertFalse(false);
			logger.error("Test case Failed");
		}
	}

	
}
