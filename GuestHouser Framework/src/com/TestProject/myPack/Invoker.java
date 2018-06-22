
package com.TestProject.myPack;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.TestProject.myPack.Browser.GlobalVars;

import ExcelUtility.ExcelConnection;
import Reporting.SuiteReporting;
import Reporting.TestCaseReporting;
import Reporting.TestStepReporting;
import dataProviders.Base;
import dataProviders.DriverSession;

public class Invoker {
	ExcelConnection excel = new ExcelConnection();

	public void invokeTestCase() throws Exception {
		System.out.println("test case invocation part...");
		TestCaseReporting testCaseReporting = new TestCaseReporting();
		TestStepReporting testStepReporting = new TestStepReporting();

		SuiteReporting suiteReporting = new SuiteReporting();
		DriverSession.setLastExecutionReportingInstance(testCaseReporting);
		DriverSession.setLastStepExecutionReporingInstance(testStepReporting);
		Object[] o = null;
		Action1 action = new Action1();
		Class<?> clazz;
		String actionComponent;
		Method[] method;
		clazz = action.getClass();
		method = clazz.getDeclaredMethods();
		suiteReporting.header();
		testCaseReporting.header();
		
		System.out.println("total declared test cases are:-" + Arrays.toString(method));
		int j = 0;// to always fetch first column...
		for (int i = 1; i < GlobalVars.TEST_SHEET_NAME.getPhysicalNumberOfRows(); i++) {
			try {
				// set the TEST_DATA_SHEET corresponding to the name of TestCase to fetch
				// TestData
				// For every new Test case its corresponding testcase Data Sheet will be invoked
				actionComponent = GlobalVars.TEST_SHEET_NAME.getRow(i).getCell(j).toString();
				GlobalVars.TEST_CASE_NAME = actionComponent.toString();
				System.out.println("Test case to be invoked is:-->" + GlobalVars.TEST_CASE_NAME);
				// Fetch All Test Data from Sheet defined by sheetName corresponding to test
				// case in TEST_CASE_SHEET
				// Each time for each test case it will set TEST_DATA with new testDAta..
				excel.fetchTestCaseData(0);
				testStepReporting.header();
				System.out.println("pojo stepgetter in invokerss user id is:--" + testStepReporting);
				
				// dynamically invoke function corresponding to Test case...
				for (Method m : method) {
					try {
						if (m.getName().equalsIgnoreCase(actionComponent)) {
							m.invoke(action, o);
							break;
						}

					} catch (Exception e) {
						e.printStackTrace();
						GlobalVars.Web_Driver.quit();
					}
				} // clearing the TestData list to fill with new data
				GlobalVars.TEST_DATA.clear();
				DriverSession.getLastStepExecutionReportingInstance().footer();
				suiteReporting.writeSuite();

			}

			catch (Exception e) {
			} finally {

			}
		}
		
	}
}
