package Puja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponet.AbstractCommon;

public class ConfirmMessagPage  extends AbstractCommon
 { 
	WebDriver driver;

  public ConfirmMessagPage(WebDriver driver)
 { 
 super(driver);
this.driver= driver;
PageFactory.initElements(driver,this);
 }
  
  @FindBy(css=".hero-primary")
	WebElement confirmMessage ;
  
  
  public String verifyconfirmMaessage()
  {
	return  confirmMessage.getText();
  
  }
  
  /*
  String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	System.out.println("THANKYOU FOR THE ORDER");
	driver.quit();  */
 }

