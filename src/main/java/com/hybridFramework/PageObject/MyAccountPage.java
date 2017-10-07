package com.hybridFramework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.helper.assertionHelper.VerificationHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;
/**
 * 
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class MyAccountPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	WebElement successRegistrationMsg;
	
	@FindBy(xpath="//*[contains(text(),'Order history and details')]")
	WebElement OrderHistoryAndDetails;
	
	@FindBy(xpath="//*[contains(text(),'My personal information')]")
	WebElement MyPersonalInformation;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, OrderHistoryAndDetails,new Config(TestBase.OR).getExplicitWait());
	}
	
	public boolean verifySuccessRegistrationMsg(){
		return VerificationHelper.verifyElementPresent(successRegistrationMsg);
	}
}
