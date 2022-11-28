package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class PayrollLogin {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	@FindBy(xpath = "//*[@id=\"loginform-username\"]")
	WebElement txtusername;
	@FindBy(xpath = "//*[@id=\"loginform-password\"]")
	WebElement txtpassword;
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[5]/button")
	WebElement loginbtn;
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[3]")
	WebElement chkbox;

	@FindBy(xpath = "/html/body/section/div/div/div[3]/h1")
	WebElement loginh1;
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[4]/a")
	WebElement resetlink;
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/p")
	WebElement usernameError;
	public PayrollLogin(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	public String logoutcheckmessage() {
		String msg=loginh1.getText();
		return msg;
	}
	public String usernameErrormessage() {
		waitUtility.waitforanelement(usernameError,driver);
		String msg=usernameError.getText();
		return msg;
	}

	public void enterUsername(String username) {
		txtusername.sendKeys(username);
	}

	public void enterPassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void checkboxClick() {
		chkbox.click();
	}

	public void buttonClick() {
		loginbtn.click();
	}
	public void resetClick() {
		resetlink.click();
	}
	
	public void resetLinkClick() {
		this.resetClick();
	}

	public PayrollHome login(String uname, String pwd) {
		this.enterUsername(uname);
		this.enterPassword(pwd);
		this.checkboxClick();
		this.buttonClick();
		return new PayrollHome(driver);
	}
	public PayrollHome loginwithoutuname(String uname, String pwd) {
		this.enterUsername(uname);
		this.enterPassword(pwd);
	
		return new PayrollHome(driver);
	}
}
