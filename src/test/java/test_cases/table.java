package test_cases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class table {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		driver.findElement(By.xpath("//span[text()=\"PIM\"]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("Itachi Uchiha");
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//button[normalize-space()=\"Search\"]")).click();
		
		
		int rows = driver.findElements(By.xpath("//div[@role=\"row\"]")).size();
		
		System.out.println("Number of rows:"+ rows);
		
		int columns = driver.findElements(By.xpath("//div[@role=\"row\"]//div[@role=\"columnheader\"]")).size();
		
		System.out.println("Number of columns:"+ columns);
		
		
		
			List<WebElement> rowdata=driver.findElements(By.xpath("//div[@role=\"cell\"]"));
			
			System.out.println(" row data is : "+rowdata.size());
			
			for(int i=1;i<rowdata.size();i++)
			{
				String column = rowdata.get(i).getText();
				System.out.println(column);
			
				if(column.equals("Itachi"))
				{
					rowdata.get(i).click();
					break;		
				}
			
		}
		
		
		

	}

}
