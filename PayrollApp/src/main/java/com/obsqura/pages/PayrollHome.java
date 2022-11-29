package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class PayrollHome {
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath = "/html/body/section/div/div/div/p[1]")
	WebElement welcomemsg;
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/p")
	WebElement loginErrormsg;
	@FindBy(xpath = "/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[4]/a")
	WebElement workerlink;
	@FindBy(xpath = "/html/body/section/div/div/div[1]/ul/li[2]/a")
	WebElement createworkerlink;

	@FindBy(xpath = "/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[3]/a")
	WebElement clientlink;
	@FindBy(xpath = "/html/body/section/div/div/div[1]/ul/li[2]/a")
	WebElement createclientlink;

	@FindBy(xpath = "/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[5]/a")
	WebElement deductionlink;
	@FindBy(xpath = "/html/body/section/div/div/div[1]/ul/li[2]/a")
	WebElement adddeductionlink;
	
	@FindBy(xpath = "/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[6]/a")
	WebElement timesheetlink;
	
	
	@FindBy(xpath = "/html/body/section/div/div/div[1]/ul/li[3]/a")
	WebElement createtimesheetlink;
	@FindBy(xpath = "/html/body/section/div/div/div[3]/h1")
	WebElement resetpassword;
	@FindBy(xpath = "/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[8]/a")
	WebElement invoicelink;
	@FindBy(xpath = "/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[1]/a")
	WebElement dashboardlink;
	@FindBy(xpath = "/html/body/header/div[1]/div/div[1]/img")
	WebElement homelogo;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[2]/button")
	WebElement skipToCreatePage;
	@FindBy(xpath="/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[2]/a")
	WebElement companylink;
	public PayrollHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public String welcomeMessage() {
		waitUtility.waitforanelement(welcomemsg, driver);
		String s = welcomemsg.getText();
		return s;
	}

	public String loginErrorMessage() {
		waitUtility.waitforanelement(loginErrormsg, driver);
		String s = loginErrormsg.getText();
		return s;
	}

	public void navigatetoaddWorker() {
		workerlink.click();
		createworkerlink.click();
	}

	public void navigatetoWorker() {
		workerlink.click();
		

	}

	public void navigatetoclient() {

		clientlink.click();

		
	}
	public void navigatetoinvoice() {

		invoicelink.click();

		
	}
	public void navigatetodashboard() {

		dashboardlink.click();

		
	}

	public void navigatetoaddclient() {

		clientlink.click();

		createclientlink.click();
	}

	public void navigatetodeduction() {

		deductionlink.click();

		adddeductionlink.click();
	}
	public void navigateTimesheet() {
		timesheetlink.click();
	}
	public void navigateCreateTimesheet() {
		createtimesheetlink.click();
	}
	
	public String resetMessage() {
		waitUtility.waitforanelement(resetpassword, driver);
		String s = resetpassword.getText();
		return s;
	}
public boolean verifylogo() {
		
		boolean imagePresent = homelogo.isDisplayed();
		return imagePresent;
	}
public String clickSkipToCreate() {
	skipToCreatePage.click();
	String msg = PageUtility.AlertHandling(driver);
	return msg;
}
public void navigateToCompany() {
	companylink.click();
}
}
