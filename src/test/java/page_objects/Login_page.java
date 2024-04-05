package page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page extends BasePOM{

	public Login_page(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements in Homepage
	
	@FindBy(xpath="//input[@name=\"username\"]")           //user_name
	WebElement user_name;
	
	@FindBy(xpath="//input[@name=\"password\"]")           //password
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")           //login_button
	WebElement login;
	
	
	//Actions to be performed
	public void enterUserName(String username) {
		user_name.sendKeys(username);
	}
	
	public void enterPassword(String passwd) {
		password.sendKeys(passwd);
	}
	
	
	public void clickOnLogin() {
		
		login.click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", login);
	}
  
}
