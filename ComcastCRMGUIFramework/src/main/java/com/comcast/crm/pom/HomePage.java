package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	@FindBy(linkText="Organizations")
	private WebElement orgLink;

	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminBtn;
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreBtn;
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	@FindBy(linkText="Leads")
	private WebElement leadsLink;



	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getAdminBtn() {
		return adminBtn;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	

	public WebElement getMoreBtn() {
		return moreBtn;
	}
	



	public WebElement getLeadsLink() {
		return leadsLink;
	}



	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	//logout business library
	public void setSignOut(WebDriverUtility wLib)
	{

		wLib.actionsMoveToElement(driver, adminBtn);
		signoutLink.click();
	}
	public void getCampaign(WebDriverUtility wLib)
	{
		
		wLib.actions(driver).moveToElement(moreBtn).perform();
		getCampaignsLink().click();
		
	}

}
