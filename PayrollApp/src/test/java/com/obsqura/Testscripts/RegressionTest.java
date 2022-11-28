package com.obsqura.Testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.constants.PayrollConstant;
import com.obsqura.pages.LogOut;
import com.obsqura.pages.PayrollHome;
import com.obsqura.pages.PayrollLogin;
import com.obsqura.utilities.ExcelDataProvider;

public class RegressionTest extends TestHelper {
	String loginFilepath = "\\src\\test\\resources\\com\\obsqura\\testdata\\Logincredentials.xlsx";
	PayrollLogin loginobj;
	PayrollHome payrollhome;
	LogOut logoutobj;
	
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


	@Test(priority = 0, dataProvider = "Logindata", groups = "regression")
	public void verifyValidLogin(String username, String password) throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		payrollhome = loginobj.login(username, password);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = "Welcome to Payroll Application";
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);

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
	@Test(priority = 7)
	public void verifyBlankUsernamePassword() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.loginwithoutuname(" ", "1q2w3e4r");
		String loginActualmsg = loginobj.usernameErrormessage();
		String loginExpectedmsg =PayrollConstant.LOGINBLANKUSER;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Failed", true);
	}
}
