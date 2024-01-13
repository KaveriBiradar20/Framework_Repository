package com.SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
	//Encapsulation=data(Private)+Method(Public)
	
	private WebDriver driver;
	
	//Initialize the Driver, It is possible through the constructor
	
	public LoginPage(WebDriver driver)// this driver is coming from base class
	{
		this.driver=driver;
	}
	
	//Locators
	
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginbtn=By.name("login-button");
	
	//Methods=Methods should be public and these methods are actually the functionality of application  
	//Which we are going to test
	
	public String geturl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String doLogin(String un, String psw )
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(loginbtn).click();
	    String curl= driver.getCurrentUrl();
	    return curl;
	}
	 

}
