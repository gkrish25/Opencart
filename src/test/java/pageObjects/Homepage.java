package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends Basepage{

	 WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//li/a[@title='My Account']") 
	WebElement btn_myaccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement btn_register;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnk_login;
	
	public void clickMyAccount(){
		btn_myaccount.click();
	}
	
	public void clickRegister() {
		btn_register.click();
	}
	public void clickLogin() {
		lnk_login.click();
	}
	
}
