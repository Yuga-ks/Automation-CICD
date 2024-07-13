package Puja.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponet.AbstractCommon;

public class CartPage  extends AbstractCommon
	{

	    WebDriver driver;
		
	 public CartPage(WebDriver driver)
	 { 
		 super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	 }
	      


@FindBy(css = ".cartSection h3")
List <WebElement> cartProducts ;

//river.findElement(By.cssSelector(".totalRow button")).click()


@FindBy(css = ".totalRow button")
WebElement button ;

public Boolean VerifyProductDisplay(String productName)
{
	Boolean Match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	return Match;
	
}

public CheckOutPage goToCheckoutPage()
{
button.click();
CheckOutPage t = new CheckOutPage(driver);
return t;
}
 

}
/*

List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
 Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".totalRow button")).click();*/
