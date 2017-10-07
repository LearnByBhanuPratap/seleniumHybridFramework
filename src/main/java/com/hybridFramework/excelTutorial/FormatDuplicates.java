package com.hybridFramework.excelTutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class FormatDuplicates {
	
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(new File("Demoformula.xlsx"));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		sheet.createRow(0).createCell(0).setCellValue("Code");
	    sheet.createRow(1).createCell(0).setCellValue(4);
	    sheet.createRow(2).createCell(0).setCellValue(3);
	    sheet.createRow(3).createCell(0).setCellValue(6);
	    sheet.createRow(4).createCell(0).setCellValue(3);
	    sheet.createRow(5).createCell(0).setCellValue(5);
	    sheet.createRow(6).createCell(0).setCellValue(8);
	    sheet.createRow(7).createCell(0).setCellValue(0);
	    sheet.createRow(8).createCell(0).setCellValue(2);
	    sheet.createRow(9).createCell(0).setCellValue(8);
	    sheet.createRow(10).createCell(0).setCellValue(6);
	 
	    SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
	 
	    // Condition 1: Formula Is   =A2=A1   (White Font)
	    ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("COUNTIF($A$2:$A$11,A2)>1");
	    FontFormatting font = rule1.createFontFormatting();
	    font.setFontStyle(false, true);
	    font.setFontColorIndex(IndexedColors.BLUE.index);
	 
	    CellRangeAddress[] regions = {
	            CellRangeAddress.valueOf("A2:A11")
	    };
	 
	    sheetCF.addConditionalFormatting(regions, rule1);
	 
	    sheet.getRow(2).createCell(1).setCellValue("<== Duplicates numbers in the column are highlighted.  " +
	            "Condition: Formula Is =COUNTIF($A$2:$A$11,A2)>1   (Blue Font)");
	    
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
