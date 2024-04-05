package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIM_page extends BasePOM{

	public PIM_page(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	
	@FindBy(linkText = "Add Employee")
	WebElement add;
	
	@FindBy(xpath = "//input[@name=\"firstName\"]")
	WebElement f_name;
	
	@FindBy(xpath = "//input[@name=\"lastName\"]")
	WebElement l_name;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement save; 
	
	@FindBy(xpath = "//h6[text()=\"Personal Details\"]")
	WebElement pd; 
	
	
	//Employee Search
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
	WebElement emp_search;
		
	@FindBy(xpath="//button[normalize-space()=\"Search\"]")
	WebElement search;
	
	
	@FindBy(xpath="//div[@role=\"row\"]")
	WebElement rows;
	
	@FindBy(xpath="//div[@role=\"row\"]//div[@role=\"columnheader\"]")
	WebElement columns;
	
	
	
	
	
	
	
	
	//Actions
	
	public void clickOnAddEmployee() {
		add.click();
	}
	public void enterFirstName(String fi_name) {
		f_name.sendKeys(fi_name);
	}
	public void enterLastName(String la_name) {
		l_name.sendKeys(la_name);
	}
	public void clickOnSave() {
		save.click();                    
	}
	
	
	
	public boolean isPersonaldetailsexists()
	{
		try {
			return (pd.isDisplayed());
		} 
		catch (Exception e) {
			return (false);
		}
	}
	
//	public void noofRows() {
//		rows.size();
//	}
}
