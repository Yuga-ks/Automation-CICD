package AbstractComponet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Puja.pageobjects.CartPage;
import Puja.pageobjects.OrderPage;

public class AbstractCommon {
	WebDriver driver ;
	public AbstractCommon(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	 }
	    
	
	
	 @FindBy(css = "[routerlink*='cart']")
	  WebElement cart;
	 
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	 @FindBy(css = "[routerlink*='myorders']")
	  WebElement OrderHeader;
	
	public void waitforElementtoAppear(By FindBy)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
}
	
	public CartPage goToCartPage()
	{
		cart.click();
		CartPage c = new CartPage(driver);
		return c;
		
	}
	
	

	public OrderPage goToOrderPage()
	{
		OrderHeader.click();
		OrderPage d = new OrderPage(driver);
		return d;
		
	}
	
	public void waitForElementToDisappear(WebElement  ele) throws InterruptedException
	{
		
		Thread.sleep(4000);
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.invisibilityOf(ele));
}
}
