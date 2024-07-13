package Puja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponet.AbstractCommon;

public class LandingPage extends AbstractCommon
{
	
    WebDriver driver;
	
 public LandingPage(WebDriver driver)
 {  
	 super(driver);
	this.driver= driver;
	PageFactory.initElements(driver,this);
 }
	
/*driver.get("https://rahulshettyacademy.com/client");
	
	driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
	driver.findElement(By.id("login")).click();
	*/
  public void goTo()
  {
	  driver.get("https://rahulshettyacademy.com/client");
  }

	@FindBy(id="userEmail")
	WebElement userEmail ;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement submit ;
	
	@FindBy(id="toast-container")
	WebElement ErrorMessage ;
	//id='toast-container'
	
	
	public String getError() throws InterruptedException
	{
		Thread.sleep(3000);
		return ErrorMessage.getText();
	}
	
	// Actions methods for the WebElements 
	public ProductCatalogue loginApllication(String name , String password)
	{
		userEmail.sendKeys(name);
		Password.sendKeys(password);
		submit.click();
		ProductCatalogue p = new ProductCatalogue(driver);
		return p ;
	}
	
}
