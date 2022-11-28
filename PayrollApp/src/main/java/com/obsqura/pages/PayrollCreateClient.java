package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.WaitUtility;

public class PayrollCreateClient {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	@FindBy(xpath = "//*[@id=\"client-branch_id\"]")
	WebElement selectBranch;
	@FindBy(xpath = "//*[@id=\"client-division_id\"]")
	WebElement selectDivision;
	@FindBy(xpath = "//*[@id=\"client-client_name\"]")
	WebElement txtclientName;
	@FindBy(xpath = "//*[@id=\"client-client_address\"]")
	WebElement txtclientAddress;
	@FindBy(xpath = "//*[@id=\"client-postcode\"]")
	WebElement txtpostcode;
	@FindBy(xpath = "//*[@id=\"client-your_ref\"]")
	WebElement txtref;
	@FindBy(xpath = "//*[@id=\"client-invoice_contact\"]")
	WebElement invoiceContact;
	@FindBy(xpath = "//*[@id=\"client-phone\"]")
	WebElement clientphone;
	@FindBy(xpath = "//*[@id=\"client-fax\"]")
	WebElement txtfax;
	@FindBy(xpath = "//*[@id=\"client-email\"]")
	WebElement txtemail;
	@FindBy(xpath = "//*[@id=\"client-company_reg\"]")
	WebElement companyReg;
	@FindBy(xpath = "//*[@id=\"client-invoice_order\"]")
	WebElement selinvoiceorder;
	@FindBy(xpath = "//*[@id=\"client-invoice_delivery_method\"]")
	WebElement selinvoicedelivery;
	@FindBy(xpath = "//*[@id=\"client-master_document\"]")
	WebElement selmasterdoc;
	@FindBy(xpath = "//*[@id=\"client-settilement_days\"]")
	WebElement txtsettlement;
	@FindBy(xpath = "//*[@id=\"client-vat_rate\"]")
	WebElement selvatrate;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[4]/div/button")
	WebElement savebtn;

	public PayrollCreateClient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createPerson(String selbranch, String selDivision, String clientName, String clientAddress,
			String postcode) {
		Select select = new Select(selectBranch);
		select.selectByVisibleText("Alpha_new");
		Select selectdiv = new Select(selectDivision);
		selectdiv.selectByVisibleText("NewAlpha");
		txtclientName.sendKeys(clientName);
		txtclientAddress.sendKeys(clientAddress);
		txtpostcode.sendKeys(postcode);

	}

	public void clientOtherDetails(String ref, String clientinvoiceContact, String phone, String fax, String email,
			String companyreg, String selinvoice, String delivery, String masterdoc, String settlement, String vatrate) {

		txtref.sendKeys(ref);
		invoiceContact.sendKeys(clientinvoiceContact);
		clientphone.sendKeys(phone);
		txtfax.sendKeys(fax);
		txtemail.sendKeys(email);
		companyReg.sendKeys(companyreg);
		
		Select selectinvoice = new Select(selinvoiceorder);
		selectinvoice.selectByVisibleText(selinvoice);
		
		Select selectdelivery = new Select(selinvoicedelivery);
		selectdelivery.selectByVisibleText(delivery);
		Select selectmaster = new Select(selmasterdoc);
		selectmaster.selectByVisibleText(masterdoc);
					txtsettlement.sendKeys(settlement);
					Select selectvat = new Select(selvatrate);
					selectvat.selectByVisibleText(vatrate);
		

	}
public void scroll() {
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", savebtn);
}
	public void btnClick() {
		waitUtility.waitforanelementtobeclickable(savebtn, driver);
		savebtn.click();
	}

	public void createClient(String selbranch, String selDivision, String clientName, String clientAddress,
			String postcode, String ref, String clientinvoiceContact, String phone, String fax, String email,
			String companyreg, String selinvoice,String delivery, String masterdoc, String settlement, String vatrate) {

		this.createPerson(selbranch, selDivision, clientName, clientAddress, postcode);
		this.clientOtherDetails(ref, clientinvoiceContact, phone, fax, email, companyreg, selinvoice, delivery,masterdoc,
				settlement, vatrate);
		this.scroll();
		this.btnClick();
	}
}
