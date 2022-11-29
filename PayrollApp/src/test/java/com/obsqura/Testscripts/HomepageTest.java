package com.obsqura.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.constants.PayrollConstant;
import com.obsqura.pages.LogOut;
import com.obsqura.pages.PayrollAddDeduction;
import com.obsqura.pages.PayrollCompany;
import com.obsqura.pages.PayrollHome;
import com.obsqura.pages.PayrollInvoice;
import com.obsqura.pages.PayrollLogin;
import com.obsqura.pages.PayrollTimesheet;
import com.obsqura.pages.ResetPassword;
import com.obsqura.pages.ViewDeduction;
import com.obsqura.utilities.ExcelDataProvider;


public class HomepageTest extends TestHelper {

	String loginFilepath = "\\src\\test\\resources\\com\\obsqura\\testdata\\Logincredentials.xlsx";
	String timeStamp =new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	   PayrollLogin loginobj;
	PayrollHome payrollhome;
	PayrollAddDeduction addDeductionobj;
	ViewDeduction viewdeductobj;
	LogOut logoutobj;
	ResetPassword resetobj;
	PayrollTimesheet timesheetobj;
	PayrollInvoice invoiceobj;
	PayrollCompany companyobj;
	@BeforeMethod
	@Parameters({ "browser" })
	public void initialization(String browser) {
		driver = browserLaunch(browser);
	}

	@DataProvider(name = "Logindata")
	public Object[][] getData() {

		String excelpath = System.getProperty("user.dir");
		ExcelDataProvider exceldp = new ExcelDataProvider();
		Object data[][] = exceldp.testData(excelpath + loginFilepath, "sheet1");
		return data;
	}

	@DataProvider(name = "InvalidLogindata")
	public Object[][] getinvalidData() {

		String excelpath = System.getProperty("user.dir");
		ExcelDataProvider exceldp = new ExcelDataProvider();
		Object data[][] = exceldp.testData(excelpath + loginFilepath, "sheet2");
		return data;
	}

