package com.SwagLabs.TestCases;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.SwagLabs.Utility.PropertiesUtil;
import com.SwagLabs.Utility.Utility;
import com.SwagLabs.pages.CartPage;
import com.SwagLabs.pages.CheckoutPage;
import com.SwagLabs.pages.InventoryPage;
import com.SwagLabs.pages.LoginPage;
import com.SwagLabs.pages.OverviewPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	public CheckoutPage ch;
	public OverviewPage op;
	public PropertiesUtil p1;
	
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	
	@BeforeSuite
	public void reports()
	{

		  //Create ExtentReports object
		  extent = new ExtentReports();
		  //Using reporter we can add path
		   spark = new ExtentSparkReporter("Reports/Automation.html"); // automatically Reports folder
		  //is created so we set the path where v get reportes under Reportes folder with the name Automation
		  
		  // Setup any configuration
		  spark.config().setDocumentTitle("Sprint1 report");
		  spark.config().setReportName("Swag Lab Automation Testing Report");
		  spark.config().setTheme(Theme.DARK);
		  
		  //attach report
		  extent.attachReporter(spark);
		  
		  //Create Test-using ExtentTest class
		  test= extent.createTest("Swag Lab End to End report");
		
	}
	
	@BeforeTest //for all pages Browser setup 
	public void setup() throws FileNotFoundException
	{
		p1=new PropertiesUtil();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p1.getData("url"));  //driver.get("https://www.saucedemo.com/");
		test.pass("Swag Lab Application open successfully");
		lp=new LoginPage(driver);
		ip=new InventoryPage(driver);
		cp= new CartPage(driver);
		ch= new CheckoutPage(driver);
		op=new OverviewPage(driver);
	}
	//Page prerequisite
	@BeforeClass
	public void pageSetup()
	{
		Utility.getscreenShot(driver);
		lp.doLogin(p1.getData("un"), p1.getData("psw"));//lp.doLogin("standard_user", "secret_sauce");
		test.pass("Login successful");
		addWait();
		Utility.getscreenShot(driver);
		ip.getproductcount();
		ip.getproductname();
		addWait();
		ip.addTocart(p1.getData("pname1"));//ip.addTocart("Sauce Labs Bolt T-Shirt");
		Utility.getscreenShot(driver);
		addWait();
		cp.getCartPage();
		test.pass("Inventory page validation completed");
		addWait();
		System.out.println("****CartPage Open********");
		cp.doRemove();
		Utility.getscreenShot(driver);
		addWait();
		cp.doContiueShopping();
		ip.addTocart(p1.getData("pname2"));//ip.addTocart("Sauce Labs Backpack");
		Utility.getscreenShot(driver);
		cp.getCartPage();
		addWait();
		cp.doCheckOut();
		test.pass("Cart page validation completed");
		System.out.println("CheckOutPage is open");
		ch.doContinue(p1.getData("fname"),p1.getData("lname"),p1.getData("zc"));
		test.pass("CheckOut page validation completed");
		System.out.println("Overview Page open");
		test.pass("Overview page validation completed");
		
		
	}
	
	public void addWait()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch  block
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void exitReport()
	{
		extent.flush();
	
	}
	
}
