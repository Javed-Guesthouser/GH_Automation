package dataProviders;

import org.openqa.selenium.WebDriver;

import Reporting.SuiteReporting;
import Reporting.TestCaseReporting;
import Reporting.TestStepReporting;

public class DriverSession {

	SuiteReporting suite;
	private static TestCaseReporting testaCaseReporting;
	private static TestStepReporting testStepReporting;

	public static void setLastExecutionReportingInstance(TestCaseReporting testReporting) {
		testaCaseReporting = testReporting;
	}

	public static TestCaseReporting getLastExecutionReportingInstance() {
		return testaCaseReporting;
	}

	public static void setLastStepExecutionReporingInstance(TestStepReporting StepReporting) {
		
		testStepReporting = StepReporting;
	}

	public static TestStepReporting getLastStepExecutionReportingInstance() {
		return testStepReporting;
	}

}
