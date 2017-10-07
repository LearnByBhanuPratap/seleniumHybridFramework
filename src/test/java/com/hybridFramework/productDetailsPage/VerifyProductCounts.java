package com.hybridFramework.productDetailsPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.HomePage;
import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.PageObject.ProductCategoryPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

/**
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class VerifyProductCounts extends TestBase{
	private final Logger log = LoggerHelper.getLogger(VerifyProductCounts.class);
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void testVerifyProductCounts(){
		log.info(VerifyProductCounts.class.getName()+" started");	
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		
		homePage = new HomePage(driver);
		ProductCategoryPage pCate = homePage.clickOnMenu(homePage.womenMenu);
		pCate.selectColor(pCate.Orange);
		int count = pCate.getTotalProducts();
		
		if(count==3){
			log.info("product count is matching");
		}
		else{
			Assert.assertTrue(false,"product count is not matching");	
		}
		
	}

}
