package com.obsqura.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	public void dropdownbyvalue(By element, String value1,WebDriver driver) {
		WebElement dropdown = driver.findElement(element);
		Select objselect = new Select(dropdown);
		objselect.selectByValue(value1);
		}
	public void dropdownbyvisibletext(By element, String value1,WebDriver driver) {
		WebElement dropdown = driver.findElement(element);
		Select objselect = new Select(dropdown);
		objselect.selectByVisibleText(value1);
		}
		public void dropdownbyindex(By element, int value1,WebDriver driver) {
			WebElement dropdown = driver.findElement(element);
		Select objselect = new Select(dropdown);
		objselect.selectByIndex(value1);
		}
		
}
