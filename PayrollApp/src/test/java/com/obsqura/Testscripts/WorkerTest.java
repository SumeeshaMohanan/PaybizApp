package com.obsqura.Testscripts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.constants.PayrollConstant;
import com.obsqura.pages.DeleteWorker;
import com.obsqura.pages.PayrollCreateWorker;
import com.obsqura.pages.PayrollHome;
import com.obsqura.pages.PayrollLogin;
import com.obsqura.pages.ViewSearchWorker;
import com.obsqura.pages.WorkerBankDetails;
import com.obsqura.pages.WorkerBankhome;

@Listeners(ExtentReportUtil.class)
public class WorkerTest extends TestHelper {
	String timeStamp =new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	PayrollLogin loginobj;
	PayrollHome payrollhome;
	PayrollCreateWorker createWorkerObj;
	WorkerBankhome workerhome;
	WorkerBankDetails bankDetails;
	DeleteWorker deleteworkerobj;
	ViewSearchWorker searchobj;

	@BeforeMethod
	@Parameters({ "browser" })
	public void initialization(String browser) {
		driver = browserLaunch(browser);
	}
/*
	@Test(priority = 1, groups = "regression")
	public void verifyWorkerCreation() throws InterruptedException, IOException {

		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoaddWorker();
		Reporter.log("Navigated to Worker Page", true);
		createWorkerObj = new PayrollCreateWorker(driver);
		createWorkerObj.createWorker("Mrs", "Anjusha"+timeStamp, "aa", "Anju", "8", "85", "email", "middlename", "Male",
				"12-10-2000", "address1", "address2", "address3", "689966", "Alpha_new", "NewAlpha", " Paye",
				"Electronic", "Paye", "ZBC456");
		workerhome = new WorkerBankhome(driver);

		String workeractualmsg = workerhome.checkWorkerMessage();
		String workerexpectedmsg = PayrollConstant.WORKERBANKHEADING;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Worker Created Successfully", true);
		//bankDetails = new WorkerBankDetails(driver);
		//bankDetails.bankDetails("Cheque", "Bank", "Anjusha"+timeStamp, "1254", "520520", "12/10/2021", "UK", "SBI", "London");

	}*/

	@Test(priority = 2)
	public void verifyworkerDeletion() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		deleteworkerobj = new DeleteWorker(driver);
		deleteworkerobj.deleteWorkeraction("Liviu Pasculescu");
		Reporter.log("Deleted Succesfully", true);
	}

	@Test(priority = 3)
	public void verifyWorkerSearchByFName() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		searchobj = new ViewSearchWorker(driver);
		searchobj.searchByFname("Jyothi");
		workerhome = new WorkerBankhome(driver);
		String workeractualmsg = workerhome.checksearchname();
		String workerexpectedmsg = PayrollConstant.WORKERSEARCHNAME;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Searched Succesfully by WorkerName ", true);
	}

	@Test(priority = 4)
	public void verifyWorkerSearchBypost() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		searchobj = new ViewSearchWorker(driver);
		searchobj.searchBypost("BN23 5RL");
		workerhome = new WorkerBankhome(driver);
		String workeractualmsg = workerhome.checksearchpost();
		String workerexpectedmsg = PayrollConstant.WORKERSEARCHPOST;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Searched Succesfully by Postcode", true);
	}

	@Test(priority = 5)
	public void verifyWorkerSearchByNINumber() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		searchobj = new ViewSearchWorker(driver);
		searchobj.searchByNINumber("ST004041B");
		workerhome = new WorkerBankhome(driver);
		String workeractualmsg = workerhome.checksearchninumber();
		String workerexpectedmsg = PayrollConstant.WORKERSEARCHNINUMBER;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Searched Succesfully by NI Number", true);
	}

	@Test(priority = 6)
	public void verifyWorkerResetwithName() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		searchobj = new ViewSearchWorker(driver);
		searchobj.resetwithName("TestName");
		workerhome = new WorkerBankhome(driver);
		String workeractualmsg = workerhome.resetsearchnamemsg();
		String workerexpectedmsg = PayrollConstant.WORKERSEARCHBLANK;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Reset Name Textbox Succesfully", true);
	}

	@Test(priority = 7)
	public void verifyWorkerSearchByInvalidFName() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		searchobj = new ViewSearchWorker(driver);
		searchobj.searchByFname("xyzz");
		workerhome = new WorkerBankhome(driver);
		String workeractualmsg = workerhome.checksearchInvalidname();
		String workerexpectedmsg = PayrollConstant.WORKERNORESULT;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Searched Succesfully by WorkerName ", true);
	}

	@Test(priority = 8)
	public void verifyWorkerSearchByInvalidNInumber() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		searchobj = new ViewSearchWorker(driver);
		searchobj.searchByNINumber("ax7525");
		workerhome = new WorkerBankhome(driver);
		String workeractualmsg = workerhome.checksearchInvalidname();
		String workerexpectedmsg = PayrollConstant.WORKERNORESULT;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Searched Succesfully by Worker NINumber ", true);
	}

	@Test(priority = 9)
	public void verifyWorkerSearchByinvalidpostcode() throws InterruptedException, IOException {
		loginobj = new PayrollLogin(driver);
		loginobj.login("carol", "1q2w3e4r");
		payrollhome = new PayrollHome(driver);
		String loginActualmsg = payrollhome.welcomeMessage();
		String loginExpectedmsg = PayrollConstant.HOMEPAGEHEADING;
		Assert.assertEquals(loginActualmsg, loginExpectedmsg);
		Reporter.log("Login Success", true);
		payrollhome.navigatetoWorker();
		searchobj = new ViewSearchWorker(driver);
		searchobj.searchBypost("ax7525");
		workerhome = new WorkerBankhome(driver);
		String workeractualmsg = workerhome.checksearchInvalidname();
		String workerexpectedmsg = PayrollConstant.WORKERNORESULT;
		Assert.assertEquals(workeractualmsg, workerexpectedmsg);
		Reporter.log("Searched Succesfully by Worker POSTCODE ", true);
	}
}
