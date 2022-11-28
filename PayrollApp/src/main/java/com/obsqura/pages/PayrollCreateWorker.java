package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.WaitUtility;

public class PayrollCreateWorker {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	@FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[1]/select")
	WebElement selectTitle;
	@FindBy(xpath = "//*[@id=\"worker-first_name\"]")
	WebElement txtFirstName;
	@FindBy(xpath = "//*[@id=\"worker-last_name\"]")
	WebElement txtLastName;
	@FindBy(xpath = "//*[@id=\"worker-known\"]")
	WebElement txtKnownName;
	@FindBy(xpath = "//*[@id=\"worker-phone\"]")
	WebElement txtPhone;
	@FindBy(xpath = "//*[@id=\"worker-mobile\"]")
	WebElement txtMobile;
	@FindBy(xpath = "//*[@id=\"worker-email\"]")
	WebElement txtEmail;
	@FindBy(xpath = "//*[@id=\"worker-gender\"]")
	WebElement selectGender;
	@FindBy(xpath = "//*[@id=\"worker-middle_name\"]")
	WebElement txtMiddleName;
	@FindBy(id= "worker-dob")
	WebElement selectDOB;
	@FindBy(xpath = "//*[@id=\"worker-address1\"]")
	WebElement txtAddress1;
	@FindBy(xpath = "//*[@id=\"worker-address2\"]")
	WebElement txtAddress2;
	@FindBy(xpath = "//*[@id=\"worker-address3\"]")
	WebElement txtAddress3;
	@FindBy(xpath = "//*[@id=\"worker-postcode\"]")
	WebElement txtPostCode;
	@FindBy(xpath = "//*[@id=\"worker-branch_id\"]")
	WebElement selectBranch;
	@FindBy(xpath = "//*[@id=\"worker-division_id\"]")
	WebElement selectDivision;
	@FindBy(xpath = "//*[@id=\"worker-employment_type\"]")
	WebElement selectEmpType;
	@FindBy(xpath = "//*[@id=\"worker-payslip_method\"]")
	WebElement selectPayslipMode;
	@FindBy(xpath = "//*[@id=\"worker-engage_status\"]")
	WebElement selectEngStatus;
	@FindBy(xpath = "//*[@id=\"worker-ni_number\"]")
	WebElement txtNINumber;
	@FindBy(xpath = "//*[@id=\"worker-country\"]")
	WebElement selectCountry;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[4]/div/button")
	WebElement nxtButton;

	public PayrollCreateWorker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterPersonDetails(String title, String firstName, String lastname, String knownname, String phone,
			String mobile, String email, String middlename, String gender) {
	
		Select select = new Select(selectTitle);
		select.selectByVisibleText(title);
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastname);
		txtKnownName.sendKeys(knownname);
		txtPhone.sendKeys(phone);
		txtMobile.sendKeys(mobile);
		txtEmail.sendKeys(email);
		txtMiddleName.sendKeys(middlename);
		Select selectge = new Select(selectGender);
		selectge.selectByVisibleText(gender);

	}

	public void enterDate(String date) {
		selectDOB.click();
		selectDOB.sendKeys(date);
		
		
		//((JavascriptExecutor)driver).executeScript(selectDOB.sendKeys(date));
		
	}

	public void enterAddressDetails(String address1, String address2, String address3, String postcode) {
		txtAddress1.sendKeys(address1);
		txtAddress2.sendKeys(address2);
		txtAddress3.sendKeys(address3);
		txtPostCode.sendKeys(postcode);
	}

	public void enterOtherDetails(String branch, String division, String emptype, String paymode, String status,
			String niNumber) {
		Select selbranch = new Select(selectBranch);
		selbranch.selectByVisibleText(branch);
		Select seldiv = new Select(selectDivision);
		seldiv.selectByVisibleText(division);
		Select selemp = new Select(selectEmpType);
		selemp.selectByVisibleText(emptype);
		Select selpaymode = new Select(selectPayslipMode);
		selpaymode.selectByVisibleText(paymode);
		Select selstatus = new Select(selectEngStatus);
		selstatus.selectByVisibleText(status);
		txtNINumber.sendKeys(niNumber);
		

	}
	public void scroll() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nxtButton);
	}
	public void btnClick() {
		waitUtility.waitforanelement(nxtButton, driver);
		nxtButton.click();
		
	}

	public void createWorker(String title, String firstName, String lastname, String knownname, String phone, String mobile,
			String email, String middlename, String gender, String date, String address1, String address2,
			String address3, String postcode, String branch, String division, String emptype, String paymode,
			String status, String niNumber) {
		
		this.enterPersonDetails(title, firstName, lastname, knownname, phone, mobile, email, middlename, gender);
	this.enterDate(date);
	this.enterAddressDetails(address1, address2, address3, postcode);
	this.enterOtherDetails(branch, division, emptype, paymode, status, niNumber);
	this.scroll();
			this.btnClick();
	}

}
