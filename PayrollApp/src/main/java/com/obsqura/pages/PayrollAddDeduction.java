package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.WaitUtility;

public class PayrollAddDeduction {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath="deduction-worker_id")
	WebElement selectworker;
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement selectworkername;
	
	
	@FindBy(xpath="//*[@id=\"select2-deduction-worker_id-container\"]/span")
	WebElement loadselectworker;
	@FindBy(xpath = "//*[@id=\"deduction-type\"]")
	WebElement seltype;
	@FindBy(xpath = "//*[@id=\"deduction-amount\"]")
	WebElement txtamount;
	@FindBy(xpath = "//*[@id=\"deduction-effective_from\"]")
	WebElement effectivedate;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div/button")
	WebElement addbtn;
	
	public PayrollAddDeduction(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterDeductionDetails(String worker, String type,String amount, String effdate) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadselectworker.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectworkername.sendKeys(worker);
		selectworkername.sendKeys(Keys.ENTER);
		//Select select = new Select(selectworker);
		//select.selectByVisibleText(worker);
		Select selecttype = new Select(seltype);
		selecttype.selectByVisibleText(type);
		txtamount.sendKeys(amount);
		effectivedate.sendKeys(effdate);
	
	}
	public void btnclick()
	{
		addbtn.click();
	}
	
	public void creatededuction(String worker, String type,String amount, String effdate) {
		this.enterDeductionDetails(worker, type, amount, effdate);
		this.btnclick();
	}
}
