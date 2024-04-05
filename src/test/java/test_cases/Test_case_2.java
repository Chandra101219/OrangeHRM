package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Home_page;
import page_objects.Login_page;
import page_objects.PIM_page;
import test_bases.Base_class;

public class Test_case_2 extends Base_class {
	
	@Test
	public void addingEmployee() {
		
		//Login to application
		
		Login_page lp = new Login_page(driver);
		
		lp.enterUserName("Admin");
		lp.enterPassword("admin123");
		lp.clickOnLogin();
		
		//adding Employee
		
		Home_page mainpage = new Home_page(driver);		
		
		mainpage.clickOnPIM();
		
		PIM_page p_page = new PIM_page(driver);
		
		p_page.clickOnAddEmployee();
		
		p_page.enterFirstName("Itachi");
		
		p_page.enterLastName("Uchiha");
		
		p_page.clickOnSave();
		
		try {
		
		boolean add_emp = p_page.isPersonaldetailsexists();
		
		Assert.assertEquals(add_emp, true,"Employee added Successfull");
		
		System.out.println("Employee added successfully");
	
		}
		catch(Exception e){
			Assert.fail();
		}
		
	}

}
