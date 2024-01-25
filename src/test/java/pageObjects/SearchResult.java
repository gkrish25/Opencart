package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends Basepage {
	
	WebDriver driver;
	
public SearchResult(WebDriver driver)
{
super(driver);	
}

@FindBy(xpath="//div[@id='content']/h1")
WebElement txtSearchheading;

@FindBy(xpath="//button/span[text()='Add to Cart']")
WebElement btnAddtoCart;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement txtConfirmation;

@FindBy(xpath="//div[@id='cart']")
WebElement btnCart;

public boolean SearchPage() {
	return txtSearchheading.isDisplayed();
}
public boolean ConfirmationMessage()
{
	try {
		return(txtConfirmation.isDisplayed());
	}
	catch (Exception e)
	{
		return (false);
	}
}
public void ClickAddtoCart() {
	btnAddtoCart.click();
}
public void Clickcart() {
	btnCart.click();
}
}
