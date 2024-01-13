package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

import com.SwagLabs.Utility.Utility;

import org.testng.annotations.Test;

public class OverviewPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifySummary()
  {
	  op.getSummary();
	  Utility.getscreenShot(driver);
  }
  @Test(priority=2)
  public void verifyoverview()
  {
	  op.doFinish();
	  Utility.getscreenShot(driver);
  }
}
