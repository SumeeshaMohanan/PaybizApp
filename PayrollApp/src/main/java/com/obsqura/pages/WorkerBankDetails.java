package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WorkerBankDetails {
	public WebDriver driver;
	@FindBy(xpath = "//*[@id=\"worker-payment_method\"]")
	WebElement paymethod;
	@FindBy(xpath = "//*[@id=\"worker-ac_type\"]")
	WebElement accountType;
	@FindBy(xpath = "//*[@id=\"worker-ac_name\"]")
	WebElement accName;
	@FindBy(xpath = "//*[@id=\"worker-ac_no\"]")
	WebElement accNo;
	@FindBy(xpath = "//*[@id=\"worker-sort_code\"]")
	WebElement sortCode;
	@FindBy(xpath = "//*[@id=\"worker-start_date\"]")
	WebElement startingDate1;
	@FindBy(xpath = "//*[@id=\"worker-roll_no\"]")
	WebElement rollNo;
	@FindBy(xpath = "//*[@id=\"worker-bank_name\"]")
	WebElement bankName;
	@FindBy(xpath = "//*[@id=\"worker-bank_address\"]")
	WebElement bankAddress;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[4]/div/button")
	WebElement btnsubmit;
	
	
	public WorkerBankDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterDetails(String paymeth, String acctype, String accname, String accno, String sortcode,
			String startDate1, String roll, String bankname, String bankaddr) {

		
		Select selectpaymode = new Select(paymethod);
		 selectpaymode.selectByVisibleText(paymeth);
		 WebElement element= selectpaymode.getFirstSelectedOption();
		 String paymode=element.getText();
		 if(paymode.equalsIgnoreCase("BACS")) {
			 
			 accountType.sendKeys(acctype);
			 accName.sendKeys(accname);
			 accNo.sendKeys(accno);
			 sortCode.sendKeys(sortcode);
			 startingDate1.sendKeys(startDate1);
			 rollNo.sendKeys(roll);
			 bankName.sendKeys(bankname);
			 bankAddress.sendKeys(bankaddr);
			 btnsubmit.click();
		 }
		 else
		 {
			 startingDate1.sendKeys(startDate1);
			 btnsubmit.click();
		 }
	}
public void bankDetails(String paymeth, String acctype, String accname, String accno, String sortcode,
		String startDate1, String roll, String bankname, String bankaddr) {
	this.enterDetails(paymeth, acctype, accname, accno, sortcode, startDate1, roll, bankname, bankaddr);
}
}
