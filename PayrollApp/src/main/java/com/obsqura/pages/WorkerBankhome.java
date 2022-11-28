package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class WorkerBankhome {
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath = "/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement welcomemsg;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[1]/td[2]")
	WebElement tblsearchname;

	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[1]/td[5]")
	WebElement tblsearchpost;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[1]/td[7]")
	WebElement tblsearchninumber;

	@FindBy(xpath = "//*[@id=\"workersearch-first_name\"]")
	WebElement txtsearchname;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr/td/div")
	WebElement tblsearchnotfound;
	public WorkerBankhome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String checkWorkerMessage() {
		waitUtility.waitforanelement(welcomemsg, driver);

		String s = welcomemsg.getText();
		return s;
	}

	public String checksearchname() {

		waitUtility.waitforanelement(tblsearchname, driver);
		String search = tblsearchname.getText();
		return search;
	}

	public String checksearchInvalidname() {

		waitUtility.waitforanelement(tblsearchnotfound, driver);
		String search = tblsearchnotfound.getText();
		return search;
	}
	public String checksearchInvalidNINumber() {

		waitUtility.waitforanelement(tblsearchnotfound, driver);
		String search = tblsearchnotfound.getText();
		return search;
	}
	public String checksearchpost() {

		waitUtility.waitforanelement(tblsearchpost, driver);
		String search = tblsearchpost.getText();
		return search;
	}

	public String checksearchninumber() {

		waitUtility.waitforanelement(tblsearchninumber, driver);
		String search = tblsearchninumber.getText();
		return search;
	}

	public String resetsearchnamemsg() {

		String search = txtsearchname.getText();
		return search;
	}
}
