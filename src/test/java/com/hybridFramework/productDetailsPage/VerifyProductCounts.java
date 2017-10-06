package com.hybridFramework.productDetailsPage;

import org.apache.log4j.Logger;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class VerifyProductCounts extends TestBase{
	private final Logger log = LoggerHelper.getLogger(VerifyProductCounts.class);
	
	public void testVerifyProductCounts(){
		log.info(VerifyProductCounts.class.getName()+" started");	
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
	}

}
