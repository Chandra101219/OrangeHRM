package test_cases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import page_objects.Admin_page;
import page_objects.Home_page;
import page_objects.Login_page;
import test_bases.Base_class;

public class Test_case_3 extends Base_class {
  
	
	@Test
  public void Add_user() throws InterruptedException {
		
		Login_page lp = new Login_page(driver);
		
		lp.enterUserName("Admin");
		lp.enterPassword("admin123");
		lp.clickOnLogin();
		
		Home_page mainpage = new Home_page(driver);
		
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
}
