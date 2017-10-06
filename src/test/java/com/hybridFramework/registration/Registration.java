package com.hybridFramework.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.PageObject.RegistrationPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class Registration extends TestBase{
	
	private final Logger log = LoggerHelper.getLogger(Registration.class);
	
	@Test
	public void testLoginToApplication(){
		log.info(Registration.class.getName()+" started");
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage loginPage = new LoginPage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		loginPage.clickOnSignInLink();
		loginPage.enterRegistrationEmail();
		register.setMrRadioButton();
		register.setFirstName("firstName");
		register.setLastname("lastname");
		register.setPassword("password");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("yourAddressFirstName");
		register.setYourAddressLastName("yourAddressLastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9999999999");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
	}
	

}
