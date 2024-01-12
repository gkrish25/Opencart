package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage
{
	
	public WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(id="input-email")
	WebElement txt_emaiId;
	@FindBy(id="input-password")
	WebElement txt_Password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_submit;
	
	public void setEmailId(String emailid)
	{
		txt_emaiId.sendKeys(emailid);
	}
	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);
	}
	public void clicklogin() {
		btn_submit.click();
	}
	
	

}
