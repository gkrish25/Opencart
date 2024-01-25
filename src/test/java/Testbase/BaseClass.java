package Testbase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups = {"regression","Sanity","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException , FileNotFoundException
	{		
		logger = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
			 capabilities.setPlatform(Platform.MAC);	
			}
			else
			{
				System.out.println("No matching platform");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge" : capabilities.setBrowserName("edge");break;
			default : System.out.println("No matching browser");return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver();break;
		default: System.out.println("No Browser matching"); return;
		}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups = {"regression","Sanity","master"})
	public void Closebrw() 
	{
	//driver.quit();	
	}

	public String randomString() {
		String generatedAplabets = RandomStringUtils.randomAlphabetic(6);
		return generatedAplabets;
	}
	public String randomnumber() {
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}
	public String alphanumeric() {
		String genalpha = RandomStringUtils.randomAlphabetic(4);
		String gennum = RandomStringUtils.randomNumeric(3);
		return (genalpha+"@"+gennum);
	}

	public String captureScreen(String name) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot takescreen = (TakesScreenshot) driver;
		File source = takescreen.getScreenshotAs(OutputType.FILE);
		
		String target = System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+timestamp+".png";
		File targetfile = new File(target);
		source.renameTo(targetfile);
		return target;
		
		
		
	}
}
