package com.TestProject.myPack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.TestProject.myPack.Browser.GlobalVars;

import Actions.Login;
import Actions.LoginFacebook;
import Actions.LoginGoogle;
import Actions.Logout;
import Actions.SignUp;
import PageWisePOM.SignUpPOM;
import Reporting.SuiteReporting;
import Reporting.TestCaseReporting;
import Utils.ScreenCapture;
import Utils.Utility;

public class Action {
	String Expected, Actual, Status;
	Utility utility = new Utility();
	ScreenCapture screenCapture = new ScreenCapture();
	TestCaseReporting testCaseReporting = new TestCaseReporting();
	SuiteReporting suiteReporting = new SuiteReporting();
	SignUp obj = new SignUp();
	Login login = new Login();
	Logout logout = new Logout();
	List UserData = new ArrayList();
	LoginGoogle google = new LoginGoogle();
	LoginFacebook fb = new LoginFacebook();

	public void actionInvoker() throws Exception {
		// Suite Reporting invocation
		//
		// Test Reporting invocation

		System.out.println("physical rows are:-" + GlobalVars.DataSheet.getPhysicalNumberOfRows());
		String testCaseName = GlobalVars.Module_TestCase_Name;
		System.out.println("TestCase to invoke is:--" + testCaseName);
		for (int i = 1; i < GlobalVars.DataSheet.getPhysicalNumberOfRows(); i++) {
			GlobalVars.ITERATION_FLAG += 1;
			System.out.println("Iteration flag is:-" + GlobalVars.ITERATION_FLAG);
			suiteReporting.header();
			testCaseReporting.header();
			for (int j = 0; j < GlobalVars.DataSheet.getRow(i).getPhysicalNumberOfCells(); j++) {
				UserData.add(GlobalVars.DataSheet.getRow(i).getCell(j));
			}
			System.out.println("Data To send is;--" + UserData);
			// setting Reporting header...

			// signUP(UserData);
			switch (testCaseName.toLowerCase()) {
			case "signup":
				signUP(UserData);
				break;
			case "login":
				loginUser(UserData);
				break;
			case "loginwithfacebook":
				loginfb(UserData);
				break;
			case "loginwithgoogle":
				logingoogle(UserData);
				break;
			default:
				System.out.println("Wrong TestCase Chosen...");
			}
			testCaseReporting.footer();
			// Suite Writing...
			suiteReporting.writeSuite();
		}

	}

	private void setResult(String Expected, String Status, String Actual) {
		this.Expected = Expected;
		this.Actual = Actual;
		this.Status = Status;
	}

	private void passReportHandling(String str1, String status, String str2) throws Exception {
		try {
			System.out.println("IN passed reporting area");
			utility.capturePassScreenShot();
		} catch (Exception e) {
			System.out.println(GlobalVars.SCREEN_SHOT_NAME + " could not be captured");
		}
		// Report Handling
		testCaseReporting.testStepReporting(str1, status, str2);
	}

	private void failReportHandling() throws Exception {
		try {
			System.out.println("IN failed reporting area");
			utility.capturePassScreenShot();
		} catch (Exception e) {
			System.out.println(GlobalVars.SCREEN_SHOT_NAME + " could not be captured");
		}
		testCaseReporting.testStepReporting("TextBox should allow Text Writing", "FAIL", "Text writing not allowed");
	}

