package com.hybridFramework.productDetailsPage;

import org.apache.log4j.Logger;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class VerifyColorFilter extends TestBase{
	private final Logger log = LoggerHelper.getLogger(VerifyColorFilter.class);
	
	public void testVerifyColorFilter(){
		log.info(VerifyColorFilter.class.getName()+" started");	
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
	}

}
