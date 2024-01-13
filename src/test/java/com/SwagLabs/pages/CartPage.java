package com.SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
   private WebDriver driver;
   
   public CartPage(WebDriver driver) //taking from Base class
   {
	   this.driver=driver;
   }
   //Locators
   
  private By cartPage=By.xpath("//a[@class='shopping_cart_link']");
  private By rbtn=By.xpath("//button[text()='Remove']");
  private By cbtn=By.xpath("//button[text()='Continue Shopping']");
  private By checkbtn=By.id("checkout");
  
  //Methods
  
  public void getCartPage()
  {
	  driver.findElement(cartPage).click();
	  System.out.println("Cart Page is open");
  }
  
  public void doRemove()
  {
	  driver.findElement(rbtn);
	  System.out.println("Selected product is removed");
  }
  
  public void doContiueShopping()
  {
	  driver.findElement(cbtn).click();
	  System.out.println("Inventory page open:Select Product");
	 
  }
  
  public String doCheckOut()
  {
	  driver.findElement(checkbtn).click();
	  return driver.getCurrentUrl();  
  }
}
   
                                                     