	public void signUP(List list) throws InterruptedException {

		try {
			utility.waitForElement(2);
			obj.signUp1();
			utility.waitForElement(5);

			obj.signUpWithEmail();
			utility.waitForElement(5);

			obj.enterName(list.get(0));
			utility.waitForElement(1);

			obj.enterLName(list.get(1));
			utility.waitForElement(1);

			obj.enterEmail(list.get(2));
			utility.waitForElement(1);

			obj.enterPassword(list.get(3));
			obj.submit();
			checkStatus(list.get(4));
		}
		// utility.SignUPvalidation();
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			// clear the list..
			UserData.clear();

		}

	}

	public void checkStatus(Object ph) throws InterruptedException {
		System.out.println("checking signUp Status....");

		WebElement status = new SignUpPOM().validateSignUp();
		System.out.println("SignUp validation status is:--" + status);
		if (status != null) {
			// obj.logout();
			obj.enterPhoneNumber(ph);
			obj.submitPhoneNumber();
		} else {
			System.out.println("Sign Up not successfull....");
			Thread.sleep(3000);
			SignUpPOM.closeSignUpDialog().click();

		}
		return;
	}

	private void loginUser(List loginData) throws Exception {
		// TODO Auto-generated method stub

		try {
			setResult("Button should allow clicking", "PASS", "Button clicked successfully");
			utility.waitForElement(1);
			login.clickLoginButton();
			GlobalVars.SCREEN_SHOT_NAME = "Login Button screenshot";
			passReportHandling(this.Expected, this.Status, this.Actual);

			setResult("Button should allow click", "PASS", "Button clicked successfully");
			login.clickAlreadyMember();
			GlobalVars.SCREEN_SHOT_NAME = "Already Member";
			passReportHandling(this.Expected, this.Status, this.Actual);

			setResult("Text Box should allow text typing", "PASS", "Text typed successfully");
			utility.waitForElement(1);
			login.enterUserID(loginData.get(0));
			GlobalVars.SCREEN_SHOT_NAME = "UserName";
			passReportHandling(this.Expected, this.Status, this.Actual);

			setResult("Text Box should allow typing", "PASS", "Text typed successfully");
			utility.waitForElement(1);
			login.enterPassword(loginData.get(1).toString().trim());
			GlobalVars.SCREEN_SHOT_NAME = "Password";
			passReportHandling(this.Expected, this.Status, this.Actual);

			if (loginData.get(2).toString().equalsIgnoreCase("yes")) {
				setResult("checkbox should accept click", "PASS", "Checkbox accepted successfully");
				utility.waitForElement(1);
				login.rememberME();
				GlobalVars.SCREEN_SHOT_NAME = "Remember Me";
				passReportHandling(this.Expected, this.Status, this.Actual);
			}

			setResult("Button should accept click", "PASS", "Button clicked successfully");
			utility.waitForElement(1);
			login.login();
			GlobalVars.SCREEN_SHOT_NAME = "SignIn Button";
			passReportHandling(this.Expected, this.Status, this.Actual);

			utility.checkLoginStatus();

		} catch (Exception e) {

			this.Status = "FAIL";
			failReportHandling();
		} finally {
			// Clear the list...
			loginData.clear();
		}

	}

	/*public void logout() throws InterruptedException {
		System.out.println("Logging out...");
		logout.hoverOnSignOut();
		utility.waitForElement(5);
		logout.clickLogout();
	}*/

	private void loginfb(List list) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			utility.waitForElement(5);
			fb.clickLoginButton();
			utility.waitForElement(1);

			fb.clickAlreadyMember();
			utility.waitForElement(1);

			fb.clickFBIcon();
			utility.waitForElement(2);

			utility.handleWindow();

			fb.enterMail(list.get(0));
			utility.waitForElement(1);

			fb.enterPassword(list.get(1));
			utility.waitForElement(1);

			fb.clicksubmit();
			utility.checkFacebookLoginStatus();
		} catch (Exception e) {

		} finally {
			list.clear();
		}
	}

	private void logingoogle(List list) {
		// TODO Auto-generated method stub
		try {
			utility.waitForElement(5);
			google.clickLoginButton();

			utility.waitForElement(1);
			google.alreadyMember();

			utility.waitForElement(1);
			google.clickGoogleIcon();

			utility.handleWindow();

			String status = utility.checkLastLogin(list.get(0));
			if (status != "Yes") {
				System.out.println("No already mail matched...");
				// google.loginWithAnotherUser();
				utility.waitForElement(1);
				google.enterEmail(list.get(0));
				google.clickNext();
			} else
				System.out.println("already a member..");

			utility.waitForElement(2);
			google.enterPassword(list.get(1));

			google.clickSignIn();

			utility.checkLoginStatus();
		} catch (Exception e) {

		} finally {
			list.clear();
		}

	}
}
