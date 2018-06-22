package com.TestProject.myPack;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.TestProject.myPack.Browser.GlobalVars;

import PageWisePOM.LogoutPOM;
import Utils.Utility;
import dataProviders.DriverSession;

public class Verifier {
	Utility utility = new Utility();

	public void verifyLogout() throws IOException {
		WebElement logoutVerified = LogoutPOM.verifyLogout();
		Keywords.Keywords.isElementPresent(logoutVerified);

		GlobalVars.SCREEN_SHOT_NAME = "Logout Status..";
		if (GlobalVars.GHStepsReport) {
			utility.capturePassScreenShot();
			DriverSession.getLastExecutionReportingInstance().testStepReporting("Should Log out Successfully", "PASS",
					"Logged out Successfully");

		} else {
			utility.capturePassScreenShot();
			DriverSession.getLastExecutionReportingInstance().testStepReporting("Should Logg out Successfully", "FAIL",
					"Logg out Failed");
		}
	}
}
