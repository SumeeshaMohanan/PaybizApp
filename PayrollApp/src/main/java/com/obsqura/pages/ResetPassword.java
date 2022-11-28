package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class ResetPassword {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	@FindBy(xpath = "/html/body/section/div/div/div[3]/h1")
	WebElement resetpassword;
	@FindBy(xpath = "//*[@id=\"passwordresetrequestform-email\"]")
	WebElement resetEmail;
	@FindBy(xpath = "//*[@id=\"request-password-reset-form\"]/div[2]/a")
	WebElement resetcancel;
	@FindBy(xpath = "/html/body/section/div/div/div[3]/h1")
	WebElement loginHead;
	@FindBy(xpath = "//*[@id=\"request-password-reset-form\"]/div[1]/p")
	WebElement invalidEmail;
	@FindBy(xpath = "/html/body/section/div/div/div[1]/a/img")
	WebElement resetlogo;
	@FindBy(xpath = "//*[@id=\"request-password-reset-form\"]/div[2]/button")
	WebElement resetsend;
	public ResetPassword(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String resetMessage() {
		waitUtility.waitforanelement(resetpassword, driver);
		String msg=resetpassword.getText();
		return msg;
	}
	public void enterEmail(String resetemail) {
		resetEmail.clear();
	resetEmail.sendKeys(resetemail);
		
	}
	public void cancelbtn() {
		resetcancel.click();
	}
	public void sendbtn() {
		resetsend.click();
	}
	public boolean verifylogo() {
		
		boolean imagePresent = resetlogo.isDisplayed();
		return imagePresent;
	}
	public String backToLogin() {
		waitUtility.waitforanelement(loginHead, driver);
		String msg=loginHead.getText();
		return msg;
	}
	public String invalidMsg() {
		
		waitUtility.waitforanelement(loginHead, driver);
	
		String msg=invalidEmail.getText();
		return msg;
	}
}
