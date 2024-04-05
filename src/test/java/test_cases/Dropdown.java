package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();//user_name
		
		driver.findElement(By.xpath("//span[text()=\"Admin\"]")).click();      //Admin module
		
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")).click();
		
		
		
		//clicking on the dropdown
		driver.findElement(By.xpath("//div[@class=\"oxd-select-text-input\"]")).click();
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("Naruto Uzumaki");
		
		Thread.sleep(3000);
		
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]//div[3]")).click();
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		
		
		/*List<WebElement> options=driver.findElements(By.xpath("//div[@class=\"oxd-select-text oxd-select-text--focus\"]//div[2]//i"));
		
		//find total number of options
		System.out.println("Total number of options:"+options.size());
			
		//print all the options from dropdown
		
		//using normal for loop
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		//select options from dropdown
		for(int i=0;i<options.size();i++)
		{
			String option=options.get(i).getText();
						
			if(option.equals("ESS"))
			{
				options.get(i).click();
			}
			
		}*/
		

	}

}
