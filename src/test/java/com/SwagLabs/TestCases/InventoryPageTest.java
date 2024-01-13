package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass
{
	/*
	@BeforeClass
	public void pageSetup()
	{
		lp.doLogin("standard_user", "secret_sauce");
	}
	*/
  @Test(priority=1)
  public void verifyproductCount ()
  {
	 int count=ip.getproductcount(); 
	 Assert.assertEquals(count,6, "Product count not match");
	 System.out.println("Product count is not match");
	 System.out.println("total Product are "+count);
  }
  
	
  @Test(priority=1)
  public void verifyproductname ()
  {
	  ip.getproductname();
  }
  
	
  @Test(priority=1)
  public void verifyAddtocart()
  {
	  ip.addTocart("Sauce Labs Fleece Jacket");
  }
}
