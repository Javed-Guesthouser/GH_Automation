package Actions;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.TestProject.myPack.Finder;
import com.TestProject.myPack.Browser.GlobalVars;

import PageWisePOM.LoginPOM;
import Reporting.TestCaseReporting;
import Utils.Utility;
import dataProviders.Base;
import dataProviders.DriverSession;

public class Login {

	WebElement element = null;
	Utility utility = new Utility();

	public void clickAlreadyMember() throws IOException {
		element = LoginPOM.alredyMember();
		Keywords.Keywords.click(element);
		GlobalVars.SCREEN_SHOT_NAME = "Already Member";
		System.out.println("POJO in stepLogin is:-" + DriverSession.getLastExecutionReportingInstance());
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting(
					"Already Member Button should be clicked", "PASS", "Already Member Button clicked successfully");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting(
					"Already Member Button should be clicked", "FAIL", "Login Button could not be clicked..");

		}
	}

	public void enterUserID(Object userName) throws IOException {
		element = LoginPOM.userId();
		element.clear();
		// element.sendKeys(userName.toString());

		Keywords.Keywords.typeText(element, userName.toString());
		GlobalVars.SCREEN_SHOT_NAME = "User Name";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Email id should be entered.",
					"PASS", "Email id entered successfully");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Email id should be entered.",
					"FAIL", "Email id entered successfully");

		}
	}

	public void enterPassword(Object password) throws IOException {
		element = LoginPOM.password();
		element.clear();
		// element.sendKeys(password.toString());
		Keywords.Keywords.typeText(element, password.toString());
		GlobalVars.SCREEN_SHOT_NAME = "Password";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Password should be entered.",
					"PASS", "Password entered");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Password should be entered.",
					"FAIL", "Password could not be entered.");

		}
	}

	public void rememberME() throws IOException {
		element = LoginPOM.rememberMe();
		Keywords.Keywords.click(element);
		GlobalVars.SCREEN_SHOT_NAME = "Remember Me";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("checkbox should be entered.",
					"PASS", "checkbox entered");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("checkbox should be entered.",
					"FAIL", "checkbox could not be entered.");

		}
	}

	public void login() throws IOException {
		element = LoginPOM.logIn();
		Keywords.Keywords.click(element);
		GlobalVars.SCREEN_SHOT_NAME = "Login";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting(
					"Login submit button should be clicked", "PASS", "Login Submit button clicked successfully.");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting(
					"Login submit button should be clicked", "FAIL", "Login submit button could not be clicked");

		}
	}

	public void clickLoginButton() throws IOException {
		element = LoginPOM.loginButton();
		Keywords.Keywords.click(element);
		GlobalVars.SCREEN_SHOT_NAME = "Login Button";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Login Button should be clicked",
					"PASS", "Login Button clicked successfully");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Login Button should be clicked",
					"FAIL", "Login Button could not be clicked");

		}
	}

	public void verifyLoginSuccessfull() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In login verification part...");
		Thread.sleep(10000);
		WebElement loginCnf = LoginPOM.confirmLogin();
		Keywords.Keywords.isElementPresent(loginCnf);

		GlobalVars.SCREEN_SHOT_NAME = "Login Successfull..";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastExecutionReportingInstance().testStepReporting("Should Logg in Successfully", "PASS",
					"Logged In Successfully");

		} else {
			utility.capturePassScreenShot();
			DriverSession.getLastExecutionReportingInstance().testStepReporting("Should Logg in Successfully", "FAIL",
					"Login Failed");
		}

	}

}
