package PracticeFrameWork.Tests;



import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.*;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PracticeFrameWork.TestComponents.BaseTest;
import Puja.pageobjects.CartPage;
import Puja.pageobjects.CheckOutPage;
import Puja.pageobjects.ConfirmMessagPage;
import Puja.pageobjects.LandingPage;
import Puja.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest {
     private static final String Shift = null;





	@Test(groups= {"Errorhandling"})
	public void  loginErrorValidation() throws InterruptedException, IOException  {
	
		String productName = "ZARA COAT 3";
		ProductCatalogue p= landingPage.loginApllication("shetty@gmail.com", "Iamking@000");
	String s=	landingPage.getError();
		//System.out.println(s);
		Assert.assertEquals("Invalid email or password.", landingPage.getError());	
		
     }	
    
     
     
     
     
		@Test(groups= {"Errorhandling"})
		public void  ProductErrorValidation() throws InterruptedException, IOException  {
			{
			String productName = "ZARA COAT 3";
			ProductCatalogue p= landingPage.loginApllication("shova@gmail.com", "Mylovelife@123");
			List<WebElement>products = p.getProductList();
			p.addProductToCart(productName);
			CartPage c = p.goToCartPage();
		   boolean match =	c.VerifyProductDisplay( "ZARA COAT 3");
		    Assert.assertTrue(match);
					
	     } 
		
			//Keys.chord((Keys.SHIFT + Keys.CONTROL + Keys.alt)).perform();
				
}
}