package com.hybridFramework.excelTutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class UpdateTestResultInExcel {

	public static void updateResult(String excellocation, String sheetName, String testCaseName, String testStatus)
			throws IOException {

		FileInputStream file = new FileInputStream(new File(excellocation));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet(sheetName);
		// count number of active tows
		int totalRow = sheet.getLastRowNum() + 1;
		// count number of active columns in row
		for (int i = 1; i < totalRow; i++) {
			XSSFRow r = sheet.getRow(i);
			String ce = r.getCell(1).getStringCellValue();
			if (ce.contains(testCaseName)) {

				r.createCell(2).setCellValue(testStatus);
				file.close();

				System.out.println("done");
				FileOutputStream outFile = new FileOutputStream(new File(excellocation));
				workbook.write(outFile);
				outFile.close();
				break;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		String excellocation = System.getProperty("user.dir") + "/demo.xlsx";
		updateResult(excellocation, "TestReport", "Registration", "Pass");
		updateResult(excellocation, "TestReport", "Payment", "Fail");
		updateResult(excellocation, "TestReport", "CancelTest", "Pass");
	}
}
