package page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends BasePOM{

	public Home_page(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//h6[text()='Dashboard']")             //Dashboard text
	WebElement dashboard;
	
	@FindBy(xpath="//span[text()=\"Admin\"]")            //Admin module
	WebElement admin;
	
	@FindBy(xpath="//span[text()=\"PIM\"]")            //Admin module
	WebElement pim;
	
	@FindBy(xpath="//span[@class=\"oxd-userdropdown-tab\"]")
	WebElement usr_profile;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	
	
	//Actions
	
	public boolean isDashboardtextexists()
	{
		try {
			return (dashboard.isDisplayed());
		} 
		catch (Exception e) {
			return (false);
		}
	}
	
	public void clickOnAdmin() {
		//admin.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", admin);
	}
	public void clickOnPIM() {
		pim.click();
	}
	
	public void clickOnUserProfile() {
		usr_profile.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
}
