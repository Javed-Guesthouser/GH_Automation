package Actions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TestProject.myPack.Browser.GlobalVars;

import PageWisePOM.LogoutPOM;
import Utils.Utility;
import dataProviders.DriverSession;

public class Logout {
	Utility utility = new Utility();

	public void hoverOnSignOut() throws IOException {
		Actions action = new Actions(GlobalVars.Web_Driver);
		// action.moveToElement(LogoutPOM.logoutButton());

		WebElement element = LogoutPOM.logoutButton();
		Keywords.Keywords.click(element);
		GlobalVars.SCREEN_SHOT_NAME = "Logout button";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Logout Button should be clicked",
					"PASS", "Logout Button clicked successfully");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Logout Button should be clicked",
					"PASS", "Logout Button click failed..");

		}
	}

	public void clickLogout() throws IOException {
		WebElement element = LogoutPOM.logout();
		Keywords.Keywords.click(element);
		GlobalVars.SCREEN_SHOT_NAME = "logout";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Logout Button 1 should clicked",
					"PASS", "Logout Button clicked successfully");

		} else {
			utility.captureFailScreenShot();
			DriverSession.getLastStepExecutionReportingInstance().testStepReporting("Logout Button 2should be clicked",
					"FAIL", "Logout Button 1 click failed..");

		}
	}
}
