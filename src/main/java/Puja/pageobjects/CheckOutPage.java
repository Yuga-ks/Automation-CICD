package Puja.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;

import AbstractComponet.AbstractCommon;


	public class CheckOutPage extends AbstractCommon
	{

	    WebDriver driver;
		
	 public  CheckOutPage(WebDriver driver)
	 { 
		 super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	 }
	 
	 
	 @FindBy(css="[placeholder='Select Country']")
	 WebElement country;
	 
	 @FindBy(css=".action__submit")
	 WebElement submit;
	 
	 @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	 WebElement selectCountry;
	 
	 By result = By.cssSelector(".ta-results");
	 
	 
	 public void selectCountry(String CountryName)
	 {
		 Actions a = new Actions (driver);
		 a.sendKeys(country, CountryName).build().perform();
		 waitforElementtoAppear(result);
		 selectCountry.click();
		 
	 }
	
	 
	 public ConfirmMessagPage  SubmitOrder()
	 {
		 submit.click();
		 ConfirmMessagPage  message = new ConfirmMessagPage(driver);
		 return message;
		 
	 }
	 
	 
	 
	      
}

	/*Actions a = new Actions (driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	((ISelect) a).selectByVisibleText("india");//.click();//.build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	System.out.println("THANKYOU FOR THE ORDER");
	driver.quit();*/