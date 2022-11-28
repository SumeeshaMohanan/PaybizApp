package com.obsqura.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class SearchClient {
	public WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();
	@FindBy(xpath = "//*[@id=\"clientsearch-client_name\"]")
	WebElement txtclientname;
	@FindBy(xpath = "//*[@id=\"clientsearch-id\"]")
	WebElement txtclientno;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[1]/form/div[3]/button[1]")
	WebElement btnsearch;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[3]/button[2]")
	WebElement btnreset;

	public SearchClient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterSearchName(String clientname) {
		txtclientname.sendKeys(clientname);

	}

	public void enterSearchNo(String clientno) {
		txtclientno.sendKeys(clientno);

	}

	public void enterSearchNameno(String clientname, String clientno) {
		txtclientname.sendKeys(clientname);
		txtclientno.sendKeys(clientno);

	}

	public void searchbuttonclick() {
		btnsearch.click();
	}

	public void resetclick() {
		btnreset.click();

	}

	public void searchByname(String clientname) {
		this.enterSearchName(clientname);
		
		this.searchbuttonclick();
		waitUtility.hardSleep();
		
		
		
	}

	public void searchByno(String clientno) {
		this.enterSearchNo(clientno);
		this.searchbuttonclick();
		waitUtility.hardSleep();
		
	}
	

	public void searchBynamenumber(String clientname, String clientno) {
		this.enterSearchName(clientname);
		this.enterSearchNo(clientno);
		this.searchbuttonclick();
		waitUtility.hardSleep();
		
	}
	
	public void resetByName(String clientname) {
		this.enterSearchName(clientname);
		this.resetclick();
	}
	public void resetByNo(String clientno) {
		this.enterSearchNo(clientno);
		this.resetclick();
	}
}
