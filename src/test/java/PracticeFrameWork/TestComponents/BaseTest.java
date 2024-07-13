package PracticeFrameWork.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Puja.pageobjects.LandingPage; 
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
	
	public WebDriver  driver ;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver(); 
	 /*   Properties  pro = new Properties();
	FileInputStream f = 
    new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\PracticeFrameWork\\src\\main\\java\\Resources\\Globaldata.properties");
				//stem.getProperty("user.dir")+"src\\main\\java\\Resources//obaldata.properties");
	
	 int i=f.read();  
     System.out.print((char)i);    

		//pro.load(f);
	//	System.out .println("The driver is " +f);
	    
		
	String browserName = pro.getProperty("browser");
	
	System.out .println("The driver3 is " +browserName);
    
	if(browserName.equalsIgnoreCase("ChromeDriver"))		
		{ 
		    	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out .println("The driver2 is " +driver);
		}
		
		else if(browserName.equalsIgnoreCase( "firefox"))
				{
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
				}
		

		else if(browserName.equalsIgnoreCase("edge"))
				{
			WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
				}*/

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	

 public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		String p = FileUtils.readFileToString(new File(
				// System.getProperty("user.dir") +"\\src\\test\\java\\PracticeFrameWork\\Data\\PurchaseOrder1.json" ),
			filepath),	StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String, String>> data = mapper.readValue(p, new TypeReference<List<HashMap<String, String>>>() {
	      });
		  return data;
	}

 
 
 

	
	public String getScreenshots(String TestCaseName , WebDriver driver) throws IOException
	{
		TakesScreenshot s = (TakesScreenshot)driver;
		File source = s.getScreenshotAs(OutputType.FILE) ;
		File Des = new File(System.getProperty("user.dir" + "//reports//" +TestCaseName+ ".png"));
		FileUtils.copyFile(source,Des);
		return (System.getProperty("user.dir" + "//reports//" +TestCaseName+ ".png"));
	}
	

	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{ 
	    driver = initializeDriver();
	   		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void teardown() 
	{
	driver.close();
	} 
}
	

