package com.SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	private WebDriver driver;
	
	public  CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators
	private By fname=By.id("first-name");
	private By lname=By.id("last-name");
	private By zipCode=By.name("postalCode");
	private By cancelbtn=By.id("cancel");
	private By contbtn=By.id("continue");
	
	
	
	//Methods
	
	public void doCancel()
	{
		driver.findElement(cancelbtn).click();
		System.out.println("CheckOut process Cancel");
	}
	public void doContinue(String fn,String ln,String zc)
	{
		driver.findElement(fname).sendKeys(fn);
		driver.findElement(lname).sendKeys(ln);
		driver.findElement(zipCode).sendKeys(zc);
		driver.findElement(contbtn).click();
		System.out.println("Overview Page is open");
	}
	
	
	
	
	

}
