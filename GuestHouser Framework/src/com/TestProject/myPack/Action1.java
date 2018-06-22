package com.TestProject.myPack;

import java.io.IOException;

import com.TestProject.myPack.Browser.GlobalVars;

import Actions.Login;
import Actions.Logout;
import ApplicationComponent.ApplicationComponent;
import Utils.Utility;

public class Action1 implements ApplicationComponent {
	Login login = new Login();
	Logout logout = new Logout();
	Utility utility = new Utility();
	Verifier verifier = new Verifier();

	@Override
	public void login() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Inside login test case.....");
		login.clickLoginButton();
		login.clickAlreadyMember();
		System.out.println("sending user name..");
		login.enterUserID(GlobalVars.TEST_DATA.get(0));
		login.enterPassword(GlobalVars.TEST_DATA.get(1));
		if (GlobalVars.TEST_DATA.get(2).toString().equalsIgnoreCase("yes")) {
			login.rememberME();

		}
		login.login();
		login.verifyLoginSuccessfull();

	}

	public void logout() throws InterruptedException, IOException {
		System.out.println("Logging out...");
		logout.hoverOnSignOut();
		utility.waitForElement(5);
		logout.clickLogout();
		verifier.verifyLogout();
	}

}
