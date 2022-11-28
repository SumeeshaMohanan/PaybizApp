package com.obsqura.Testscripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestHelper {
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters({ "browser" })
	public void initialization(String browser) {
		driver = browserLaunch(browser);
	}
	
	public WebDriver browserLaunch(String browser)
	{
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
		
			 WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("start-maximized");
			  driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{

			 WebDriverManager.firefoxdriver().setup();
			 FirefoxOptions options=new FirefoxOptions();
			 options.addArguments("start-maximized");
			 driver = new FirefoxDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			 EdgeOptions options=new EdgeOptions();
			 options.addArguments("start-maximized");
			 driver= new EdgeDriver(options);
			
			
		}
		driver.get("http://qabible.in/payrollapp/site/login");
		return driver;
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult iTestResult) throws IOException { 
	    if (iTestResult.FAILURE == iTestResult.getStatus()) { 
	        takeScreenshot(iTestResult.getName());
	    }
	    driver.close();
	} 
	public String takeScreenshot(String name) throws IOException {
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //current date & time is obtained

	  //Take the screenshot
	    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
	            + ".png"; //location specified., name & date should be appended
	   
	    File finalDestination = new File(destination); 
	     FileUtils.copyFile(source, finalDestination);
	    return destination;   
	   
	}
		

}
