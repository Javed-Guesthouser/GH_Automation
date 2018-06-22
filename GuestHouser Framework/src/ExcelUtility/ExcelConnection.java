package ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.TestProject.myPack.Browser.GlobalVars;

public class ExcelConnection {

	public void buildConnection(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream in = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(in);
		XSSFSheet sheet = (XSSFSheet) workbook.getSheet(sheetName);
		System.out.println("in excel connection.." + sheet);
		// GlobalVars.DataSheet = sheet; Uncomment for Module testing
		GlobalVars.TEST_SHEET_NAME = sheet;

	}

	public void fetchTestCaseData(int rowNumber) throws Exception {
		try {
		List<Object> rowData = new ArrayList<Object>();
		Workbook workbook = openWorkbook(GlobalVars.ExcelPath);
		XSSFSheet sheet = getSheetHandel(workbook, GlobalVars.TEST_CASE_NAME.toString());
		rowData = fetchRowData(sheet, rowNumber);
		System.out.println("Test Data LIst is:--" + rowData);
		closeWorkbook(workbook);
		GlobalVars.TEST_DATA = rowData;
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	private XSSFSheet getSheetHandel(Workbook workbook, String sheetName) {
		// TODO Auto-generated method stub
		return (XSSFSheet) workbook.getSheet(GlobalVars.TEST_CASE_NAME.toString());

	}

	public Workbook openWorkbook(String xlFilePath) throws Exception {
		// return Workbook.getWorkbook(new File(xlFilePath));
		XSSFWorkbook workbook = new XSSFWorkbook(new File(xlFilePath));
		return workbook;
	}

	public List<Object> fetchRowData(XSSFSheet sheet, int rowNumber) {
		List<Object> rowData = new ArrayList<Object>();

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			{
				for (int j = 0; j < sheet.getRow(j).getPhysicalNumberOfCells(); j++) {

					rowData.add(sheet.getRow(i).getCell(j));
				}
			}

		}
		return rowData;
	}

	public void closeWorkbook(Workbook workbook) throws Exception {
		workbook.close();
	}
}
