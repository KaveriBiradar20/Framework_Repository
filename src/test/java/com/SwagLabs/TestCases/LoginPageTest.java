package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyUrl() 
  {
	  String curl=lp.geturl();
	  Assert.assertTrue(curl.contains("saucedemo"),"Fail:URL is not match");
	  System.out.println("Pass:URL is matching"+ curl);
 }
  @Test(priority=2)
  public void verifyTitle() 
  {
	  String title=lp.getTitle();
	  Assert.assertTrue(title.contains("Swag Labs"),"Fail:Title is not match");
	  System.out.println("Pass:Title is matching"+ title);
 }
  @Test(priority=3)
  public void verifylogin() 
  {
	  String curl=lp.doLogin("standard_user", "secret_sauce");
	  Assert.assertTrue(curl.contains("inventory"),"Fail:Login failed");
	  System.out.println("Pass:Login completed");
 }
}
