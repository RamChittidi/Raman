package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.cs.A;

public class emp {
	WebDriver driver;
	public emp(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//tbody/tr[2]/td[1]/a[1]/img[1]")
	WebElement clickbranch;
	@FindBy(xpath="//input[@id='BtnNewBR']")
	WebElement clickOnNewBranch;
	@FindBy(name="txtbName")
	WebElement branchName;
	@FindBy(name="txtAdd1")
	WebElement address1;
	@FindBy(name="txtArea")
	WebElement area;
	@FindBy(name="txtZip")
	WebElement zipcode;
	@FindBy(xpath="//select[@id='lst_counrtyU']")
	WebElement selectCounty;
	@FindBy(xpath="//select[@id='lst_stateI']")
	WebElement selectState;
	@FindBy(xpath="//select[@id='lst_cityI']")
	WebElement selectCity;
	@FindBy(xpath="//input[@id='btn_insert']")
	WebElement submitbtn;
	@FindBy(xpath="//img[@src='images/admin_but_03.jpg']")
	WebElement logout;
	public void clickbranch()
	{
		clickbranch.click();
	}
	public void clickOnNewBranch() {
		clickOnNewBranch.click();
	}
	public void enterBranchdetails(String Branchname,String add1,String Area,String Zipcode)
	{
		branchName.sendKeys(Branchname);
		address1.sendKeys(add1);
		area.sendKeys(Area);
		zipcode.sendKeys(Zipcode);
	}
	public void selectcountry(String countryname)
	{
		Select country=new Select(selectCounty);
		country.selectByVisibleText(countryname);
	}
	public void selectstate(String statename)
	{
		Select state=new Select(selectState);
		state.selectByVisibleText(statename);
	}
	public void selectcity(String cityname)
	{
		Select city=new Select(selectCity);
		city.selectByVisibleText(cityname);
	}
	public void submitbtn()
	{
		submitbtn.click();
	}
	public void ClickLogout()
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(logout).click().perform();
	}
	}

