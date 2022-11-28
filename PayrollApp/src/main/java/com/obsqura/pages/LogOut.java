package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	public WebDriver driver;
	@FindBy(xpath = "/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/a")
	WebElement selectname;
	@FindBy(xpath = "/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/ul/div/li[2]/a")
	WebElement logoutbtn;
	public LogOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void payrollLogout() {
		selectname.click();
		logoutbtn.click();
	
	}
}