	@Test(priority = 0, dataProvider = "Logindata", groups = "regression")
	public void verifyValidLogin(String username, String password) throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		payrollhome = loginobj.login(username, password);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);

	}

	@Test(priority = 1, groups = "regression")
	public void verifycreateDeduction() throws InterruptedException, IOException {

		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);

		payrollhome.navigatetodeduction();
		addDeductionobj = new PayrollAddDeduction(driver);
		viewdeductobj = new ViewDeduction(driver);
		
		addDeductionobj.creatededuction("Lidiya", "Union Subs", "2500", "15-10-2022");
		String deductionActualValue = PayrollConstant.DEDUCTIONMSG;
		String deductExpect = viewdeductobj.deductionviewcheckMsg();
		Assert.assertEquals(deductionActualValue, deductExpect);
		Reporter.log("Deduction Created Succesfully", true);
	}

	@Test(priority = 2, groups = "regression")
	public void VerifyLogout() throws InterruptedException, IOException {

		PayrollLogin loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		PayrollHome payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		logoutobj = new LogOut(driver);
		logoutobj.payrollLogout();
		String logoutactualmsg = loginobj.logoutcheckmessage();
		String logoutexpshowmsg = PayrollConstant.LOGINHEADING;
		Assert.assertEquals(logoutactualmsg, logoutexpshowmsg);
		Reporter.log("Logout Success", true);
	}

	@Test(priority = 3)
	public void verifyResetLink() throws InterruptedException, IOException {

		loginobj = new PayrollLogin(driver);
		loginobj.resetLinkClick();
		resetobj = new ResetPassword(driver);
		String resetExpectedmsg =  PayrollConstant.RESETHEADING;
		String resetActualmsg = resetobj.resetMessage();
		Assert.assertEquals(resetExpectedmsg, resetActualmsg);
		Reporter.log("Reset Password Link Navigated Successfully", true);

	}

	@Test(priority = 4, dataProvider = "InvalidLogindata")
	public void verifyInvalidLogin(String username, String password) throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		payrollhome = loginobj.login(username, password);
		String loginActualmsg = payrollhome.loginErrorMessage();
		String loginExpectedmsg = PayrollConstant.LOGINVALIDATION;

		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Failed", true);

	}

	@Test(priority = 5)
	public void verifyTimesheetPayslipGeneration() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigateTimesheet();
		timesheetobj = new PayrollTimesheet(driver);
		timesheetobj.clickGeneratePayslip();
		driver.switchTo().alert().accept();
		String expectedHeading = PayrollConstant.TIMESHEETHEADING;
		String actualHeading = timesheetobj.getHeading();
		Assert.assertEquals(actualHeading, expectedHeading);
		Reporter.log("Payslip Generated Succesfully", true);
	}

	@DataProvider(name = "emailDetail")
	public static Object[] loginByDataProvider() {
		return new Object[] { "carolxyzs@gmail.com" };
	}

	@Test(priority = 6, dataProvider = "emailDetail")
	public void verifyResetCancel(String eMail) throws InterruptedException, IOException {
		PayrollLogin loginobj = new PayrollLogin(driver);
		loginobj.resetLinkClick();
		resetobj = new ResetPassword(driver);
		resetobj.enterEmail(eMail);
		resetobj.cancelbtn();
		String expmsg = PayrollConstant.LOGINHEADING;
		String actualmg = resetobj.backToLogin();
		Reporter.log("Reset Password Cancelled Succesfully", true);
	}

	@Test(priority = 7)
	public void verifyBlankUsernamePassword() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.loginwithoutuname(" ", "1q2w3e4r");
		String loginActualmsg = loginobj.usernameErrormessage();
		String loginExpectedmsg =PayrollConstant.LOGINBLANKUSER;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Failed", true);
	}

	@Test(priority = 8)
	public void verifyInvoicePage() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoinvoice();
		invoiceobj = new PayrollInvoice(driver);
		String expectedHeading = PayrollConstant.INVOICEHEADING;
		String actualHeading = invoiceobj.invoicemsg();
		Assert.assertEquals(actualHeading, expectedHeading);
		Reporter.log("Navigated to Invoice Page Successfully", true);
	}
	

	@Test(priority = 9, dataProvider = "emailDetail")
	public void verifyInvalidEmailValidation(String eMail) throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.resetLinkClick();
		resetobj = new ResetPassword(driver);
		resetobj.enterEmail(eMail);
		String expmsg = PayrollConstant.INVALIDEMAIL;
		String actualmg = resetobj.invalidMsg();
		Assert.assertEquals(expmsg, actualmg);
		Reporter.log("Validation SHows Succesfully", true);
	}
	@Test(priority = 10)
	public void verifyDashboardLink() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetodashboard();
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Dashboard Menu Working Successfully", true);

	}
	@Test(priority = 11)
	public void verifyInvoicePageLink() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoinvoice();
		invoiceobj = new PayrollInvoice(driver);
		String expectedHeading = PayrollConstant.INVOICEHEADING;
		String actualHeading = invoiceobj.invoicemsg();
		Assert.assertEquals(actualHeading, expectedHeading);
		Reporter.log("Navigated to Invoice Page Successfully", true);
	}

	@Test(priority = 12)
	public void verifyrestLogo() throws InterruptedException, IOException {

		loginobj = new PayrollLogin(driver);
		loginobj.resetLinkClick();
		resetobj = new ResetPassword(driver);
		boolean logovalue = resetobj.verifylogo();
		assertTrue(logovalue, "Logo Exist");
		Reporter.log("Logo Is present in resetPage", true);
	}

	@Test(priority = 13)
	public void verifyDashboardLogo() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		boolean logovalue = payrollhome.verifylogo();
		assertTrue(logovalue, "Logo Exist");
		Reporter.log("Logo Is present in Home Page", true);

	}
	
}
