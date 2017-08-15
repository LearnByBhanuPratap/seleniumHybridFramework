package com.hybridFramework.excelTutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ColorAnyCellInRangeWhoseValueIsBetweenAconfiguredRange {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(new File("Demoformula.xlsx"));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Creating some random values
		sheet.createRow(0).createCell(0).setCellValue(84);
		sheet.createRow(1).createCell(0).setCellValue(74);
		sheet.createRow(2).createCell(0).setCellValue(50);
		sheet.createRow(3).createCell(0).setCellValue(51);
		sheet.createRow(4).createCell(0).setCellValue(49);
		sheet.createRow(5).createCell(0).setCellValue(41);

		SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();

		// Condition 1: Cell Value Is greater than 70 (Blue Fill)
		ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule(ComparisonOperator.GT, "70");
		PatternFormatting fill1 = rule1.createPatternFormatting();
		fill1.setFillBackgroundColor(IndexedColors.BLUE.index);
		fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

		// Condition 2: Cell Value Is less than 50 (Green Fill)
		ConditionalFormattingRule rule2 = sheetCF.createConditionalFormattingRule(ComparisonOperator.LT, "50");
		PatternFormatting fill2 = rule2.createPatternFormatting();
		fill2.setFillBackgroundColor(IndexedColors.GREEN.index);
		fill2.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

		CellRangeAddress[] regions = { CellRangeAddress.valueOf("A1:A6") };

		sheetCF.addConditionalFormatting(regions, rule1, rule2);
		
	    
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
