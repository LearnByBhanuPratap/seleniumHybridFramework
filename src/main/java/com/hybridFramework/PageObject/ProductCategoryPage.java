package com.hybridFramework.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.DropDown.DropDownHelper;
import com.hybridFramework.helper.Javascript.JavaScriptHelper;
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
public class ProductCategoryPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);
	WaitHelper waitHelper;
	
	public String Black = "Black";
	public String Orange = "Orange";
	public String Yellow = "Yellow";
	
	@FindBy(xpath="//*[@id='layered_block_left']/p")
	WebElement catalogTextObj;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
	WebElement productAddedSucessfully;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[4]/div/div[2]/div[2]/a[1]/span")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckOut;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li")
	List<WebElement> totalProducts;
	
	@FindBy(xpath="//*[@id='selectProductSort']")
	public WebElement sortBy;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[2]/div/span[1]")
	List<WebElement> allpriceElements;
	
	
	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, catalogTextObj,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void mouseOverOnProduct(int number){
		String fPart = "//*[@id='center_column']/ul/li[";
		String sPart = "]/div/div[2]/h5/a";
		Actions action = new Actions(driver);
		log.info("doing mouse over on: "+number+"..product");
		action.moveToElement(driver.findElement(By.xpath(fPart+number+sPart))).build().perform();
	}
	
	public void clickOnAddToCart(){
		log.info("clickin on add to cart");
		addToCart.click();
	}
	
	public boolean verifyPoductAddedSuccesfully(){
		return VerificationHelper.verifyElementPresent(productAddedSucessfully);
	}
	
	public void clickOnProceedTocheckOut(){
		log.info("clickin on :"+proceedToCheckOut.getText());
		proceedToCheckOut.click();
	}
	
	public void selectColor(String data){
		new JavaScriptHelper(driver).scrollIntoView(driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")));
		driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectSmallSize() {
		log.info("selecting small size..");
		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
	}

	public void selectMediumSize() {
		log.info("selecting Medium size..");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']']")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']']")).click();
				log.info("checkbox is checked..");
			}
		} catch (Exception e) {
			log.info("checkbox was already checked..");
		}
	}

	public void selectLSize() {
		log.info("selecting Large size..");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();
				log.info("checkbox is checked..");
			}
		} catch (Exception e) {
			log.info("checkbox was already checked..");
		}
	}
	
	public void selectFirstProduct() {
		Actions obj = new Actions(driver);
		log.info("performning mouse over on first product of page..");
		obj.moveToElement(driver.findElements(By.xpath(".//*[@id='center_column']/ul/li")).get(0)).build().perform();
		log.info("clicking on add to basket..");
		driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();
	}
	
	public int getTotalProducts(){
		return totalProducts.size();
	}
	
	public List<WebElement> getAllProductsPrice(){
		return allpriceElements;
	}
	
	public void selectSortByFilter(String dataToSelect){
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.SelectUsingVisibleText(sortBy, dataToSelect);
	}
}
