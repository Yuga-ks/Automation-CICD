package Puja.Resources;

//import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	 
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		//will create a path in user direc. with having reports as folder and inside which index.html as file.
		ExtentSparkReporter ext = new ExtentSparkReporter(path);
		ext.config().setReportName("UI Automation");
		ext.config().setDocumentTitle("Test Results");
		
		//ExtentReports 
		//C:\Users\HP\eclipse-workspace\FrameworkDesign\src\test\java\Ecommerce2\FrameworkDesign\StandAlone.java
		//C:\Users\HP\eclipse-workspace\FrameworkDesign\src\test\java\Ecommerce2\FrameworkDesign
	//	ExtentReports t --> declaring it as global
		ExtentReports t = new ExtentReports();
		t.attachReporter(ext);
		t.setSystemInfo("Tester", "PUJA"); 
		return t;
	}
	
	}


