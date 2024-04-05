package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Admin_page extends BasePOM{

	public Admin_page(WebDriver driver) {
		super(driver);
		
	}
  
	//Elements
	
	@FindBy(xpath="//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")
	WebElement add_user;
	
	@FindBy(xpath="//div[@class=\"oxd-select-text-input\"]")
	WebElement usr_role;
	
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
	WebElement emp_name;
	
	@FindBy(xpath="//div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]//div[3]")
	WebElement status;
	
	@FindBy(xpath="//div[@class=\"oxd-form-row\"]//div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@class=\"oxd-input oxd-input--active\"]")
	WebElement usr_name;
	
	@FindBy(xpath="//div[@class=\"oxd-grid-item oxd-grid-item--gutters user-password-cell\"]//input")
	WebElement password;
	
	@FindBy(xpath="//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@type=\"password\"]")
	WebElement conf_passwd;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement save;
	
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]")
	WebElement cancel;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Actions
	
	public void clickOnAddUser() {
		add_user.click();
	}
	
	public void selectUserRole() {
		usr_role.click();
	}
	public void selectEmpName(String name) {
		emp_name.sendKeys(name);
	}
	public void selectStatus() {
		status.click();
	}
	public void enterUserName(String user_name) {
		usr_name.sendKeys(user_name);
	}
	public void enterPassword(String passwd) {
		password.sendKeys(passwd);
	}
	public void confirmPassword(String cnf_passwd) {
		conf_passwd.sendKeys(cnf_passwd);
	}
	public void clickOnSave() {
		save.click();
	}
	
	public void clickOnCancel() {
		cancel.click();
	}
	
	
  }

