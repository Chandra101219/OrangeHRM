package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Home_page;
import page_objects.Login_page;
import test_bases.Base_class;

public class Test_case_1 extends Base_class{
  
	@Test
	public void login() {
		
		
		logger.info("******Executing the Test_case_1******");
		logger.debug("Debug of script");
		
		try {
		Login_page lp = new Login_page(driver);
		
		logger.info("Entering username.....");
		lp.enterUserName("Admin");
		
		logger.info("Entering password......");
		lp.enterPassword("admin123");
		
		logger.info("clicking on login.......");
		lp.clickOnLogin();
		
		logger.info("Logged in successfully");
		
		
		logger.info("validating the dashboard title");
		
		Home_page mainpage = new Home_page(driver);		
		boolean dashboard_text = mainpage.isDashboardtextexists();
		
		Assert.assertEquals(dashboard_text, true,"Login Successfull");
		
		logger.info("dashboard title is available");
		
		//System.out.println("Login successfully");
	
		}
		catch(Exception e){
			Assert.fail();
		}
		
		logger.info("******Executed the Test_case_1******");
		
		
		
		
	}
	
}
