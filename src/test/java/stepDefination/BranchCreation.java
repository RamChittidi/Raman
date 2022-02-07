package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import ApplicationLayer.Login;
import ApplicationLayer.emp;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BranchCreation {
	WebDriver driver;
	Login logindetails;
	emp empdetails=new emp(driver);
 
	@Given("^navigate to url$")
	public void navigate_to_url() throws Throwable {
	   driver=new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.get("http://primusbank.qedgetech.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enter username And password$")
	public void user_enter_username_And_password() throws Throwable
	{
		 logindetails=new Login(driver);
         logindetails.enterUserName("Admin");
         logindetails.enterPassword("Admin");
         logindetails.clickEnterbtn();
	}

	@When("^LoginSucess$")
	public void loginsucess() throws Throwable {
	    String expected="adminflow";
	    String actual=driver.getCurrentUrl();
	    if(actual.contains(expected))
	    {
	    	System.out.println("Login Sucess::"+expected+"     "+actual);
	    }else
	    {
	    	System.out.println("Login Fail::"+expected+"     "+actual);
	    }
	}

	@When("^user click on branches$")
	public void user_click_on_branches() throws Throwable {
		empdetails=new emp(driver);
	   empdetails.clickbranch();
	}

	@When("^user click on newBranchCreation$")
	public void user_click_on_newBranchCreation() throws Throwable {
	   empdetails.clickOnNewBranch();
	}

	@When("^user given branchname And address(\\d+) And area And zipcode$")
	public void user_given_branchname_And_address_And_area_And_zipcode(int arg1) throws Throwable {
	    empdetails.enterBranchdetails("Tanuku", "Tanuku", "NarendraCenter", "534330");
	}

	@When("^user click on selectCountry And selectState And selectCity$")
	public void user_click_on_selectCountry_And_selectState_And_selectCity() throws Throwable {
	   empdetails.selectcountry("INDIA");
	   empdetails.selectstate("Andhra Pradesh");
	   empdetails.selectcity("Nellore");
	}

	@When("^user click on Submitbtn$")
	public void user_click_on_Submitbtn() throws Throwable {
	  empdetails.submitbtn();
	}

	@Then("^newBranchCreation Sucessfull$")
	public void newbranchcreation_Sucessfull() throws Throwable {
	   driver.switchTo().alert().getText();
	   driver.switchTo().alert().accept();
	}
	@Then("^user click on logout$")
	public void user_click_on_logout() throws Throwable {
		empdetails.ClickLogout();
		driver.close();
	}


}
