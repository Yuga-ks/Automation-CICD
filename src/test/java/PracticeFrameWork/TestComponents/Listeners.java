package PracticeFrameWork.TestComponents;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

import Puja.Resources.ExtentReportNG;


	
	public class Listeners extends BaseTest implements ITestListener{
			ExtentTest test;
			ExtentReports t = ExtentReportNG.getReportObject();
			ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
		@Override
		public void onTestStart(ITestResult result) 
		{
			
			test = t.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
			
		}

		@Override
		public void onTestSuccess(ITestResult result)
		{
			extentTest.get().log(Status.PASS, "Test Passed");
		// test.log(Status.PASS, "Test Passed") ;	
		}

		@Override
		public void onTestFailure(ITestResult result)
		{
			//extentTest.get().fail(result.getThrowable());//
			test.fail(result.getThrowable());
			
		try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				String path = null;
			try {	
				path  = getScreenshots(result.getMethod().getMethodName(),driver);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName()); 
		}

		@Override
		public void onTestSkipped(ITestResult result) 
		{
			
	
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
		{
			
			
		}

		@Override
		public void onStart(ITestContext context) 
		{
			
		}

		@Override
		public void onFinish(ITestContext context)
		{
					t.flush();
		}
	
	}
	
	

