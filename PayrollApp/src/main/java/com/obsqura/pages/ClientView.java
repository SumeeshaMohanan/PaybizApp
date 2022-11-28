package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class ClientView {
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath = "//*[@id=\"w0\"]/tbody/tr[3]/td")
	WebElement clientname;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[1]/td[2]")
	WebElement searchname;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr/td[1]")
	WebElement searchno;
	@FindBy(xpath = "//*[@id=\"clientsearch-client_name\"]")
	WebElement txtsearchname;
	@FindBy(xpath = "//*[@id=\"clientsearch-id\"]")
	WebElement txtsearchno;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr/td")
	WebElement resultnotfound;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[2]/div/div")
	WebElement validationmsg;
	public ClientView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String clientviewcheckMsg() {

		waitUtility.setImplicitWait(5, driver);
		String name = clientname.getText();
		return name;
	}

	public String checksearchName() {

		String name = searchname.getText();

		return name;
	}

	public String checksearchNo() {

		String number = searchno.getText();
		return number;
	}

	public String checksearchNoName() {
		waitUtility.setImplicitWait(10, driver);
		String number = searchno.getText();
		return number;
	}

	public String resetmsg() {
		String name = txtsearchname.getText();
		return name;
	}
	public String resetmsgbyno() {
		String name = txtsearchno.getText();
		return name;
	}
	public String resultnotfoundmsg() {
		String name = resultnotfound.getText();
		return name;
	}
	public String validationerror() {
		waitUtility.waitforanelement( validationmsg,driver);
		String name = validationmsg.getText();
		return name;
	}
}
