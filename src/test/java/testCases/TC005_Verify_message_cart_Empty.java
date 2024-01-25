package testCases;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.core.config.Loggers;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.BaseClass;
import pageObjects.Cartpopup;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import pageObjects.SearchResult;

public class TC005_Verify_message_cart_Empty extends BaseClass
{

	public Loggers loggers;
	
	@Test(groups= {"master"})
	public void Verify_message_when_cart_empty()
	{
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		Loginpage lp = new Loginpage(driver);
		lp.setEmailId(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();
		
		Myaccountpage accp = new Myaccountpage(driver);
		boolean txtpresent = accp.textpresent();
		Assert.assertEquals(txtpresent, true);
		
		accp.SearchProduct(p.getProperty("searchProductName"));
		accp.clickSearch();
		
		SearchResult sr = new SearchResult(driver);
		sr.SearchPage();
		sr.ClickAddtoCart();
		sr.ConfirmationMessage();
		sr.Clickcart();
		
		Cartpopup cp = new Cartpopup(driver);
		cp.Closepopup();
		sr.Clickcart();
		cp.CartEmptymessagestatus();
		cp.getmessage();
				
		
	}
	
}
