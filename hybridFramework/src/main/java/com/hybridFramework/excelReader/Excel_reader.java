package com.hybridFramework.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reader {

	public String[][] getExcelData(String excellocation, String sheetName) {
		try {
			String dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active tows
			int totalRow = sheet.getLastRowNum() + 1;
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow][totalColumn];
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
	
			int i = 0;
			while (rowIterator.hasNext()) {
				int p = i++;
				
				Row row = rowIterator.next();
				
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
                int j=0;
				while (cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						dataSets[p][j++] = cell.getStringCellValue();
						System.out.print(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						dataSets[p][j++] = cell.getStringCellValue();
						System.out.print(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						dataSets[p][j++] = cell.getStringCellValue();
						System.out.print(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						dataSets[p][j++] = cell.getStringCellValue();
						System.out.print(cell.getStringCellValue());
						break;
					}
				}
				System.out.println("");
			}
			file.close();
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String excellocation = "/Users/bsingh5/Documents/appium/hybridFramework/src/main/java/com/hybridFramework/data/TestData.xlsx";
		String sheetName = "LoginTestData";
		Excel_reader excel = new Excel_reader();
		excel.getExcelData(excellocation, sheetName);

	}
}
