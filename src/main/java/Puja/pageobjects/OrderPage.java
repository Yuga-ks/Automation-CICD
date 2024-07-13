package Puja.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponet.AbstractCommon;

public class OrderPage  extends AbstractCommon
	{

	    WebDriver driver;
		
	 public OrderPage(WebDriver driver)
	 { 
		 super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	 }
	      
	//tr/td[2]

@FindBy(xpath = "//tr/td[2]")
List <WebElement> productNames ;

//river.findElement(By.cssSelector(".totalRow button")).click()


@FindBy(css = ".totalRow button")
WebElement button ;

public Boolean VerifyOrderDisplay(String productName)
{
	Boolean Match = productNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	return Match;
	
}

 

}
/*

List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
 Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".totalRow button")).click();*/
