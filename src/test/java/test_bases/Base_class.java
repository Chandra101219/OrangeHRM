package test_bases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base_class {
  
	static public WebDriver driver;
	
	public Logger logger;
	
	public Properties p;
	
	@BeforeClass()
	
	public void app_launch() throws IOException, InterruptedException {
		
		logger = LogManager.getLogger(this.getClass());
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
	}
	
	@AfterClass()
	public void app_close() {
		driver.quit();
	}
	
	/*public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}*/
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

	
}