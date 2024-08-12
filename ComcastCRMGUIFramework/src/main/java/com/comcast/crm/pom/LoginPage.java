package com.comcast.crm.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * contains elements of login page
 */
public class LoginPage extends WebDriverUtility {
	WebDriver driver=null;
	@FindBy(name="user_name")
	WebElement userEdt;
	@FindBy(name="user_password")
	WebElement passwordEdt;
	@FindBy(id="submitButton")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * login to application based on username, password, url arguments
	 * @param URL
	 * @param username
	 * @param password
	 */
	public void getLogin(String URL,String username,String password)
	{
		waitForPageToLoad(driver);
		driver.get(URL);
		maximizeBrowser(driver);
		userEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
