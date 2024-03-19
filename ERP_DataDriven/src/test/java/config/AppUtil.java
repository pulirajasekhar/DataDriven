package config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static Properties conpro;
	public static WebDriver driver;
	
@BeforeTest 
public static void setUp() throws Throwable
{
	conpro = new Properties();
	conpro .load(new FileInputStream("./PropertyFile/Login.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
	}

    else
	{
	Reporter.log("Browser value is Not Matching",true);	
	}
}
	
@AfterTest
public static void tearDown()
{
	driver.quit();
	}
}


