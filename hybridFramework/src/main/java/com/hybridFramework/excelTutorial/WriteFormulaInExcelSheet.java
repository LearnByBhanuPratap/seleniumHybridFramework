package com.hybridFramework.excelTutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFormulaInExcelSheet {

	public static void main(String[] args) 
	{
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Calculate Simple Interest");
	  
	    Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Pricipal");
	    header.createCell(1).setCellValue("RoI");
	    header.createCell(2).setCellValue("T");
	    header.createCell(3).setCellValue("Interest (P r t)");
	      
	    Row dataRow = sheet.createRow(1);
	    dataRow.createCell(0).setCellValue(14500);
	    dataRow.createCell(1).setCellValue(9.25);
	    dataRow.createCell(2).setCellValue(3);
	    dataRow.createCell(3).setCellFormula("A2*B2*C2");
	      
	    try {
	        FileOutputStream out =  new FileOutputStream(new File("Demoformula.xlsx"));
	        workbook.write(out);
	        out.close();
	        System.out.println("Excel with foumula cells written successfully");
	          
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
