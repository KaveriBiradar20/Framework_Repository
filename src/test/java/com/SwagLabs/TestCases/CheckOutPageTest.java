package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class CheckOutPageTest extends BaseClass
{
  @Test(priority=1)
  public void doVerifyCancel()
  {
	  ch.doCancel();
	  addWait();
	 cp.doCheckOut();
	  
  }
  
  @Test(priority=2)
  public void doVerifyCheckout()
  {
	  ch.doContinue("kaveri", "Biradar", "410501");
	  
  }
}
