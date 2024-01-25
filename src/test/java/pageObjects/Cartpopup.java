package pageObjects;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartpopup extends Basepage{
	WebDriver driver;
	
public Cartpopup(WebDriver driver)
{
	super(driver);
}
@FindBy(xpath="//strong[contains(text(),'View Cart')]")
WebElement lnkViewCart;

@FindBy(xpath="//strong[contains(text(),'Checkout')]")
WebElement lnkCheckout;

@FindBy(xpath="//button[@title='Remove']")
WebElement btnClosepopup;

@FindBy(xpath="//p[@class='text-center']")
WebElement txtCartEmpty;

public void Clickcheckout()
{
	lnkCheckout.click();
}
public void ClickViewcart() {
	lnkViewCart.click();
}
public void Closepopup() {
	btnClosepopup.click();
}
public boolean CartEmptymessagestatus() {
	return txtCartEmpty.isDisplayed();	
}
public void getmessage() {
	String expmessage=txtCartEmpty.getText();
	String actmessage = "Your shopping cart is empty!";
	if(expmessage.equals(actmessage)) {
		System.out.println("Message is matching");
	}
	if(!(expmessage.equals(actmessage)))
	{
		System.out.println("Message is not matching");
	}
}

}
