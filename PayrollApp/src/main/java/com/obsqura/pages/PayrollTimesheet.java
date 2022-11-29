package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class PayrollTimesheet {
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	@FindBy(xpath="//button[text()='Generate Playslip']")
	WebElement generatePayslip;
	@FindBy(tagName="h1")
	WebElement heading;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement headingText;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[2]/button")
	WebElement skipToCreatePage;
	public PayrollTimesheet(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickGeneratePayslip() {
		generatePayslip.click();
	}
	public String getHeading() {
		return heading.getText();
	}
	public void clickSkipToCreate() {
		skipToCreatePage.click();
		
	}
	public String timesheetPageTitle() {
		waitUtility.waitforanelement(headingText, driver);
		String title =headingText.getText();
	
		return title;
		
	}
}
