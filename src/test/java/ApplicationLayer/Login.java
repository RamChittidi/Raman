package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='txtuId']")
	WebElement txt_username;
	@FindBy(xpath="//input[@id='txtPword']")
	WebElement txt_password;
	@FindBy(name="login")
	WebElement loginbtn;
	public void enterUserName(String Username)
	{
         txt_username.sendKeys(Username);
	}
	public void enterPassword(String Password)
	{
		txt_password.sendKeys(Password);
	}
	public void clickEnterbtn() 
	{
		loginbtn.click();
	}

}
