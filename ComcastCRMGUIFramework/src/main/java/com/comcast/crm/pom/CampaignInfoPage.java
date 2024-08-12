package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	@FindBy(id="mouseArea_Campaign Name")
private WebElement campaignName;
	@FindBy(className="dvHeaderText")
	private WebElement campInfoHeader;
	public CampaignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCampaignName() {
		return campaignName;
	}
	public WebElement getCampInfoHeader() {
		return campInfoHeader;
	}
	
	
	
	
	
	
}
