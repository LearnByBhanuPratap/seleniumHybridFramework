package com.hybridFramework.excelTutorial;

import java.io.IOException;

public class A {
	
	public static void main(String[] args) throws IOException {
		String excellocation = System.getProperty("user.dir") + "/demo.xlsx";
		UpdateTestResultInExcel.updateResult(excellocation, "TestReport", "Registration", "Pass");
		UpdateTestResultInExcel.updateResult(excellocation, "TestReport", "Payment", "Fail");
		UpdateTestResultInExcel.updateResult(excellocation, "TestReport", "CancelTest", "Pass");
	}

}
