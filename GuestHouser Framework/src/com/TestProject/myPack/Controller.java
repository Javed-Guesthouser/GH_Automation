package com.TestProject.myPack;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;

import com.TestProject.myPack.Browser.Browser;
import com.TestProject.myPack.Browser.GlobalVars;

import ExcelUtility.ExcelConnection;
import PageWisePOM.SignUpPOM;
import Reporting.TestCaseReporting;
import Utils.Utility;
import dataProviders.ConfigFileReader;
import dataProviders.DriverSession;

public class Controller {

	public static void main(String[] args) throws InterruptedException {
		getOperatingSystemInfo();
		getSystemDateAndTime();
		try {// load prerequisites
			loadProperties();

			// Start Browser...
			Browser.openBrowser(GlobalVars.Browser, GlobalVars.URL, GlobalVars.driverPath);
			// Connect To Excel DataBase
			// connectExcelDataBase(GlobalVars.ExcelPath, GlobalVars.sheetName);
			connectExcelDataBase(GlobalVars.ExcelPath, GlobalVars.TEST_CASE_SHEET_NAME);
			// Invoke Sign Up process...
			// Action inv = new Action();For Module Testing..
			Action1 inv = new Action1();// For end-end reflection part...
			new Invoker().invokeTestCase();
			// validateSignUp();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TearDown...
			DriverSession.getLastExecutionReportingInstance().footer();
			
			new Utility().waitForElement(2);
			GlobalVars.Web_Driver.close();
			GlobalVars.Web_Driver.quit();
			System.out.println("Session closed.....");
		}
	}

	private static void loadProperties() throws IOException {
		// TODO Auto-generated method stub
		ConfigFileReader reader = new ConfigFileReader();
		reader.loadPropertiesFile();
		reader.getUrl();
		System.out.println("url obtained is:-" + GlobalVars.URL);
		reader.getDriverPath();
		reader.setBrowser();
		System.out.println("driver path initially is:-" + GlobalVars.driverPath);
		reader.getExcelPath();
		reader.getSheetName();
		reader.getTestCaseName();
		reader.getSuiteName();
	}

	public static void connectExcelDataBase(String ExcelPath, String sheetName) throws IOException {
		System.out.println("Excel File path and sheeName  sent are:--" + ExcelPath + " ; " + sheetName);
		ExcelConnection connection = new ExcelConnection();
		connection.buildConnection(ExcelPath, sheetName);
	}

	private static void validateSignUp() {
		// TODO Auto-generated method stub
		WebElement validate = SignUpPOM.validateSignUp();
		if (validate != null) {
			System.out.println("SignUpSuccessfull...");
		}
	}

	private static void getSystemDateAndTime() {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}

	private static void getOperatingSystemInfo() {
		// TODO Auto-generated method stub
		System.out.println(
				"SUITE EXECUTION ON " + System.getProperty("os.name") + ";" + System.getProperty("os.version"));
	}

}
