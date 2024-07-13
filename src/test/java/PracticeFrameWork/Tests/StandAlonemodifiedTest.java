package PracticeFrameWork.Tests;




import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Puja.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//import rahulshettyacademy.pageobjects.LandingPage;

public class StandAlonemodifiedTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
			
		/*	for(int i =0 ; i<products.size(); i++)
			{
				String name = products.get(i).getText();
				if(name.contains(productName))
			 driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				
			}*/
				
			
	WebElement prod =	
			products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		Thread.sleep(4000);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
	Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
Thread.sleep(30);
	List<WebElement> l =  driver.findElements
			(By.cssSelector(".ta-item"));
	for( WebElement i : l ) //.ta-item 
	{
		if(i.getText().equalsIgnoreCase("india"))
			i.click();
		break;
	}
	//Actions a = new Actions (driver);
	//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	//a.selectByVisibleText("india");//.click();//.build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	System.out.println("THANKYOU FOR THE ORDER");
	driver.quit();
	
	}
}
