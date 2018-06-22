package Reporting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.TestProject.myPack.Browser.GlobalVars;

public class SuiteReporting {
	public OutputStream consolidateHtmlFile;
	public PrintStream consolidatePrintHtml;
	public FileInputStream fis = null;
	public BufferedReader reader = null;
	private int totalPassTestCase = 0;
	public int totalFailTestCase = 0;
	public long sStartTimeConsolidate = 0;
	public long sEndTimeConsolidate = 0;
	public File f1;

	// File opening operations
	public void openConsolidateFile() throws FileNotFoundException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/ HH:mm:ss");
		Date date = new Date();

		System.out.println(dateFormat.format(date));
		// f1= new File("D:/Generic/"+GlobalVar.USER_NAME);
		String str = System.getProperty("user.dir");
		System.out.println("project path is:-" + str);
		int index = str.lastIndexOf("\\");
		System.out.println("index is:--" + index);
		GlobalVars.PROJ_NAME = str; // str.substring(index + 1);
		System.out.println("Iteration flag received in open file is:--" + GlobalVars.ITERATION_FLAG);

		f1 = new File("/Users/ahmedjaved/Desktop/" + GlobalVars.PROJ_NAME + "/" + GlobalVars.SUITE_NAME);
		System.out.println("****" + f1);
		f1.mkdir();

		new File(f1 + "/TestCaseReporting").mkdirs();
		new File(f1 + "/TestStepReporting").mkdirs();

		new File(f1 + "/Snapshots/Fail Images").mkdirs();
		new File(f1 + "/Snapshots/Pass Images").mkdirs();
		System.out.println("snapshot created");
		consolidateHtmlFile = new FileOutputStream(f1 + "/suiteReport.html");
		consolidatePrintHtml = new PrintStream(consolidateHtmlFile);
	}

	// Header Definitions
	public void header() {
		try {
			openConsolidateFile();
			consolidatePrintHtml.println("<html>");

			consolidatePrintHtml.println("<title> Test Script Report </title>");
			consolidatePrintHtml.println("<head></head>");
			consolidatePrintHtml.println("<body>");
			consolidatePrintHtml.println("<font face='Tahoma'size='2'>");

			consolidatePrintHtml.println("<h2 align='center'>" + "GUEST HOUSER AUTOMATION SUITE REPORT" + "</h2>");
			consolidatePrintHtml
					.println("<h3 align='right' ><font color='#000000' face='Tahoma' size='3'></font></h3>");
			consolidatePrintHtml.println("<table border='0' width='100%' height='47'>");
			consolidatePrintHtml.println("<tr>");
			consolidatePrintHtml.println(
					"<td width='30%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>TestCaseName</font></b></td>");
			consolidatePrintHtml.println(
					"<td width='20%' bgcolor='#CCCCFF'align='center'><b><font color='#000000' face='Tahoma' size='2'>Status</font></b></td>");
			consolidatePrintHtml.println(
					"<td width='30%' bgcolor='#CCCCFF'align='center'><b><font color='#000000' face='Tahoma' size='2'>Result File</font></b></td>");
			consolidatePrintHtml.println(
					"<td width='30%' bgcolor='#CCCCFF'align='center'><b><font color='#000000' face='Tahoma' size='2'>TestCase Percent</font></b></td>");
			consolidatePrintHtml.println("</tr>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void writeSuite() {
		// TODO Auto-generated method stub
		consolidatePrintHtml.println("<tr>");
		consolidatePrintHtml.append(
				"<td width='13%' bgcolor='#FFFFDC' valign='middle' align='left' ><font color='#000000' face='Tahoma' size='2'>"
						+ GlobalVars.SUITE_CASE_NAME + "</font></td>");
		consolidatePrintHtml.append(
				"<td width='13%' bgcolor='#FFFFDC' valign='middle' align='left' ><font color='#000000' face='Tahoma' size='2'>"
						+ GlobalVars.STATUS + "</font></td>");
		consolidatePrintHtml.append(
				"<td width='13%' bgcolor='#FFFFDC' valign='middle' align='center' ><font color='#000000' face='Tahoma' size='2'>"
						+ "<a href=\"" + "TestCaseReporting/" + "(" + GlobalVars.TEST_CASE_NAME + ")" + ".html"
						+ "\">Click to View" + GlobalVars.SUITE_CASE_NAME + " Result </a></font></td>");
	}
	
	
	

}
