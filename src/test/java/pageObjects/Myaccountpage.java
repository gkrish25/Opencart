package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage
{

	public WebDriver driver;
	
	public Myaccountpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement heading;
	@FindBy(xpath="//a[text()='Logout'][@class='list-group-item']")
	WebElement lnk_logoff;
	@FindBy(xpath="//input[@name='search']")
	WebElement txtSearchbox;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	public void clicklogoff()
	{
		lnk_logoff.click();
	}
	public boolean textpresent()
	{
		try
		{return(heading.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	public void SearchProduct(String productName) {
		txtSearchbox.sendKeys(productName);
	}
	public void clickSearch() {
		btnSearch.click();
	}
}
