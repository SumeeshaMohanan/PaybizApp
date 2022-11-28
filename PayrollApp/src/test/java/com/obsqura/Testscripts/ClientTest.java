package com.obsqura.Testscripts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.pages.PayrollLogin;
import com.obsqura.pages.SearchClient;
import com.obsqura.constants.PayrollConstant;
import com.obsqura.pages.ClientView;
import com.obsqura.pages.PayrollCreateClient;
import com.obsqura.pages.PayrollHome;


public class ClientTest extends TestHelper {
	String timeStamp =new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	PayrollLogin loginobj;
	PayrollCreateClient clientobj;
	PayrollHome payrollhome;
	ClientView clientviewobj;
	SearchClient searchobj;

	@BeforeMethod
	@Parameters({ "browser" })
	public void initialization(String browser) {
		driver = browserLaunch(browser);
	}

	@Test(priority = 1, groups = "regression")
	public void verifyClientCreation() throws InterruptedException, IOException {

		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoaddclient();
		Reporter.log("Navigated to client Page", true);
		clientobj = new PayrollCreateClient(driver);

		clientobj.createClient("Alpha_new", "NewAlpha", "Ray"+timeStamp, "address", "695522", "ref", "9855221100", "8855441100",
				"04555555", "ray@gmail.com", "Ex3455", "Single timesheet", "Electronic", "PDF", "45", "VAT 5.00%");
		clientviewobj = new ClientView(driver);
		String clientactualmsg = clientviewobj.clientviewcheckMsg();
		String clientexpmsg = "Ray"+timeStamp;
		Assert.assertEquals(clientactualmsg, clientexpmsg);
		Reporter.log("client created Succesfully", true);
	}

	@Test(priority = 2)
	public void verifyclientSearchByName() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoclient();
		searchobj = new SearchClient(driver);
		searchobj.searchByname("Diya");

		clientviewobj = new ClientView(driver);

		String clientactualmsg = clientviewobj.checksearchName();
		System.out.println(clientactualmsg);
		String clientexpmsg = "Diya";
		Assert.assertEquals(clientactualmsg, clientexpmsg);
		Reporter.log("Searched Succesfully by name", true);
	}
	
	@Test(priority = 3)
	public void verifyclientSearchByNo() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoclient();
		searchobj = new SearchClient(driver);
		searchobj.searchByno("1292");
		clientviewobj = new ClientView(driver);

		String clientactualmsg = clientviewobj.checksearchNo();
		String clientexpmsg = PayrollConstant.CLIENTNO;
		Assert.assertEquals(clientactualmsg, clientexpmsg);
		Reporter.log("Searched Succesfully by number", true);
	}
	
	@Test(priority = 4)
	public void verifyclientSearchByNameNumber() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoclient();
		searchobj = new SearchClient(driver);
		searchobj.searchBynamenumber("Dennis", "6");
		clientviewobj = new ClientView(driver);

		String clientactualmsg = clientviewobj.checksearchNo();
		String clientexpmsg = "6";
		Assert.assertEquals(clientactualmsg, clientexpmsg);
		Reporter.log("Searched Succesfully by Name & number", true);
	}
	
	@Test(priority = 5)
	public void verifyClientResetwithName() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoclient();
		searchobj = new SearchClient(driver);
		searchobj.resetByName("test Name");
		clientviewobj = new ClientView(driver);
		String resetactualmsg = clientviewobj.resetmsg();
		String resetexpectedmsg = PayrollConstant.CLIENTSEARCHBLANK;
		Assert.assertEquals(resetactualmsg, resetexpectedmsg);
		Reporter.log("Name Reset Succesfully", true);
	}
	
	@Test(priority = 6)
	public void verifyClientResetwithNo() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoclient();
		searchobj = new SearchClient(driver);
		searchobj.resetByNo("123");
		clientviewobj = new ClientView(driver);
		String resetactualmsg = clientviewobj.resetmsgbyno();
		String resetexpectedmsg = PayrollConstant.CLIENTSEARCHBLANK;
		Assert.assertEquals(resetactualmsg, resetexpectedmsg);
		Reporter.log("Client Number Reset Succesfully", true);
	}
	
	@Test(priority = 7)
	public void verifyclientSearchByinvalidNo() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoclient();
		searchobj = new SearchClient(driver);
		searchobj.searchByno("852000");
		clientviewobj = new ClientView(driver);

		String clientactualmsg = clientviewobj.resultnotfoundmsg();
		String clientexpmsg = PayrollConstant.CLIENTNORESULT;
		Assert.assertEquals(clientactualmsg, clientexpmsg);
		Reporter.log("Searched Succesfully by number", true);
	}

	@Test(priority = 8)
	public void validateclientSearchByNo() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoclient();
		searchobj = new SearchClient(driver);
		searchobj.searchByno("85dsdf");
		clientviewobj = new ClientView(driver);

		String clientactualmsg = clientviewobj.validationerror();
		String clientexpmsg = PayrollConstant.CLIENTVALIDATION;
		Assert.assertEquals(clientactualmsg, clientexpmsg);
		Reporter.log("Validation Message Shows Succesfully", true);
	}
}
