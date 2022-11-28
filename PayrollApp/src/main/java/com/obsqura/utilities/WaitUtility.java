package com.obsqura.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {


	

	public void setImplicitWait(long timeout, WebDriver driver) {
	
		//log.info("Implicit wait has been set to " + timeout);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}

	public void waitforanelement(WebElement element,  WebDriver driver)
			    {
			        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			        wait.until(ExpectedConditions.visibilityOf(element));
		//return status;
			    }
	public void waitforanelementtobeclickable(WebElement element,  WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
//return status;
    }
	public void waitforanelementtobeselected(WebElement element,  WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeSelected(element));
//return status;
    }
	
	public void hardSleep() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
}
