package Reporting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.TestProject.myPack.Browser.GlobalVars;

public class TestCaseReporting {
	public OutputStream htmlFile;
	public PrintStream printhtml;
	private int PassCount = 0;
	private int FailCount = 0;
	private int infoCount = 0;
	public long startTime = 0;
	public long lastTime = 0;

	public void openFile() throws FileNotFoundException {
		// htmlFile=new
		// FileOutputStream("D:/Generic/"+GlobalVar.USER_NAME+"\\TestCaseReporting\\"+"("+GlobalVar.TEST_CASE_NAME+")"+".html");

		htmlFile = new FileOutputStream("/Users/ahmedjaved/Desktop/" + GlobalVars.PROJ_NAME + "/"
				+ GlobalVars.SUITE_NAME + "/TestCaseReporting/" + "TestCaseReporting" + ".html");
		
		printhtml = new PrintStream(htmlFile);
	}

	public void header() {
		try {

			openFile();
			printhtml.println("</table>");
			printhtml.println("<html>");
			printhtml.println("<title> Test Script Report </title>");
			printhtml.println("<head></head>");
			printhtml.println("<body>");
			printhtml.println("<font face='Tahoma'size='2'>");
			printhtml.println("<h2 align='center'>" + GlobalVars.TEST_CASE_NAME + " </h2>");
			printhtml.println("<h3 align='right' ><font color='#000000' face='Tahoma' size='3'></font></h3>");
			printhtml.println("<table border='1' width='100%' height='47'>");
			printhtml.println("<tr>");
			printhtml.println(
					"<td width='1%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'><i>TestCaseID</i></font></b></td>");
			printhtml.println(
					"<td width='40%' bgcolor='#CCCCFF'align='center'><b><font color='#000000' face='Tahoma' size='2'><i>Expected Result</i></font></b></td>");
			printhtml.println(
					"<td width='40%' bgcolor='#CCCCFF'align='center'><b><font color='#000000' face='Tahoma' size='2'><i>Actual Result</i></font></b></td>");
			printhtml.println(
					"<td width='20%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'><i>StepResult</i></font></b></td>");
			printhtml.println(
					"<td width='28%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'><i>Pass/Fail</i></font></b></td>");
			printhtml.println(
					"<td width='28%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'><i>ScreenShot</i></font></b></td>");

			printhtml.println("</tr>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testStepReporting(String Expected, String Status, String Actual) {
		try {
			String nameOfScreenShot = "";
			String imgLink = "";
			// openFile();

			int TeststepCount = PassCount + FailCount + 1;

			printhtml.append("<tr>");

			printhtml.append(
					"<td width='10%' bgcolor='#FFFFDC' valign='middle' align='center' ><font color='#000000' face='Tahoma' size='2'>"
							+ TeststepCount + "</font></td>");
			printhtml.append(
					"<td width='16%' bgcolor='#FFFFDC' valign='top' align='justify' ><font color='#000000' face='Tahoma' size='2'>"
							+ Expected + "</font></td>");
			printhtml.append(
					"<td width='16%' bgcolor='#FFFFDC' valign='top' align='justify' ><font color='#000000' face='Tahoma' size='2'>"
							+ Actual + "</font></td>");

			printhtml.append(
					"<td width='15%' bgcolor='#FFFFDC' valign='middle' align='center' ><font color='#000000' face='Tahoma' size='2'>"
							+ "<a href= \"" + "../" + "TestStepReporting/" + GlobalVars.TEST_CASE_NAME + ".html" + "\">"
							+ GlobalVars.TEST_CASE_NAME + " </a></font></td>");

			if (Status.toUpperCase() == "PASS") {
				printhtml.append(
						"<td width='18%' bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='#008000' face='Tahoma' size='2'>"
								+ Status.toUpperCase

								() + "</font></b></td>");
				this.PassCount = this.PassCount + 1;
			}
			/*
			 * else if (strPassFail.toUpperCase() == "INFO") { printhtml
			 * .append("<td width='18%' bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='#000000' face='Tahoma' size='2'>"
			 * + strPassFail.toUpperCase
			 * 
			 * () + "</font></b></td>"); infoCount = infoCount + 1;
			 */
			// }
			else {
				printhtml.append(
						"<td width='18%' bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='Red' face='Tahoma' size='2'>"
								+ Status.toUpperCase() +

								"</font></b></td>");

				this.FailCount = this.FailCount + 1;
			}
			printhtml.append(
					"<td width='13%' bgcolor='#FFFFDC' valign='middle' align='center' ><font color='#000000' face='Tahoma' size='2'>"
							+ "<a href= \"" + "../" + "Snapshots/" + "Pass Images/" + GlobalVars.SCREEN_SHOT_NAME + " "
							+ ".png" + "\">Click to View </a></font></td>");

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Pass count is:--" + PassCount);
		System.out.println("Fail count is;--" + FailCount);
	}

	public void footer() {
		try {
			lastTime = getTime();
			System.out.println("Total test step count;-" + getTotoalTestStepCount());
			int SuccessRate = (PassCount * 100 / (getTotoalTestStepCount()));
			String FailRate = Integer.toString(100 - SuccessRate);
			int Passwidth = (300 * SuccessRate) / 100;
			String Failwidth = Integer.toString(300 - Passwidth);

			printhtml.println("<hr>");
			printhtml.println("<table border='0' width='50%'>");
			printhtml.println(
					"<tr><td width='100%' colspan='2' bgcolor='#000000'><b><font face='Tahoma' size='2' color='#FFFFFF'>Test Case Details :</font></b></td></tr>");
			printhtml.println(
					"<tr><td width='45%' bgcolor='#FFFFDC'><b><font face='Tahoma' size='2'>Total Steps Passed</font></b></td><td width='55%' bgcolor='#FFFFDC'><font face='Tahoma' size='2'>"
							+ getTotoalTestStepCount() + "</td></tr>");
			printhtml.println(
					"<tr><td width='45%' bgcolor='#FFFFDC'><b><font face='Tahoma' size='2'>Total Steps Failed</font></b></td><td width='55%' bgcolor='#FFFFDC'><font face='Tahoma' size='2'>"
							+ FailCount + "</td></tr>");
			printhtml.println(
					"<tr><td width='45%' bgcolor='#FFFFDC'><b><font face='Tahoma' size='2'>Executed On (DD.MM.YYYY)</font></b></td><td width='55%' bgcolor= '#FFFFDC'><font face='Tahoma' size='2'>"
							+ getSystemDate() + "</td></tr>");
			printhtml.println(
					"<tr><td width='45%' bgcolor='#FFFFDC'><b><font face='Tahoma' size='2'>Start Time (HH:MM:SS)</font></b></td><td width='55%' bgcolor= '#FFFFDC'><font face='Tahoma' size='2'>"
							+ getSystemTime(startTime) + "</td></tr>");
			printhtml.println(
					"<tr><td width='45%' bgcolor='#FFFFDC'><b><font face='Tahoma' size='2'>End Time (HH:MM:SS)</font></b></td><td width='55%' bgcolor= '#FFFFDC'><font face='Tahoma' size='2'>"
							+ getSystemTime(lastTime) + "</td></tr>");
			printhtml.println(
					"<tr><td width='45%' bgcolor='#FFFFDC'><b><font face='Tahoma' size='2'>Execution Time (MM.SS)</font></b></td><td width='55%' bgcolor= '#FFFFDC'><font face='Tahoma' size='2'>"
							+ getTotalExecutionTime(startTime, lastTime) + "</td></tr>");
			printhtml.println("</table>");
			printhtml.println("<table border=0 cellspacing=1 cellpadding=1 ></table>");
			printhtml.println(
					"<table border=0 cellspacing=1 cellpadding=1 ><tr><td width='100%' colspan='2' bgcolor='#000000'><b><font face='Tahoma' size='2' color='#FFFFFF'>Test Result Summary :</font></b></td></tr></table>");
			printhtml.println(
					"<table border=0 cellspacing=1 cellpadding=1 ><tr>  <td width=70 bgcolor= '#FFFFDC'><FONT  FACE='Tahoma' SIZE=2.75 ><b>Total Test</b></td> <td width=10 bgcolor= '#FFFFDC'><FONT  FACE='Tahoma' SIZE=2.75><b>:</b></td>     <td width=35 bgcolor= '#FFFFDC'><FONT FACE='Tahoma' SIZE=2.75><b>"
							+ getTotoalTestStepCount()
							+ "</b></td>  <td width=300 bgcolor='#E7A1B0'></td>  <td width=20><FONT COLOR='#000000' FACE='Tahoma' SIZE=1><b>100%</b></td></tr></table>");
			printhtml.println(
					"<table border=0 cellspacing=1 cellpadding=1 ><tr>  <td width=70 bgcolor= '#FFFFDC'><FONT  FACE='Tahoma' SIZE=2.75 ><b>Total Pass</b></td> <td width=10 bgcolor= '#FFFFDC'><FONT  FACE='Tahoma' SIZE=2.75><b>:</b></td>     <td width=35 bgcolor= '#FFFFDC'><FONT FACE='Tahoma' SIZE=2.75><b>"
							+ PassCount + "</b></td>  <td width= " + Passwidth
							+ " bgcolor='#008000'></td>  <td width=20><FONT COLOR='#000000' FACE='Tahoma' SIZE=1><b>"
							+ SuccessRate + "%</b></td></tr></table>");
			printhtml.println(
					"<table border=0 cellspacing=1 cellpadding=1 ><tr> <td width=70 bgcolor= '#FFFFDC'><FONT   FACE='Tahoma' SIZE=2.75 ><b>Total Fail</b></td>  <td width=10 bgcolor= '#FFFFDC'><FONT  FACE='Tahoma' SIZE=2.75><b>:</b></td>     <td width=35 bgcolor= '#FFFFDC'><FONT  FACE='Tahoma' SIZE=2.75><b>"
							+ FailCount + "</b></td>   <td width= " + Failwidth
							+ " bgcolor='#FF0000'></td>     <td width=20><FONT COLOR='#000000' FACE='Tahoma' SIZE=1><b>"
							+ FailRate + "%</b></td> </tr></table>");
			printhtml.println("</font>");
			printhtml.println("</body>");
			printhtml.println("</html>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getTotoalTestStepCount() {
		return (PassCount + FailCount);
	}

	public long getTime() {

		Date date = new Date();
		return date.getTime();
	}

	public String getSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String getSystemTime(long time) {
		DateFormat dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat("HH:mm:ss");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dateFormat.format(time);
	}

	public String getTotalExecutionTime(long starttime, long endtime) {

		long diff = endtime - starttime;

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		// long diffDays = diff / (24 * 60 * 60 * 1000);

		return (diffHours + ":" + diffMinutes + ":" + diffSeconds);

	}
}
