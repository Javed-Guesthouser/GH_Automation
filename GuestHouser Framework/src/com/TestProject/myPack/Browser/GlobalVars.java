package com.TestProject.myPack.Browser;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

public class GlobalVars {

	public static final String SUITE_CASE_NAME = "GuestHouser";
	public static final String STATUS = null;

	public static WebDriver Web_Driver = null;
	public static String ExcelPath;
	// public static String ExcelPath = System.getProperty("user.dir") +
	// "/GuestHouserDB.xlsx";
	public static String sheetName;
	public static XSSFSheet DataSheet = null;

	public static String URL;
	public static String driverPath;
	public static String Browser;
	public static String TEST_CASE_SHEET_NAME;
	public static String PROJ_NAME;
	public static int ITERATION_FLAG = 1;;
	public static String SCREEN_SHOT_NAME = null;
	public static XSSFSheet TEST_SHEET_NAME;
	public static List<Object> TEST_DATA;
	public static String TEST_CASE_NAME;
	public static String Module_TestCase_Name;
	public static boolean GHStepsReport;
	public static String SUITE_NAME;

}
