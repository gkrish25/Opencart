package testCases;

import java.util.Properties;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import pageObjects.SearchResult;

public class TC004_Verify_Search_Functionality extends BaseClass {
	

	public Loggers loggers;
	
	@Test(groups= {"master"})
	
	public void verifysearchbyproduct()
	{
		try {
			
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
		}
		catch (Exception e) {

			Assert.fail(null);
		}
	}
	

}
