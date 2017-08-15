package com.hybridFramework.homepage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridFramework.testBase.TestBase;

public class TestDataDriverScript extends TestBase{
	
	@DataProvider(name="testData")
	public Object[][] dataSource(){
		return getData("TestData.xlsx", "LoginTestData");
	}
	
	@Test(dataProvider="testData")
	public void testLogin(String userName, String password, String runmode){
		System.out.println("userName:-"+userName);
		System.out.println("password:-"+password);
		System.out.println("runmode:-"+runmode);
		//driver.findElement(By.xpath("")).sendKeys(userName);
		//driver.findElement(By.xpath("")).sendKeys(password);
		//driver.findElement(By.xpath("")).sendKeys(runmode);
	}

}
