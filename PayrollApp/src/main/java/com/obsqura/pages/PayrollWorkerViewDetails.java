package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class PayrollWorkerViewDetails {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath = "//*[@id=\"w0\"]/tbody/tr[6]/td")
	WebElement workerFirstname;
	@FindBy(xpath = "//*[@id=\"w0\"]/tbody/tr[8]/td")
	WebElement workerlastname;
	

	public PayrollWorkerViewDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
