package Puja.pageobjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponet.AbstractCommon;

public class ProductCatalogue extends AbstractCommon
{

    WebDriver driver;
	
 public ProductCatalogue(WebDriver driver)
 { 
	 super(driver);
	this.driver= driver;
	PageFactory.initElements(driver,this);
 }
            //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
 
  

	@FindBy(css = ".mb-3")
	List<WebElement> products;
    
    // we can n't not use the pagefocatory locators like above products since at run , pf constructor will attach the driver.findElememt ...
    // and waitforElementtoAppear wants By findy type as arguement . Hence , lets assign in new By type variable.
    
    By productsBy = By.cssSelector(".mb-3");
    
    public List<WebElement> getProductList() {
		waitforElementtoAppear(productsBy);
		return products;
	}
	

    //WebElement prod =	
  	//products.stream().filter(product->
  		//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
  		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
  		
    
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    
    public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
    
   // /wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//ng-animating
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); --> This webElemt locators ...that's why we have used
   // pagefacotry for it.
   
    By toastMessage = By.cssSelector("#toast-container");
    
     
    @FindBy(css = ".ng-animating")
	WebElement spinner;
    
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitforElementtoAppear(toastMessage);
		waitForElementToDisappear(spinner);
    
	}
}
