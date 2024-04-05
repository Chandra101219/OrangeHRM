package test_cases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Admin_page;
import page_objects.Home_page;
import page_objects.Login_page;
import page_objects.PIM_page;
import test_bases.Base_class;

public class End_to_End extends Base_class {
  @Test
  public void addingUserforEmployee() {
	  
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
		
		mainpage.clickOnPIM();
		
		PIM_page p_page = new PIM_page(driver);
		
		p_page.clickOnAddEmployee();
		
		p_page.enterFirstName("Itachi");
		
		p_page.enterLastName("Uchiha");
		
		p_page.clickOnSave();
		
		
		boolean add_emp = p_page.isPersonaldetailsexists();
		
		Assert.assertEquals(add_emp, true,"Employee added Successfull");
		
		System.out.println("Employee added successfully");
		
		
		
		mainpage.clickOnAdmin();
		
		Admin_page admn_pg = new Admin_page(driver);
		
		admn_pg.clickOnAddUser();
		
		admn_pg.selectUserRole();
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		admn_pg.selectEmpName("Itachi Uchiha");
		Thread.sleep(3000);
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		admn_pg.selectStatus();
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		admn_pg.enterUserName("chandra_Admin2");
		admn_pg.enterPassword("admin123");
		admn_pg.confirmPassword("admin123");
		
		Thread.sleep(5000);
		admn_pg.clickOnSave();
		
		
		mainpage.clickOnUserProfile();
		mainpage.clickOnLogout();
		
		//Login back with new credentials
		
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("passwd"));
		lp.clickOnLogin();
		
		Thread.sleep(5000);
	
		}
		catch(Exception e){
			Assert.fail();
		}
  }
}
