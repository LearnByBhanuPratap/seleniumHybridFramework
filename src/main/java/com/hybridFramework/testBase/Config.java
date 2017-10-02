package com.hybridFramework.testBase;

import java.util.Properties;

public class Config extends TestBase{
	
	private Properties OR;
	
	public Config(Properties OR){
		this.OR = OR;
	}
	public String getUserName() {
		return OR.getProperty("Username");
	}

	public String getPassword() {
		return OR.getProperty("Password");
	}

	public String getWebsite() {
		return OR.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(OR.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return OR.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return OR.getProperty("DtaBase.ConnectionStr");
	}
	public String getBrowser() {
		return OR.getProperty("Browser");
	}

}
