package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class ViewSearchWorker {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath = "//*[@id=\"workersearch-first_name\"]")
	WebElement txtworkername;
	@FindBy(xpath = "//*[@id=\"workersearch-last_name\"]")
	WebElement txtworkerlastname;
	@FindBy(xpath = "//*[@id=\"workersearch-postcode\"]")
	WebElement txtpostcode;
	@FindBy(xpath = "//*[@id=\"workersearch-ni_number\"]")
	WebElement txtNiNumber;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[5]/button[1]")
	WebElement btnsearch;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[5]/button[2]")
	WebElement btnreset;
	
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[1]/td[8]/a[1]")
	WebElement viewicon;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[10]/td[2]")
	WebElement viewname;

	public ViewSearchWorker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterSearchName(String fname) {
		txtworkername.sendKeys(fname);

	}

	public void enterLastname(String lname) {
		txtworkerlastname.sendKeys(lname);

	}

	public void enterSearchpost(String post) {
		txtpostcode.sendKeys(post);

	}

	public void enterNINumber(String number) {
		txtNiNumber.sendKeys(number);

	}

	public void searchbuttonclick() {
		btnsearch.click();
	}

	public void resetclick() {
		btnreset.click();

	}
	
	public void viewIconClick() {
		viewicon.click();
	}

	public void searchByFname(String fname) {
		this.enterSearchName(fname);
		this.searchbuttonclick();
		waitUtility.hardSleep();
	}

	public void searchBypost(String postno) {
		this.enterSearchpost(postno);
		this.searchbuttonclick();
		waitUtility.hardSleep();
	}

	public void searchByLastname(String lname) {
		this.enterSearchName(lname);
			this.searchbuttonclick();
			waitUtility.hardSleep();
	}
	public void searchByNINumber(String nino) {
		this.enterNINumber(nino);
		this.searchbuttonclick();
		waitUtility.hardSleep();
	}
	public void viewWorker(String nino) {
		this.enterNINumber(nino);
		this.searchbuttonclick();
		waitUtility.hardSleep();
	}
	public void resetwithName(String fname) {
		this.enterSearchName(fname);
		this.resetclick();
	}
	
	public void viewClick() {
		viewname.click();
		viewicon.click();
	}
}
