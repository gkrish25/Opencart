package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Testbase.BaseClass;
import pageObjects.Cartpopup;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import pageObjects.SearchResult;
import pageObjects.ShoppingcartPage;

public class TC006_Verify_displayof_viewcartscreen extends BaseClass {
	
	public Logger logger;
	@Test()
	
	public void Verifythecheckoutscreen() throws InterruptedException
	{
		//logger.info("Test Execution Started");
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		Loginpage lp = new Loginpage(driver);
		lp.setEmailId(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();
		
		Myaccountpage myacc = new Myaccountpage(driver);
		myacc.textpresent();
		myacc.SearchProduct(p.getProperty("searchProductName"));
		myacc.clickSearch();
		
		SearchResult sr = new SearchResult(driver);
		sr.SearchPage();
		sr.ClickAddtoCart();
		sr.ConfirmationMessage();
		Thread.sleep(3000);
		sr.Clickcart();
		
		Cartpopup cpp = new Cartpopup(driver);
		cpp.ClickViewcart();
		
		ShoppingcartPage scp = new ShoppingcartPage(driver);
		scp.pageHeadingShopingcart();
		scp.enterQuantityvalue();
		scp.clicksubmit();
		scp.clickEstimateshippingandtaxeslink();
		scp.selectCountry();
		scp.selectRegion();
		scp.EnterPostalcode();
		scp.ClickGetQuotes();
		scp.Applyshipping();
		scp.clickApplyshipping();
	}

}
