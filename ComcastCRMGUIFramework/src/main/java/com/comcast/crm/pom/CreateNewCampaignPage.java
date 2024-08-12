package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	@FindBy(name="campaignname")
	private WebElement campaignNameEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	  
	
	public void createCampaign(String campName)
	{
		campaignNameEdt.sendKeys(campName);
		saveBtn.click();
	}
	
	

}
