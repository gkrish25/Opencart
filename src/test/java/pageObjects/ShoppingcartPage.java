package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingcartPage extends Basepage {
	
	WebDriver driver;
	
	public ShoppingcartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[text()='Shopping Cart']")
	WebElement txtheadingscart;
	
	@FindBy(xpath="//div[@class='input-group btn-block']//input")
	WebElement txtboxQuantity;
	
	@FindBy(xpath="//a[contains(text(),'Estimate Shipping & Taxes ')]")
	WebElement lnkshiping;
	
	@FindBy(xpath="//select[@name='country_id']")
	WebElement drpdownCountry;
	
	@FindBy(xpath="//select[@id='input-zone']")
	WebElement drpdownRegion;
	
	@FindBy(xpath="//select[@id='input-zone']//option")
	List<WebElement> drpdownRegionoptions;
	
	@FindBy(xpath="//input[@name='postcode']")
	WebElement txtPostalcode;
	
	@FindBy(xpath="//button[@id='button-quote']")
	WebElement btnGetquote;
	
	@FindBy(xpath="//input[@id='button-shipping']")
	WebElement btnApplyShiping;
	
	@FindBy(xpath="//input[@name='shipping_method']")
	WebElement rbFlatrate;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSubmit;
	
	public boolean pageHeadingShopingcart() {
		return txtheadingscart.isDisplayed();
	}
	
	public void enterQuantityvalue() {
		txtboxQuantity.clear();
		txtboxQuantity.sendKeys("1");
	}
	
	public void clicksubmit() {
		btnSubmit.click();
	}
	
	public void clickEstimateshippingandtaxeslink() {
		lnkshiping.click();
	}
	
	public void selectCountry() {
		WebElement sc = drpdownCountry;
		Select sc1 = new Select(sc);
		sc1.selectByVisibleText("India");
	}
	
	/*public void selectRegion() {
		drpdownRegion.click();
		List <WebElement> regionOptions = drpdownRegionoptions;
		for(int i=0;i<=regionOptions.size();i++)
		{
			String RegionName = regionOptions.get(i).getText();
			if(RegionName.equals("Tamil Nadu"))
			{
				regionOptions.get(i).click();
			}
		}
	}*/
	
	public void selectRegion() {
		WebElement sr = drpdownRegion;
		Select sr1= new Select(sr);
		sr1.selectByVisibleText("Tamil Nadu");
	}
	
	public void EnterPostalcode() {
		txtPostalcode.sendKeys("638002");
	}
	
	public void ClickGetQuotes() {
		btnGetquote.click();
	}
	public void Applyshipping(){
		boolean value = btnApplyShiping.isEnabled();
		if(value==false) {
			rbFlatrate.click();
		}
		
	}
	
	public void clickApplyshipping() {
		btnApplyShiping.click();
	}
	
}
