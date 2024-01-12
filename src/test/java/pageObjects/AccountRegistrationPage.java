package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage{
	
	public WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(name="firstname")
	WebElement txt_firstname;
	@FindBy(name="lastname")
	WebElement txt_lastname;
	@FindBy(name="email")
	WebElement txt_email;
	@FindBy(name="telephone")
	WebElement txt_telphone;
	@FindBy(name="password")
	WebElement txt_password;
	@FindBy(name="confirm")
	WebElement txt_confPassword;
	@FindBy(name="agree")
	WebElement cb_privatepolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_submit;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstname(String Fname) {
		txt_firstname.sendKeys(Fname);
	}
	public void setLastname(String Lname) {
		txt_lastname.sendKeys(Lname);
	}
	public void setEmail(String emailval) {
		txt_email.sendKeys(emailval);
	}
	public void setPhonenumber(String num) {
		txt_telphone.sendKeys(num);
	}
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	public void setConfirmPassword(String ConfPassword) {
		txt_confPassword.sendKeys(ConfPassword);
	}
	
	public void clickcheckbox() {
		cb_privatepolicy.click();
	}
	public void clickSubmit() {
		btn_submit.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}

	
}
