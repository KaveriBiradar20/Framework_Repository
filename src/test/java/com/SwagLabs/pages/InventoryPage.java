package com.SwagLabs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage 
{
       private WebDriver driver;
       
       public InventoryPage(WebDriver driver)
       {
    	   this.driver=driver;
       }
       
       //locators
       
        private By plist=By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']");
        private  By pnList=By.xpath("//div[@class='inventory_item_name ']");
        private By addbtn=By.xpath("//button[text()='Add to cart']");
        
        //Methods
        
        public int getproductcount()
        {
        	int count=driver.findElements(plist).size();
        	return count;
        }
        
        public void getproductname()
        {
        	List<WebElement> list=driver.findElements(pnList);
        	System.out.println("Product names are");
        	for(WebElement i:list)
        	{
        		System.out.println(i.getText());
        		
        	}
        }
        public void addTocart(String pname)
        {
        	List<WebElement> allProduct=driver.findElements(pnList);
        	for(WebElement i:allProduct)
        	{
        		if(i.getText().contains(pname))
        		{
        			i.click();
        			break;
        		}
        	}
        	
        	//adding product to cart
        	driver.findElement(addbtn).click();
        	System.out.println("product added to cart "+ pname);
        }
        
}