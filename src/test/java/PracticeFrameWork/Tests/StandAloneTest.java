package PracticeFrameWork.Tests;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import java.lang.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PracticeFrameWork.TestComponents.BaseTest;
import Puja.pageobjects.CartPage;
import Puja.pageobjects.CheckOutPage;
import Puja.pageobjects.ConfirmMessagPage;
import Puja.pageobjects.LandingPage;
import Puja.pageobjects.OrderPage;
import Puja.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
//import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
	 @Test(dataProvider="getData", groups={"Purchase"})	
    	public void  submitOrder(HashMap<String,String> input ) throws InterruptedException, IOException  {
	//	LandingPage landingPage = launchApplication();
	//	LandingPage landingPage = new LandingPage(driver);
		//landingPage.goTo();
		// ProductCatalogue p= landingPage.loginApllication(Email, Password);
    	 ProductCatalogue p= landingPage.loginApllication(input.get("email"), input.get("password"));
		 List<WebElement>products = p.getProductList();
	//	p.addProductToCart(productName);
		p.addProductToCart(input.get("product"));
		CartPage c = p.goToCartPage();
		
	  // boolean match =	c.VerifyProductDisplay( productName);
	    boolean match =	c.VerifyProductDisplay(input.get("product"));
	    Assert.assertTrue(match);
	    CheckOutPage t = c.goToCheckoutPage();
		t.selectCountry("india");
		ConfirmMessagPage message = t.SubmitOrder();
		String Message = message.verifyconfirmMaessage();
		Assert.assertTrue(Message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("THANKYOU FOR THE ORDER");
	//	driver.quit();
		
			
     } 

		
			/*driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		     Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		     Assert.assertTrue(match);
			driver.findElement(By.cssSelector(".totalRow button")).click();
		
			Actions a = new Actions (driver);
			
			a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
			((ISelect) a).selectByVisibleText("india");//.click();//.build().perform();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			
			driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
			driver.findElement(By.cssSelector(".action__submit")).click();
			
			String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			System.out.println("THANKYOU FOR THE ORDER");
			driver.quit();
	
	}*/
	
	@Test(dependsOnMethods={"submitOrder"})
	public void OrderHistoryTest()
	{
		//ProductCatalogue p= landingPage.loginApllication("shova@gmail.com", "Mylovelife@123");
	ProductCatalogue p= landingPage.loginApllication("shova@gmail.com", "Mylovelife@123");
	   OrderPage t =	p.goToOrderPage();
	   Assert.assertTrue(t.VerifyOrderDisplay(productName));
		
	}

	
	
	@DataProvider	  
	public Object[][] getData() throws IOException  
	{
		/*HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "anshika@gmail.com");
		map.put("password", "Iamking@000");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "shetty@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product", "ADIDAS ORIGINAL");
		
		
		//return new Object[][] {{ map} , { map1} } ;
		 // String path = (System.getProperty("user.dir") + "\src\test\java\PracticeFrameWork\Data\PurchaseOrder1.json") ;
		//C:\Users\HP\eclipse-workspace\PracticeFrameWork\src\test\java\PracticeFrameWork\Data
		//		  C:\Users\HP\eclipse-workspace\PracticeFrameWork\src\test\java\PracticeFrameWork\Data\PurchaseOrder1.json
	//	return new Object[][] {{"shova@gmail.com","Mylovelife@123","ZARA COAT 3"},
		//	{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"} };*/

		
		List<HashMap<String,String>> data =	getJsonDataToMap(System.getProperty("user.dir") +"\\src\\test\\java\\PracticeFrameWork\\Data\\PurchaseOrder1.json" );
		return new Object[][] {{ data.get(0)} , { data.get(1)} } ;
	}

	
	
	
	
}

