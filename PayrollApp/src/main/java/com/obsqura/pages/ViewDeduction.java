package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class ViewDeduction {
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath = "//*[@id=\"w0\"]/tbody/tr[1]/td")
	WebElement tblvalue;
	public ViewDeduction (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String deductionviewcheckMsg() {
		waitUtility.waitforanelement( tblvalue, driver);
		String workername = tblvalue.getText();

		return workername;
	}
}
