package dataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.TestProject.myPack.Browser.GlobalVars;

public class ConfigFileReader {
	Properties prop = new Properties();
	private final String propFile = System.getProperty("user.dir") + "/Configs/Configuration.properties";

	public void loadPropertiesFile() throws IOException {
		System.out.println("location is:-" + propFile);
		FileInputStream in = null;
		try {
			in = new FileInputStream(new File(propFile));
			try {
				prop.load(in);
			} catch (Exception e) {
				System.out.println("Exception raised while loading");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// in.close();
		}
	}

	public void getUrl() {
		GlobalVars.URL = prop.getProperty("URL");
	}

	public void getExcelPath() {
		GlobalVars.ExcelPath = prop.getProperty("ExcelPath");
	}

	public void getDriverPath() {
		GlobalVars.driverPath = prop.getProperty("driverpath");
	}

	public void setBrowser() {
		GlobalVars.Browser = prop.getProperty("Browser");
	}

	public void getSheetName() {
		GlobalVars.sheetName = prop.getProperty("sheetName");
	}
	public void getTestCaseName()
	{
		GlobalVars.TEST_CASE_SHEET_NAME = prop.getProperty("TestSheet");
	}
	public void getmoduleTestCaseName() {
		GlobalVars.Module_TestCase_Name = prop.getProperty("TestCase");
	}
	public void getSuiteName() {
		GlobalVars.SUITE_NAME = prop.getProperty("suiteName");
	}
	

}
